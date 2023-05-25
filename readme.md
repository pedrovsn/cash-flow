# Cash Flow API

## Pré-requisitos

Antes de executar a aplicação, certifique-se de ter os seguintes itens instalados:

- Java Development Kit (JDK) 17 ou superior
- Apache Maven
- Docker (opcional, para executar a aplicação usando Docker)

## Iniciando

Para executar a aplicação, siga as etapas abaixo:

1. Clone o repositório para o seu ambiente local:

   ```
   git clone https://github.com/pedrovsn/cash-flow-api.git
   ```

2. Navegue até o diretório do projeto:

   ```
   cd cash-flow-api
   ```

3. Compile o projeto usando o Maven:

   ```
   mvn clean install
   ```

4. Execute o aplicativo:

   ```
   mvn spring-boot:run
   ```

Após a execução bem-sucedida, a API Cash Flow estará disponível em [http://localhost:8080](http://localhost:8080).

## Documentação da API

A documentação da API está disponível através do Swagger. Para acessar a documentação, abra o seguinte URL em seu navegador:

```
http://localhost:8080/swagger-ui.html
```

## Executando com Docker

Se preferir executar a aplicação usando Docker, siga as etapas abaixo:

1. Certifique-se de ter o Docker instalado em sua máquina.

2. Navegue até o diretório raiz do projeto.

3. Construa a imagem Docker:

   ```
   docker build -t cash-flow-api .
   ```

4. Execute o contêiner Docker:

   ```
   docker run -p 8080:8080 cash-flow-api
   ```

Após a execução bem-sucedida, a API Cash Flow estará disponível em [http://localhost:8080](http://localhost:8080).