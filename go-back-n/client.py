import collections
import hashlib
import pickle
import threading
import time
from socket import *
import random

HOST = gethostbyname('localhost')
PORT = 12345

server_address = (HOST, PORT)

# takes the file name as command line arguments
FILE_NAME = 'client-img.jpg'

# create client socket
go_back_n_client = None

RE_TRANSMISSION_COUNT = 0
# initializes window variables (upper and lower window bounds, position of next seq number)
BASE = 1
NEXT_SEQ_NO = 1
WINDOW_SIZE = 7
WINDOW: collections.deque = collections.deque()
DONE = False

FORCE_ERROR = True


def transmit(gbn_client: socket, param: bytes, address: tuple):
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


def uploading_thread_task(lock):
    global NEXT_SEQ_NO, server_address, WINDOW, BASE, DONE, go_back_n_client
    with lock:
        print("starting uploading thread")
    file_open = open(FILE_NAME, 'rb')
    data = file_open.read(512)

    while not DONE or WINDOW:
        if (NEXT_SEQ_NO < BASE + WINDOW_SIZE) and not DONE:
            # create packet(seq_num,data,checksum)
            send_packet = [NEXT_SEQ_NO, data]

            append_check_sum(send_packet)

            # send packet
            transmit(go_back_n_client, pickle.dumps(send_packet), server_address)
            with lock:
                print("Sent data", NEXT_SEQ_NO)
            # increment variable next_seq_num
            with lock:
                NEXT_SEQ_NO = NEXT_SEQ_NO + 1
            # check if EOF has reached
            if not data:
                with lock:
                    DONE = True
            # append packet to window
            with lock:
                WINDOW.append(send_packet)
            # read more data
            data = file_open.read(500)
    file_open.close()
    with lock:
        print("finishing uploading thread")


def acknowledging_thread_task(lock: threading.Lock):
    global NEXT_SEQ_NO, server_address, WINDOW, BASE, DONE, go_back_n_client, RE_TRANSMISSION_COUNT
    with lock:
        print("starting acknowledging thread")
    last_ack_received = time.time()
    last_re_transmission = time.time()
    while not DONE or WINDOW:
        try:
            packet, server_address = go_back_n_client.recvfrom(4096)
            # data -> [seq_no , check_sum]
            rcv_packet = pickle.loads(packet)
            # check value of checksum received (c) against checksum calculated (h)
            if verify_check_sum(rcv_packet):

                # slide window and reset timer
                if rcv_packet[0] > BASE and WINDOW:
                    with lock:
                        print("Received ack for", rcv_packet[0] - 1)

                    while rcv_packet[0] > BASE and WINDOW:
                        last_ack_received = time.time()
                        with lock:
                            WINDOW.popleft()
                            BASE = BASE + 1
                else:
                    with lock:
                        print("Received out off order ack for", rcv_packet[0] - 1)
                    if time.time() - last_re_transmission > 0.05:
                        with lock:
                            for i in WINDOW:
                                print("Out of order Re-Sent data", i[0])
                                transmit(go_back_n_client, pickle.dumps(i), server_address)
                            RE_TRANSMISSION_COUNT += len(WINDOW)
                            last_re_transmission = time.time()
            else:
                with lock:
                    print("error detected")
            # TIMEOUT
        except:
            if time.time() - last_ack_received > 0.01:
                with lock:
                    for i in WINDOW:
                        print("Re-Sent data", i[0])
                        transmit(go_back_n_client, pickle.dumps(i), server_address)
                    RE_TRANSMISSION_COUNT += len(WINDOW)
    with lock:
        print("finishing acknowledging thread")


def main():
    global NEXT_SEQ_NO, BASE, server_address, go_back_n_client
    go_back_n_client = socket(AF_INET, SOCK_DGRAM)
    go_back_n_client.settimeout(0.001)

    lock = threading.RLock()

    uploading_thread = threading.Thread(target=uploading_thread_task, args=(lock,))
    acknowledging_thread = threading.Thread(target=acknowledging_thread_task, args=(lock,))

    uploading_thread.start()
    acknowledging_thread.start()

    uploading_thread.join()
    acknowledging_thread.join()

    print("connection closed")
    print("re transmission count :", RE_TRANSMISSION_COUNT)
    go_back_n_client.close()


if __name__ == "__main__":
    main()
