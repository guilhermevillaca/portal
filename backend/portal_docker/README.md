# portal_docker
Projeto Portal com Docker

# Portal DTO - Spring Boot + PostgreSQL com Docker

Este projeto é uma aplicação Java com Spring Boot, conectada a um banco de dados PostgreSQL, totalmente configurada para rodar em containers Docker. Inclui suporte para Java 21.

---

## 🚀 Tecnologias utilizadas

- Java 21 (Temurin)
- Spring Boot
- Maven
- PostgreSQL
- Docker + Docker Compose

---

## 📦 Estrutura do Projeto

```

portal/
├── src/
│   └── main/
│       └── java/
│           └── br/com/villaca/portal/
│               ├── controller/
│               │   └── OlaController.java
│               └── PortalApplication.java
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── README.md

````

---

## 🐳 Pré-requisitos

- [Docker](https://www.docker.com/products/docker-desktop)
- Git (opcional)
- Maven e JDK 21 (caso deseje rodar localmente sem Docker)

---

## 🧱 Instalação do Docker

### 🪟 Windows

1. Baixe o [Docker Desktop](https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe).
2. Instale normalmente e reinicie o computador.
3. Abra o **Docker Desktop** e verifique se está rodando.

### 🐧 Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install -y docker.io docker-compose
sudo systemctl enable docker
sudo systemctl start docker
sudo usermod -aG docker $USER
````

⚠️ Faça **logout e login novamente** após o último comando para ativar o grupo `docker`.

---

## 📄 Dockerfile

```dockerfile
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 📄 docker-compose.yaml

```yaml
services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/portal
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
    networks:
      - portal-network

  db:
    image: postgres:15
    environment:
      POSTGRES_DB: portal
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    volumes:
      - pgdata:/var/lib/postgresql/data
    networks:
      - portal-network

volumes:
  pgdata:

networks:
  portal-network:
```

---

## ✅ Como subir o projeto

1. Clone ou entre na pasta do projeto
2. Execute o comando abaixo:

```bash
docker-compose up --build
```

3. Acesse a aplicação:

```
http://localhost:8080/ola/mundo
```

Resposta esperada:

```
Olá Mundo
```

---

## ❌ Possíveis erros e como resolver

### ❓ 404 - Whitelabel Error Page

Se você acessar `http://localhost:8080/ola/mundo` e receber um erro 404, verifique:

### ✅ Exemplo de Controller funcional:

```java
package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
public class OlaController {

    @RequestMapping(value = "/mundo", method = RequestMethod.GET)
    public String mundo() {
        return "Olá Mundo";
    }
}
```

### ✅ Classe principal no pacote pai:

```java
package br.com.villaca.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

}
```

### ✅ Verifique o build

Certifique-se de que o controller está dentro do `.jar`:

```bash
jar tf target/*.jar | grep OlaController
```

### ✅ Verifique o log de endpoints

Adicione ao `application.properties`:

```properties
logging.level.org.springframework.web=DEBUG
```

---

## 🔄 Parar os containers

```bash
docker-compose down
```

---

## 🧪 Testar com curl

```bash
curl http://localhost:8080/ola/mundo
```

---

## 💡 Dicas

* Se estiver usando Windows com WSL2, certifique-se de que o Docker está ativo no WSL também.
* O volume `pgdata` garante persistência do banco de dados entre execuções.

---

Adaptado para ambientes modernos com Java 21, Spring Boot e Docker.



