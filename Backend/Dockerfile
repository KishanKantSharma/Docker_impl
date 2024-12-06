FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/demoapp-0.0.1-SNAPSHOT.jar /app/springproj
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/springproj" ]

