# Savvy Wallet API

Este é o backend da API do Savvy Wallet, desenvolvido em **Java** usando **Spring Boot**. Provê endpoints para funcionalidades de carteira digital, relatórios, entre outros.

##  Estrutura do projeto

- `src/main/` – código-fonte Java.
- `docs/relatorios/` – relatórios gerados/documentação interna.
- `pom.xml` – configuração do Maven e dependências.
- `mvnw`, `mvnw.cmd`, `.mvn/wrapper/` – wrapper do Maven para facilitação do build.
- `Dockerfile` – configuração para containerização.
- `Procfile` – configuração de deploy (ex: Heroku).
- `system.properties` – configurações específicas da JVM ou runtime.
- `.gitignore` – arquivos ignorados pelo controle de versão.

##  Pré-requisitos

- Java 11+ (ou versão compatível definida no projeto)
- Maven (usa-se o Maven wrapper para evitar necessidade de instalação local)
- Docker (para containerização)
