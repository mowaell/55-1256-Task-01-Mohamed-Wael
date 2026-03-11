FROM eclipse-temurin:25.0.2_10-jdk

WORKDIR /app

COPY target/mohamed_wael-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/users.json /data/users.json
COPY src/main/resources/notes.json /data/notes.json

ENV USER_NAME=Docker_Mohamed_Wael
ENV ID=Docker_55_1256

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "target/app.jar"]
ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "app.jar"]
