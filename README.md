**SmartParker API**

## Descrição do Projeto:

A **SmartParker API** é uma aplicação desenvolvida em Java com Spring Boot, para gerenciar um sistema de patio de motos. A API permite o controle completo de usuários, motos, pátios, setores e localizações, possuindo todas funcionalidades de um CRUD, além de buscas por parâmetros, paginação, ordenação e cache para otimização de requisições.

## Alunos

2tdspx:
- Caio Cesar – rm556331
- Guilherme Grizão – rm557958

2tdspy:
- Pietro – rm555839


## Instruções para Executar o Projeto:

# Requisitos

- Java 17 ou superior;
- Maven 3.6+;

## Passos para rodar localmente:

1. Clone o repositório:
------------------------------
    git clone https://github.com/CaiocrNyimi/challenge.git
    cd challenge-main
------------------------------

2. Execute a aplicação com Maven:
------------------------
    mvnw.cmd spring-boot:run
------------------------

3. Acesse a API em:

http://localhost:8080


# Tecnologias e Recursos Utilizados:

- Java 17;
- Spring Boot;
- H2 Database;
- Maven;
- Spring Cache;
- Bean Validation;
- JPA Specifications;
- Pageable e ordenação de endpoints;
- Manipulação de erros com @ControllerAdvice;
- DTOs para transporte de dados entre camadas;
