# code-with-quarkus

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
sudo docker run -ti --rm -p 27017:27017 mongo:4.4
```

##



### For running MongoDB database 
```shell script
mongosh "mongodb+srv://cluster0.mwypxof.mongodb.net" --apiVersion 1 --username jakobniinja
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.# quarkus-friutmix


### To start Docker

```shell script
sudo docker build -f src/main/docker/Dockerfile.jvm -t quarkus/code-with-quarkus-jvm .
sudo docker run -i --rm -p 8081:8081 quarkus/code-with-quarkus-jvm
```

### Daily log
``` 
15/7 - installed mongodb on aws ec2 instance and accepted all inbound ip-addresses in mongodb atlas
```
