🎬 MovieFlix

API RESTful desenvolvida em Java com Spring Boot para controle de catálogo de filmes, incluindo cadastro de usuários, autenticação via JWT, e integração com banco de dados PostgreSQL.

📌 Índice

🚀 Sobre o Projeto

🛠 Tecnologias e Ferramentas

⚙️ Configuração do Projeto

📚 Recursos Implementados

🔐 Autenticação e Segurança

📑 Documentação com Swagger

📂 Diagrama de Classes

📦 Como Executar o Projeto

🚀 Sobre o Projeto

O MovieFlix é uma aplicação backend desenvolvida com Java 17 e Spring Boot 3, que fornece endpoints RESTful para o gerenciamento de um catálogo de filmes. É possível cadastrar filmes, categorias, serviços de streaming, usuários, além de autenticar-se utilizando tokens JWT.

🛠 Tecnologias e Ferramentas

Java 17

Spring Boot 3

Spring Web

Spring Security

JWT 

Spring Data JPA

Bean Validation

PostgreSQL

Flyway

Lombok

Tratamento de exceções

Swagger/OpenAPI 

🔐 Autenticação e Segurança

Implementado com Spring Security e JWT

Filtros personalizados com OncePerRequestFilter

Codificação de senha com BCryptPasswordEncoder

Endpoint de login que retorna o token JWT

Customizações com SecurityFilter, SecurityConfig e TokenService

📑 Documentação com Swagger

Integração com Swagger via springdoc-openapi

Acesse a documentação interativa após rodar o projeto:

http://localhost:8080/swagger-ui.html

📂 Diagrama de Classes

<img width="766" height="348" alt="image" src="https://github.com/user-attachments/assets/ac26ec2e-776e-4ec0-a623-7ad6599f80bc" />

📦 Como Executar o Projeto

Certifique-se de ter o PostgreSQL rodando na porta 5432 com o banco movieflix criado.

Clone este repositório:

git clone https://github.com/cleber-fsilva/movieflix.git


Acesse a pasta do projeto:

cd movieflix


Execute o projeto via sua IDE ou terminal com:

./mvnw spring-boot:run
