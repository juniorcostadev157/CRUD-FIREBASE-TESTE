FROM amazoncorretto:17-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para o container
COPY build/libs/CrudFirebaseEstudo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
