# Use a base image with Java pre-installed
#FROM java:openjdk-8u111-alpine

# Set the working directory in the container
#WORKDIR /app

# Copy the Spring Boot application JAR file into the container
#COPY target/your-application.jar app.jar

# Expose the port that the Spring Boot application listens on
#EXPOSE 8080

# Define the command to run the Spring Boot application when the container starts
#CMD ["java", "-jar", "app.jar"]




FROM java:openjdk-8u111-alpine

VOLUME /tmp
EXPOSE 8090

COPY ./target/logistic-1.0.0.jar /logistic.jar

ENTRYPOINT ["java", "-jar", "/logistic.jar"]
