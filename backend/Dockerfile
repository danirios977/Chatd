# --- Etapa 1: Construcción (Build) ---
FROM maven:4.1-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiamos solo el pom primero para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecución (Runtime) ---
# Usamos una imagen base mínima (Alpine) para seguridad y tamaño
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Creamos un usuario no-root (buena práctica de seguridad)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiamos el JAR desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# JVM flags recomendados para contenedores (ajuste automático de memoria)
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]