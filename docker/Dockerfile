#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE
#ADD ${JAR_FILE} esthesia-service.jar
#EXPOSE 8087
#ENTRYPOINT ["java","-jar","/esthesia-service.jar"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]