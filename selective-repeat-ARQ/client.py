import hashlib
import pickle
import threading
import time
from socket import *
import random
from collections import OrderedDict

HOST = gethostbyname('localhost')
PORT = 12345

SERVER_ADDRESS = (HOST, PORT)

# takes the file name as command line arguments
FILE_NAME = 'client-img.jpg'

# create client socket
SELECTIVE_REPEAT = None

ACK_SUCCESSFUL = 1
ACK_FAILED = 0

# initializes WINDOW variables (upper and lower WINDOW bounds, position of next seq number)
NEXT_SEQ_NO = 1
WINDOW_SIZE = 7
WINDOW = OrderedDict()
DONE = False

RE_TRANSMISSION_COUNT = 0

FORCE_ERROR = True


def transmit(gbn_client, param: bytes, address: tuple):
    if FORCE_ERROR and random.randrange(0, 1000) % 53 == 0:
        return
    gbn_client.sendto(param, address)
    # print("sending data - > ", param)


def append_check_sum(data):
    h = hashlib.md5()
    h.update(pickle.dumps(data))
    data.append(h.digest())


def verify_check_sum(data):
    recv_check_sum = data[-1]
    del data[-1]
    h = hashlib.md5()
    h.update(pickle.dumps(data))
    return recv_check_sum == h.digest()


last_transmit_time = time.time()


def retransmit_window(lock):
    global last_transmit_time
    global SELECTIVE_REPEAT, SERVER_ADDRESS, RE_TRANSMISSION_COUNT
    if time.time() - last_transmit_time > 0.05:
        with lock:
            for i in WINDOW:
                i = WINDOW[i]
                transmit(SELECTIVE_REPEAT, pickle.dumps(i), SERVER_ADDRESS)
            print("window retransmitted")
            RE_TRANSMISSION_COUNT += len(WINDOW)
            last_transmit_time = time.time()


def uploading_thread_task(lock):
    global NEXT_SEQ_NO, SERVER_ADDRESS, WINDOW, DONE, SELECTIVE_REPEAT
    with lock:
        print("starting uploading thread")
    file_open = open(FILE_NAME, 'rb')
    data = file_open.read(512)

    while not DONE:
        # with lock:
        #     print("Window : ", WINDOW.keys())
        if len(WINDOW) < WINDOW_SIZE:
            send_packet = [NEXT_SEQ_NO, data]
            append_check_sum(send_packet)

            transmit(SELECTIVE_REPEAT, pickle.dumps(send_packet), SERVER_ADDRESS)

            with lock:
                # append packet to WINDOW
                WINDOW[NEXT_SEQ_NO] = send_packet
                # increment variable NEXT_SEQ_NO
                print("Sent data", NEXT_SEQ_NO)
                NEXT_SEQ_NO = NEXT_SEQ_NO + 1
                if not data:
                    DONE = True

            # read more data
            data = file_open.read(512)
        else:
            time.sleep(0.001)
            retransmit_window(lock)

        if len(WINDOW) > 0 and NEXT_SEQ_NO - next(iter(WINDOW)) > 30:
            retransmit_window(lock)
    file_open.close()
    with lock:
        print("finishing uploading thread")


def acknowledging_thread_task(lock):
    global NEXT_SEQ_NO, SERVER_ADDRESS, WINDOW, DONE, SELECTIVE_REPEAT, RE_TRANSMISSION_COUNT
    with lock:
        print("starting acknowledging thread")
    last_ack_received = time.time()
    while not DONE or len(WINDOW) > 0:
        # with lock:
        #     print("Window : ", WINDOW.keys())
        try:
            packet, SERVER_ADDRESS = SELECTIVE_REPEAT.recvfrom(4096)
            # data -> [ack_type, seq_no , check_sum]
            rcv_packet = pickle.loads(packet)
            # check value of checksum received (c) against checksum calculated (h)
            if verify_check_sum(rcv_packet):
                ack_type = rcv_packet[0]
                seq_no = rcv_packet[1]
                if ack_type == ACK_SUCCESSFUL:
                    with lock:
                        print("Received positive ack for", seq_no)
                        if seq_no in WINDOW:
                            last_ack_received = time.time()
                            WINDOW.pop(seq_no)
                            # print("removing frame : ", seq_no)
                        else:
                            print("seq not found in window ", seq_no)
                else:
                    with lock:
                        print(" <- RECEIVED NEGATIVE ACK for", seq_no)
                    if seq_no in WINDOW:
                        last_ack_received = time.time()
                        send_packet = WINDOW[seq_no]
                        transmit(SELECTIVE_REPEAT, pickle.dumps(send_packet), SERVER_ADDRESS)

                        with lock:
                            RE_TRANSMISSION_COUNT += 1
                            print("Resending data of seq_no ", seq_no)
                    else:
                        with lock:
                            print("seq not found in window ", seq_no)
            else:
                with lock:
                    print("error in acknowledgement")
            # TIMEOUT
        except:
            if time.time() - last_ack_received > 3 and DONE:
                break
            if time.time() - last_ack_received > 0.01:
                retransmit_window(lock)
    with lock:
        print("finishing acknowledging thread")


def main():
    global NEXT_SEQ_NO, SERVER_ADDRESS, SELECTIVE_REPEAT, RE_TRANSMISSION_COUNT
    SELECTIVE_REPEAT = socket(AF_INET, SOCK_DGRAM)
    SELECTIVE_REPEAT.settimeout(0.01)

    lock = threading.RLock()

    uploading_thread = threading.Thread(target=uploading_thread_task, args=(lock,))
    acknowledging_thread = threading.Thread(target=acknowledging_thread_task, args=(lock,))

    uploading_thread.start()
    acknowledging_thread.start()

    uploading_thread.join()
    acknowledging_thread.join()

    print("connection closed")
    print("Re transmission count", RE_TRANSMISSION_COUNT)
    SELECTIVE_REPEAT.close()


if __name__ == "__main__":
    main()
