FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#### BUILD image
#FROM maven:3.8.4-openjdk-17 as builder
## create app folder for sources
#RUN mkdir -p /build
#WORKDIR /build
#COPY pom.xml /build
##Download all required dependencies into one layer
#RUN mvn -B dependency:resolve dependency:resolve-plugins
##Copy source code
#COPY src /build/src
## Build application
#RUN mvn package
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
