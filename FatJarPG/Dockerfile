FROM openjdk:8-jre-alpine
ARG JAVA_ARGS
COPY entrypoint.sh /entrypoint.sh
COPY target/FatJar-Example.jar /app.jar
ENTRYPOINT ["sh","/entrypoint.sh"]