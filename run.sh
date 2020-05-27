
folder=$1

cd $folder

python3  "server.py" > server.log &

python3  "client.py" > client.log


#killAll Python