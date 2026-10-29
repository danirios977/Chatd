# 1. Imagen base con Maven y Java para compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos el pom.xml y el código fuente local
COPY pom.xml .
COPY src ./src

# Compilamos el proyecto omitiendo los tests para acelerar el proceso
RUN mvn clean package -DskipTests

# 2. Imagen final liviana para ejecutar el JAR
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]