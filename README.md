# Runar-java-backend
## Prerequisites
- install [JDK19](https://jdk.java.net/19/)
- NO local database needed
- NO other programs needed
- prepare your credentials for database access

## Setup
1. Clone project
2. Enter your credentials for database by adding DB_USERNAME and DB_PASSWORD environment variables in terminal:
```
~$: export DB_USERNAME=yourValue
~$: export DB_PASSWORD=yourValue
```
**Note:** Your variables will only be valid in the current terminal session

3. Change directory to root project directory
4. Type `./mvnw package`
5. After BUILD SUCCESS change directory to target with `cd target`
6. Run project with `java -jar runar-java-backend-0.0.1.jar`

## How to use
`http://localhost:8080/menu` - to get root menu

`http://localhost:8080/menu/id` - to get submenus of the document where `id` is document's identity in the database