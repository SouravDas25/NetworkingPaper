import socket

HOST = socket.gethostbyname('localhost')
PORT = 12345


def main():
    server_address = (HOST, PORT)
    udp_server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp_server.bind(server_address)
    while True:
        print('\nwaiting to receive message')
        data, address = udp_server.recvfrom(4096)

        print('received %s bytes from %s' % (len(data), address))
        print(data)

        if data:
            sent = udp_server.sendto(data, address)
            print('sent %s bytes back to %s' % (sent, address))


if __name__ == "__main__":
    main()
