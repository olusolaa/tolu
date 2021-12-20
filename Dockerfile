FROM openjdk:11-jdk-slim

WORKDIR /app

COPY src/main/java/com/ems/employeemanagementsystem /app

ENTRYPOINT [ "./mvnw", "spring-boot:run" ]