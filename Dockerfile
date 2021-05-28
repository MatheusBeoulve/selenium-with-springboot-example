FROM maven:3-openjdk-11-slim

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn install -DskipTests

RUN mvn clean

ENTRYPOINT mvn test
