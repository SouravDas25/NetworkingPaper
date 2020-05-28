import socket

HOST = socket.gethostbyname('localhost')
PORT = 12345


def main():
    upd_client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_address = (HOST, PORT)
    f = open('client-img.jpg', 'rb')
    data = f.read(4096)
    packetNumber = 0
    print("client started , started sending file")
    try:
        while data:
            if upd_client.sendto(data, server_address):
                packetNumber = packetNumber + 1
                data = f.read(4096)
        upd_client.close()
        f.close()

    finally:
        print(f'File sending finished,closing udp server , {packetNumber} packet sent')
        upd_client.close()


if __name__ == "__main__":
    main()
