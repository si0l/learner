FROM openjdk:17-oracle
VOLUME /usr/src/app
COPY run.sh .
COPY target/*.jar app.jar
ENTRYPOINT ["./run.sh"]