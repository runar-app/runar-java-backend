# Runar-java-backend

## Prerequisites

- Install Java v.19 [JDK19](https://jdk.java.net/19/)
- Docker (to run mongodb)

## Code Checkout

```
git clone git@github.com:runar-app/runar-java-backend.git
```

### Run the project locally

1. Start mongo DB in a docker container using the following command:

```
docker run -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -p 27017:27017 --name runar-mongo -v ${HOME}/workspace/runar/mongo-db-data:/data/db -d mongo
```

2. Build and run server (cmd from root folder)

`./dev`

## Test endpoints

#### Get root menu

[http://localhost:8080/api/v2/](http://localhost:8080/api/v2/)

#### Get submenus of document where id is identity of document in DB

[http://localhost:8080/api/v2/id](http://localhost:8080/api/v2/id)
