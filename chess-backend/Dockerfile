# Utiliser une image officielle OpenJDK 17 avec Maven pour builder
FROM maven:3.9.0-openjdk-17 AS build

WORKDIR /app

# Copier les fichiers pom.xml et source pour profiter du cache docker
COPY pom.xml .
COPY src ./src

# Builder le jar
RUN mvn clean package -DskipTests

# Étape finale : image plus légère avec juste le JRE
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le jar depuis l'image de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port 8080 (par défaut Spring Boot)
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
