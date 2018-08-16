FROM openjdk:8-jre-alpine
COPY simple-web-app-service/target/libs /opt/simple-web-app/libs
COPY simple-web-app-service/target/simple-web-app-service-1.0.0-SNAPSHOT.jar /opt/simple-web-app
WORKDIR /opt/simple-web-app
CMD ["java", "-cp", "'libs/*'", "-jar", "simple-web-app-service-1.0.0-SNAPSHOT.jar"]