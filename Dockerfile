FROM ubuntu:latest
LABEL authors="elhadjimamadousarr"

# Étape 1 : Compilation de l'application avec Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .

# Étape 2 : Exécution du JAR avec OpenJDK
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]