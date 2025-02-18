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
COPY .target/YuGiOhTournament-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]