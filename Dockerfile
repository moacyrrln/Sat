# Usar a imagem base do Maven com JDK 17
FROM maven:3.8.4-openjdk-17

# Copiar os arquivos do projeto para o diretório /app
COPY . /app

# Definir o diretório de trabalho
WORKDIR /app

# Compilar o projeto
RUN mvn clean install

# Executar a aplicação
CMD ["java", "-jar", "target/app.jar"]
