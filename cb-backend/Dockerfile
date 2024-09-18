# Base image used to create the java 17 runtime environment for my app
FROM eclipse-temurin:17

# Define an argument for the JAR file location (not used in this snippet)
ARG JAR_FILE=target/*.jar

# Copies JAR file into Docker image -> root directory of the container app.jar
COPY ./cb-backend/target/cb-backend-0.0.1-SNAPSHOT.jar app.jar

# set command to be executed: uses java to run JAR file, -jar tells java to run a jar file. /app.jar is the path to JAR file in container
ENTRYPOINT ["java","-jar","/app.jar"]