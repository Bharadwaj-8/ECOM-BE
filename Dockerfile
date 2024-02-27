# Use a lightweight Java base image
FROM openjdk:11-jre-slim

# Create a working directory within the image
WORKDIR /app

# Copy the Maven JAR file to the working directory
COPY target/backend-ecom-0.0.1-SNAPSHOT.jar /app/backend-ecom-0.0.1-SNAPSHOT.jar

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "/app/backend-ecom-0.0.1-SNAPSHOT.jar"]
