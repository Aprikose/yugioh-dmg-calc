#FROM eclipse-temurin:17-jdk-jammy

#WORKDIR /app
#COPY .mvn/ .mvn/
#COPY mvnw pom.xml ./

#RUN chmod +x ./mvnw

#RUN apt-get update && apt-get install -y dos2unix
#RUN dos2unix ./mvnw

#RUN ./mvnw dependency:resolve

#COPY src ./scr

#CMD [".mvnw", "spring-boot:run"]


# base image / vorlage angeben -> FROM SCRATCH = leers image
FROM openjdk:8-jdk-alpine

# optional Importing Parameter / variable welche beim build übergeben werde kann
ARG JAR_FILE=target/*.jar

# optional - Autor
# MAINTAINER name

# Befehl / Command ausführen
# RUN wird beim Build des Images ausgeführt
# CMD wird beim erstellen des Containers aus dem Image heraus ausgeführt

# kopiert files und verzeichnise / ordner
# hier wird die Variable verwendet
#COPY ${JAR_FILE} app.jar

COPY . .

RUN ./mvnw spring-boot:run

# 
# ENTRYPOINT ["executable", "param1", "param2"]
ENTRYPOINT ["java","-jar","/app.jar"]