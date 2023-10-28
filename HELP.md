# Used Docker Commands

## 1 : docker aerospike command 1
docker run -ti --name aerospike-asadm --rm aerospike/aerospike-tools asadm --host 172.17.0.3 --no-config-file

## 2 : docker aerospike command 2(main)
docker run -ti --name aerospike-aql --rm aerospike/aerospike-tools aql -h 172.17.0.3 --no-config-file

docker run -ti --name aerospike-aql --rm aerospike/aerospike-tools aql -c "INSERT INTO test.demo (PK, dateTime) VALUES ('key1', 'abc')" -h 172.17.0.3 --no-config-file

## 3 : create image-
docker build . -t docker-demo

## 4 : run app image(docker-demo) as container by linking aerospike container(wonderful_jepsen)-
docker run -p 8083:8083 --name docker-demo --link wonderful_jepsen -d docker-demo

## 5 : curls -

#### POST
curl --location 'localhost:8083/users' \
--header 'Content-Type: application/json' \
--data-raw '{
"id": 2,
"name": "syed ateebul islam",
"email": "syedateebulislam@gmail.com",
"age": 30
}'


#### GET:

curl --location 'http://localhost:8083/users/2'
