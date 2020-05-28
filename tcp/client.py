import socket
import sys
import random

try:
    HOST = socket.gethostbyname('localhost')
except socket.gaierror:

    print("there was an error resolving the host")
    sys.exit()

PORT = 12345


def main():
    try:
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

        client.connect((HOST, PORT))
        print("the socket has successfully connected to server on port == %s" % HOST)

        f = open('client-img.jpg', 'rb')
        data = f.read(1024)
        i = 0
        while data:
            i = i + 1
            print("Sending Data Packet " , i)
            client.send(data)
            data = f.read(1024)
        f.close()

        client.close()
        print (f"Data sending successful , totally sent  {i} packets")
    except socket.error as err:
        print("socket creation failed with error %s" % err)


if __name__ == "__main__":
    main()
