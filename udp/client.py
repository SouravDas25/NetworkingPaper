import socket

HOST = socket.gethostbyname('localhost')
PORT = 12345


def main():
    upd_client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_address = (HOST, PORT)
    message = 'This is the message.  It will be repeated.'

    try:

        # Send data
        print('sending "%s"' % message)
        sent = upd_client.sendto(message.encode(), server_address)

        # Receive response
        print('waiting to receive')
        data, server = upd_client.recvfrom(4096)
        print('received "%s"' % data)

    finally:
        print('closing udp server')
        upd_client.close()


if __name__ == "__main__":
    main()
