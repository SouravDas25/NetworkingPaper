import socket
import random
import datetime

HOST = socket.gethostbyname('localhost')
PORT = 12345


def get_random_word():
    lis = ['Apple', "Ball", "Cat", "Dog"]
    random.shuffle(lis)
    return lis.pop()


def recv_words(connection):
    word = connection.recv(1024)
    word = word.decode()
    words: str = word
    return words


def main():
    localhost_server = socket.socket()

    localhost_server.bind((HOST, PORT))
    print("socket bound to PORT %s" % PORT)

    localhost_server.listen(5)
    print("socket is listening")

    while True:
        connection, addr = localhost_server.accept()
        print('Got connection from', addr)
        start_time = datetime.datetime.now()

        f = open("output.jpg", "wb")

        l = connection.recv(1024)
        print("Started Receiving Data ... ")
        while l:
            f.write(l)
            l = connection.recv(1024)
        f.close()
        print("Done Receiving")

        connection.close()

        end_time = datetime.datetime.now()
        diff = end_time - start_time
        print("TIME TAKEN ", diff.total_seconds(), "s")
        break;


if __name__ == "__main__":
    main()
