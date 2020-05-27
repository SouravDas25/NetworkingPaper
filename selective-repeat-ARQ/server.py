import hashlib
import pickle
import time
from socket import *
import datetime

HOST = gethostbyname('localhost')
PORT = 12345

SERVER_ADDRESS = (HOST, PORT)

SELECTIVE_REPEAT = socket(AF_INET, SOCK_DGRAM)
SELECTIVE_REPEAT.bind(SERVER_ADDRESS)
SELECTIVE_REPEAT.settimeout(3)
print("Ready to serve")

# initializes packet variables
EXPECTED_SEQ_NO = 1
WINDOW = {}
WINDOW_SIZE = 7

TRANSMISSION_COUNT = 0


def transmit(gbn_client, param: bytes, address: tuple):
    global TRANSMISSION_COUNT
    gbn_client.sendto(param, address)
    TRANSMISSION_COUNT += 1


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


def send_positive_ack(seq_no, client_address):
    send_packet = [1, seq_no]
    append_check_sum(send_packet)

    transmit(SELECTIVE_REPEAT, pickle.dumps(send_packet), client_address)
    print("sending -> positive Ack", seq_no)


def send_neg_ack(seq_no, client_address):
    send_packet = [0, seq_no]
    append_check_sum(send_packet)

    transmit(SELECTIVE_REPEAT, pickle.dumps(send_packet), client_address)
    print("SENDING NEGATIVE ACK -> negative Ack : ", EXPECTED_SEQ_NO)


def main():
    # RECEIVES DATA
    global EXPECTED_SEQ_NO, WINDOW, TRANSMISSION_COUNT
    f = open("output.jpg", "wb")
    end_of_file = False
    # last_packet_written = time.time()
    start_time = datetime.datetime.now()
    # client_address = None

    while True:

        try:
            # Expected data received as [seq_no, data, check_sum]
            packet, client_address = SELECTIVE_REPEAT.recvfrom(4096)
            TRANSMISSION_COUNT += 1
            rcv_packet = pickle.loads(packet)
            # print("recv packet ", rcv_packet[0])
            # check value of checksum received (c) against checksum calculated (h) - NOT CORRUPT
            if verify_check_sum(rcv_packet):
                seq_no = rcv_packet[0]
                data = rcv_packet[1]

                WINDOW[seq_no] = data

                send_positive_ack(seq_no, client_address)

                while EXPECTED_SEQ_NO in WINDOW and not end_of_file:
                    data = WINDOW[EXPECTED_SEQ_NO]
                    if not data:
                        end_of_file = True
                        break
                    f.write(data)
                    print("writing seq", EXPECTED_SEQ_NO)
                    EXPECTED_SEQ_NO += 1
                    # last_packet_written = time.time()
            else:
                send_neg_ack(EXPECTED_SEQ_NO, client_address)

            if end_of_file:
                break
            # if time.time() - last_packet_written > 0.01:
            #     send_neg_ack(EXPECTED_SEQ_NO, client_address)
            #     last_packet_written = time.time()
        except:
            print("Timeout Exception Occurred, no data received.")

    end_time = datetime.datetime.now()

    f.close()
    print('FILE TRANSFER SUCCESSFUL')
    diff = end_time - start_time
    print("TIME TAKEN ", diff.total_seconds(), "s")
    print("No Of Transmission Required : ", TRANSMISSION_COUNT)


if __name__ == "__main__":
    main()
