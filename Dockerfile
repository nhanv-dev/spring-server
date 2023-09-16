#FROM maven:3.8.4-openjdk-17-slim AS build
FROM ubuntu:latest as build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

 

