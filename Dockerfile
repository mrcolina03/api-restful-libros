# java 17
FROM eclipse-temurin:17-jdk-alpine

LABEL authors="mrcolina"

WORKDIR /app

#Copiar el jar al contenedor
COPY ./target/test-0.0.1-SNAPSHOT.jar ./test-0.0.1-SNAPSHOT.jar

#Puerto de exposicion
EXPOSE 8082



ENTRYPOINT ["java", "-jar", "test-0.0.1-SNAPSHOT.jar"]