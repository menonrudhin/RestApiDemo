FROM eclipse-temurin:20-jre
WORKDIR /usr/app
COPY ./target/RestApiDemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","app.jar"]
