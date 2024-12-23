# Use a imagem do Java 17 como base
FROM amazoncorretto:17-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado pelo Spring Boot para o container
COPY build/libs/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
