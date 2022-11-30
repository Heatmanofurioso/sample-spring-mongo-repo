FROM openjdk:17.0.2-jdk-slim

# Get the artifact from build
COPY /target/sample-spring-project-1.0.0-SNAPSHOT.jar /opt/sentinel/sample-spring-project.jar

# Start the application
CMD ["/usr/local/openjdk-17/bin/java", \
  "-jar", "sample-spring-project.jar"]

# Expose standard tomcat port
EXPOSE 443
EXPOSE 8080
EXPOSE 4002
