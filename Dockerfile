FROM openjdk:8

COPY ./build/libs/interview-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar interview-0.0.1-SNAPSHOT.jar
