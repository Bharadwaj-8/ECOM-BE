# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your host to the container
COPY /var/lib/jenkins/workspace/Ecom/ECOM-BE/target/ /app/

# Expose the port that your application will listen on
EXPOSE 8081

# Define the command to run your Java application
CMD ["java", "-jar", "ecom.jar"]
