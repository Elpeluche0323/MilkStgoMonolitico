FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Desarrollador-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/Desarrollador-0.0.1-SNAPSHOT.jar"]