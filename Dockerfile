# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your host to the container
COPY ecom.jar /app/ecom.jar

# Expose the port that your application will listen on
EXPOSE 8081

# Define the command to run your Java application
CMD ["java", "-jar", "ecom.jar"]
