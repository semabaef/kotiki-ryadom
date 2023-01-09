FROM bellsoft/liberica-openjdk-alpine:17
ARG JAR_FILE=target/KotikiRyadom-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
