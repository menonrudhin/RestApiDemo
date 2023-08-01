FROM eclipse-temurin:17-jre
WORKDIR /usr/app
COPY ./target/RestApiDemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]