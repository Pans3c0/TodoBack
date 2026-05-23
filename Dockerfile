# ETAPA 1: Construcción
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
# Compilamos el proyecto creando el .jar
RUN ./mvnw clean package -DskipTests

# ETAPA 2: Ejecución (Imagen final súper ligera)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copiamos solo el .jar de la etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]