import socket
import time

HOST = socket.gethostbyname('localhost')
PORT = 12345


def main():
    print("Started server")
    server_address = (HOST, PORT)
    udp_server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_server.bind(server_address)
    f = open("output.jpg", "wb")
    data, address = udp_server.recvfrom(4096)
    ack_received = time.time()
    packet = 0
    try:
        while data:
            f.write(data)
            packet = packet + 1
            udp_server.settimeout(2)
            data,addr = udp_server.recvfrom(4096)
    except socket.timeout:
        f.close()
        udp_server.close()
        print (f"File Downloaded Total Packet Received :  {packet}")
        last_ack_received = time.time()-ack_received-2;
        print(f"Total time taken : {last_ack_received} Seconds")


if __name__ == "__main__":
    main()
