import hashlib
import pickle
import time
from socket import *
import datetime

HOST = gethostbyname('localhost')
PORT = 12345

server_address = (HOST, PORT)

go_back_n_server = socket(AF_INET, SOCK_DGRAM)
go_back_n_server.bind(server_address)
go_back_n_server.settimeout(1)
print("Ready to serve")

# initializes packet variables
expected_seq_num = 1
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


def main():
    # RECEIVES DATA
    global expected_seq_num, TRANSMISSION_COUNT
    f = open("output.jpg", "wb")
    end_of_file = False
    last_packet_received = time.time()
    start_time = datetime.datetime.now()

    while True:

        try:
            # Expected data received as [seq_no, data, check_sum]
            packet, client_address = go_back_n_server.recvfrom(4096)
            TRANSMISSION_COUNT += 1
            rcv_packet = pickle.loads(packet)
            # check value of checksum received (c) against checksum calculated (h) - NOT CORRUPT
            if verify_check_sum(rcv_packet):
                # check value of expected seq number against seq number received - IN ORDER
                if rcv_packet[0] == expected_seq_num:
                    print("Received in-order", expected_seq_num)
                    if rcv_packet[1]:
                        f.write(rcv_packet[1])
                    else:
                        end_of_file = True
                    expected_seq_num = expected_seq_num + 1
                    # create ACK (seq_num,checksum)
                    send_packet = [expected_seq_num]
                    append_check_sum(send_packet)

                    transmit(go_back_n_server, pickle.dumps(send_packet), client_address)
                    print("Ack", expected_seq_num - 1)

                else:
                    # default? discard packet and resend ACK for most recently received in-order pkt
                    print("Received out of order", rcv_packet[0])
                    send_packet = [expected_seq_num]
                    append_check_sum(send_packet)
                    transmit(go_back_n_server, pickle.dumps(send_packet), client_address)
                    print("Ack", expected_seq_num - 1)
            else:
                print("error detected")
        except:
            if end_of_file:
                if time.time() - last_packet_received > 3:
                    break

    end_time = datetime.datetime.now()

    f.close()
    print('FILE TRANSFER SUCCESSFUL')
    diff = end_time - start_time
    print("TIME TAKEN ", diff.total_seconds() - 1, "s")
    print("No Of Transmission Required : ", TRANSMISSION_COUNT)


if __name__ == "__main__":
    main()
