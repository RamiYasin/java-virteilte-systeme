##
## Build stage
##
FROM maven:3.8.1-openjdk-11-slim AS build
LABEL maintainer = Boulmani
LABEL stage = build

RUN mkdir -p /app
COPY ./ /app/
WORKDIR /app
RUN mvn package

##
## Run stage
##
FROM openjdk:11.0-jre-slim
LABEL maintainer = Boulmani
EXPOSE 1883/tcp
RUN mkdir -p /app
COPY --from=build /app/target/MqttClientPublisher-1.0-SNAPSHOT.jar $STAGE_DIR/mqttclientpublisher.jar
CMD ["java", "-jar", "mqttclientpublisher.jar"]
