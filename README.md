# Runar-java-backend

## Prerequisites

- install [JDK19](https://jdk.java.net/19/)
- NO local database needed
- NO other programs needed

## Setup

1. Clone project
2. Change directory to root project directory
3. Type `./mvnw package`
4. After BUILD SUCCESS change directory to target with `cd target`
5. Run project with `java -jar runar-java-backend-0.0.1.jar`

## How to use

`http://localhost:8080/api/v2/` - to get root menu

`http://localhost:8080/api/v2/id` - to get submenus of document where id is identity of document in DB 