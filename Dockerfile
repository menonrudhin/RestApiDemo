FROM 324093103365.dkr.ecr.ca-central-1.amazonaws.com/rest-api-demo:latest
WORKDIR /usr/app
COPY ./target/RestApiDemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
