FROM openjdk:17

ENV APP_NAME=webflux
ARG APP_HOME=/opt/app

RUN groupadd app && useradd -d ${APP_HOME} -s /bin/nologin -g app app
WORKDIR ${APP_HOME}
COPY gateway-filter-0.0.1-SNAPSHOT.jar ${APP_NAME}.jar
EXPOSE 8080

USER app
ENTRYPOINT java -XX:MaxRAMPercentage=100 -XX:MinRAMPercentage=100 -XshowSettings:vm -version && java -XX:MaxRAMPercentage=100 -XX:MinRAMPercentage=100 -jar ${APP_NAME}.jar