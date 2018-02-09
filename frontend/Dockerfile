FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/frontend.jar app.jar
ENV JAVA_OPTS="-Xms64m -Xmx128m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]