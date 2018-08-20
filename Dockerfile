FROM openjdk:8-jre-alpine
COPY simple-web-app-service/target/ /opt/simple-web-app/
WORKDIR /opt/simple-web-app
CMD ["java", "-cp", "'libs/*'", "-jar", "simple-web-app-service-1.0.0-SNAPSHOT.jar"]