# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:11-jre

# Set the working directory inside the container
WORKDIR /app

# Copy all files from your current folder (CitizenF) into the container
COPY . /app

# Expose port 8080 so Cloud Run can access your app
EXPOSE 8002

# Run your Spring Boot or Java application (replace 'your-app.jar' with your actual JAR file name)
CMD ["java", "-jar", "VACCINATION-CENTER-SERVICE.jar"]
