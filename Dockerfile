# Etapa de construcción (build stage)
FROM maven:3.8.6-openjdk-17-slim as build

# Establecer el directorio de trabajo en la imagen
WORKDIR /app

# Copiar el pom.xml y el código fuente a la imagen
COPY pom.xml .
COPY src ./src

# Ejecutar Maven para construir el archivo JAR
RUN mvn clean package -DskipTests

# Etapa de ejecución (runtime stage)
FROM openjdk:17-alpine

# Exponer el puerto donde se ejecutará la aplicación
EXPOSE 9000

# Copiar el JAR construido desde la etapa de construcción
COPY --from=build /app/target/*.jar /app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
