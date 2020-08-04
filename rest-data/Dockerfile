FROM openjdk:8-jre-alpine
ARG JAVA_ARGS
COPY entrypoint.sh /entrypoint.sh
COPY target/rest-data-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["sh","/entrypoint.sh"]