FROM java:8-jdk-alpine

COPY ./target/achat-1.0.jar.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","achat-1.0.jar.jar"]

