##
## Build stage
##
FROM maven:3.8.1-openjdk-11-slim AS build
LABEL maintainer = Boulmani
LABEL stage = build

RUN mkdir -p 9090 /app
COPY ./ /app/
WORKDIR /app
RUN mvn package

##
## Run stage
##
FROM openjdk:11.0-jre-slim
LABEL maintainer = Boulmani

RUN mkdir -p 9090 /app
COPY --from=build /app/target/Database-1.0-SNAPSHOT.jar $STAGE_DIR/database.jar
CMD [ "java", "-jar", "database.jar"]
