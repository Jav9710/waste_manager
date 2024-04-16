FROM openjdk:17-slim-buster

LABEL author="Javier Merinno jamv971003@gmail.com"
ARG artifactname

VOLUME /tmp
ADD ${artifactname}.jar app.jar

ADD wait-for-it.sh wait-for-it.sh
RUN apk add --no-cache tzdata
RUN sh -c 'touch /app.jar'
RUN sh -c 'touch /wait-for-it.sh'
RUN sh -c 'chmod +x /wait-for-it.sh'
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]