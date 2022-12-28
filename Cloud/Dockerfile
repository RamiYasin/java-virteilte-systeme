##
## Build stage
##
FROM maven:3.8.1-openjdk-11-slim AS build
LABEL maintainer = Boulmani
LABEL stage = build

RUN mkdir -p 8080 /app
COPY ./ /app/
WORKDIR /app
RUN mvn package

##
## Run stage
##
FROM openjdk:11.0-jre-slim
LABEL maintainer = Boulmani
EXPOSE 8080/tcp

RUN mkdir -p 8080 /app
COPY --from=build /app/target/Cloud-1.0-SNAPSHOT.jar $STAGE_DIR/cloud.jar
CMD [ "java", "-jar", "cloud.jar"]
