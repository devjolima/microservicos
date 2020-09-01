FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
COPY e4y.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
