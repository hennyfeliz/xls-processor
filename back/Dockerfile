FROM openjdk:20-jdk

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado por tu proyecto de Spring Boot al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 para acceder a la aplicación
EXPOSE 8080

# Comando para iniciar la aplicación de Spring Boot
CMD [ "java", "-jar", "app.jar" ]