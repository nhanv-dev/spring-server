FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
ADD ./target/spring-server-0.0.1-SNAPSHOT.jar app.jar
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /target/spring-server-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

 

