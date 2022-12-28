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
EXPOSE 3030/udp

RUN mkdir -p /app
COPY --from=build /app/target/Client-1.0-SNAPSHOT.jar $STAGE_DIR/client.jar
CMD [ "java", "-jar", "client.jar"]
