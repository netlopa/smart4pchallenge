
# Smart4P Challenge

## Problem

Create a webapp to find an ATM giving a search text

### URL

Here there is a cURL call to the implemented webservice

```
curl --location --request GET 'http://localhost:8080/api/atm?search=Haarlem'
```

## Technology

This project was made with Java 8 with the Spring Boot framework and Maven for the Backend part.

The frontend part was done with Angular 8 (you can find the source code in ./src/main/resources/frontend )

## How to run the application (standalone)

1. Make sure you have Java 8 installed and properly configured
2. Run the following command
```
git clone https://github.com/netlopa/smart4pchallenge.git
```
3. Inside the created folder you need to run 
```
mvn spring-boot:run
```
4. Open your browser and type: http://localhost:8080/

*NOTE:* For your convenience it's not necessary to compile the frontend, it's bundled as static resources in the Spring Boot project.

## How to run the application with Docker

1. Make sure you have Java 8 installed and properly configured and clone the project
2. First of all you need to create the JAR package of the application: you need to go in the main folder of the project that you cloned and then execute this command
```
./mvnw package
```
3. Now, you need to create the Docker image, using this command
```
docker build -t netlopa/smart4pchallenge .
```
4. If you want to run the Docker image, run this command
```
docker run -p 8080:8080 -t netlopa/smart4pchallenge
```



