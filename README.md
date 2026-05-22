# 💸 Customer Loans API | API de Empréstimos

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

API desenvolvida em **Java 21 + Spring Boot** para análise de elegibilidade de clientes em diferentes modalidades de empréstimos.

API built with **Java 21 + Spring Boot** to evaluate customers' eligibility for different loan types.

🔗 [Desafio Backend - Loans](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)

---

## 📌 Índice | Table of Contents
- [Tecnologias](#-tecnologias--technologies)
- [Descrição](#-descrição--description)
- [Modalidades e Regras](#-modalidades--loan-types)
- [Regras de negócio](#-regras-de-negócio--business-rules)
- [Validações e Exceções](#-validações-e-tratamento-de-exceções--validations--exception-handling)
- [Endpoints](#-endpoints)
- [Como Executar](#-como-executar--how-to-run)
- [Estrutura do Projeto](#-estrutura--project-structure)

---

## 🚀 Tecnologias | Technologies

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring_boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Swagger/SpringDoc](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Bean Validation](https://img.shields.io/badge/Bean_Validation-8A2BE2?style=for-the-badge&logo=eclipse&logoColor=white)

---

## 📜 Descrição | Description

O objetivo é criar uma API que determina quais modalidades de empréstimos um cliente tem acesso, baseado em:

The goal is to create an API that determines which loan types a customer is eligible for, based on:

- ✅ **Idade | Age**
- ✅ **Salário | Income**
- ✅ **Localização | Location**

---

## 🔥 Modalidades | Loan Types

| Tipo | Type           | Taxa de Juros | Interest Rate (%) |
|------|----------------|----------------|-------------------|
| PESSOAL | PERSONAL      | 4              | 4                 |
| GARANTIDO | GUARANTEED | 3              | 3                 |
| CONSIGNADO | CONSIGNMENT | 2            | 2                 |

---

## 📊 Regras de negócio | Business Rules

### 🇧🇷 Regras (Português)

- **Empréstimo Pessoal (PERSONAL)** ➡️ Salário ≤ R$ 3000  
  ➡️ Ou salário entre R$ 3000 e R$ 5000, se tiver **menos de 30 anos e residir em SP**

- **Empréstimo Consignado (CONSIGNMENT)** ➡️ Salário ≥ R$ 5000

- **Empréstimo com Garantia (GUARANTEED)** ➡️ Salário ≤ R$ 3000  
  ➡️ Ou salário entre R$ 3000 e R$ 5000, se tiver **menos de 30 anos e residir em SP**

---

### 🇺🇸 Rules (English)

- **Personal Loan (`PERSONAL`)** ➡️ Income ≤ R$ 3000  
  ➡️ Or income between R$ 3000 and R$ 5000 **if under 30 years old and living in SP**

- **Consignment Loan (`CONSIGNMENT`)** ➡️ Income ≥ R$ 5000

- **Guaranteed Loan (`GUARANTEED`)** ➡️ Income ≤ R$ 3000  
  ➡️ Or income between R$ 3000 and R$ 5000 **if under 30 years old and living in SP**

---

## 🛡️ Validações e Tratamento de Exceções | Validations & Exception Handling

A API conta com validação estruturada dos dados de entrada, garantindo a integridade da requisição. Caso ocorram erros, um `GlobalExceptionHandler` intercepta e retorna respostas claras.

### Regras de Validação | Validation Rules
- **Nome (`name`)**: Obrigatório e tamanho entre 2 e 100 caracteres.
- **Idade (`age`)**: Obrigatória e deve estar entre 18 e 100 anos.
- **CPF (`cpf`)**: Obrigatório e deve possuir formato válido (com ou sem pontuação).
- **Renda (`income`)**: Obrigatória e deve ser um valor positivo.
- **Localização (`location`)**: Obrigatória e deve ter exatamente 2 caracteres (Ex: `SP`).

### Exemplo de Erro | Error Response Example (400 Bad Request)

```json
{
  "status": 400,
  "timestamp": "2026-05-19T12:00:00.000",
  "mensagem": "Erro de validacao em campos",
  "Erros": [
    {
      "campo": "age",
      "mensagem": "Age should not be less than 18"
    }
  ]
}
```

---

## 📑 Endpoints

### 🔸 [POST] `/customer-loans`

#### Request Body

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
```

Response Body
``` json
{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```

## ✅ Como executar | How to run

### 🔧 Pré-requisitos | Prerequisites
- Java 21
- Maven

### 🚀 Executar localmente | Run locally

```bash
# Clone o repositório | Clone the repository
git clone https://github.com/Francisco-Montalvao/loans.git

# Acesse o diretório | Go to project folder
cd loans

# Execute o projeto | Run the project
./mvnw spring-boot:run
```

### 🐳 Executar via Docker | Run via Docker
Se não tiver o Java instalado, você pode rodar o projeto utilizando o Docker (If you don't have Java installed, you can use Docker):
```bash
# Faça o build da imagem | Build the image
docker build -t customer-loans-api .

# Rode o container | Run the container
docker run -p 8080:8080 customer-loans-api
```

### 🛑 Parar o Docker | Stop Docker
Para parar a aplicação (To stop the application):
- Se estiver vendo os logs no terminal, aperte `Ctrl + C` (If viewing logs, press `Ctrl + C`).
- Ou, em outro terminal, encontre o ID e pare (Or, in another terminal, find the ID and stop it):
```bash
# Listar os containers rodando | List running containers
docker ps

# Parar o container | Stop the container
docker stop <CONTAINER_ID>
```

➡️ **API disponível em | API available at:**  
`http://localhost:8080/customer-loans`


## 📂 Estrutura | Project Structure

```text
src
└── main
    ├── java
    │   └── com
    │       └── loans
dit     │           ├── apidoc
    │           │   └── LoansControllerApiDoc.java
    │           ├── controller
    │           │   └── CustomerController.java
    │           ├── dto
    │           │   ├── request
    │           │   │   └── RequestCustomerDTO.java
    │           │   └── response
    │           │       └── ResponseCustomerDTO.java
    │           ├── enums
    │           │   └── TypeLoan.java
    │           ├── exception
    │           │   └── GlobalExceptionHandler.java
    │           ├── model
    │           │   └── Loan.java
    │           ├── service
    │           │   └── LoanService.java
    │           └── LoansApplication.java
    └── resources
        └── application.properties
```

## 🧑‍💻 Autor | Author
Desenvolvido por | Developed by **Francisco Montalvao** 🚀

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Francisco-Montalvao)
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.  
This project is under the MIT license. See the LICENSE file for more details.
