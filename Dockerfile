FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app
#ADD ./target/*.jar app.jar
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

 

