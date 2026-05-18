Markdown
# 💸 Customer Loans API | API de Empréstimos

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

API desenvolvida em **Java 21 + Spring Boot** para análise de elegibilidade de clientes em diferentes modalidades de empréstimos.

API built with **Java 21 + Spring Boot** to evaluate customers' eligibility for different loan types.

🔗 [Desafio Backend - Loans](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)

---

## 📌 Índice | Table of Contents
- [Tecnologias](#-tecnologias--technologies)
- [Descrição](#-descrição--description)
- [Modalidades e Regras](#-modalidades--loan-types)
- [Endpoints](#-endpoints)
- [Como Executar](#-como-executar--how-to-run)
- [Estrutura do Projeto](#-estrutura--project-structure)

---

## 🚀 Tecnologias | Technologies

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring_boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

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

➡️ **API disponível em | API available at:**  
`http://localhost:8080/customer-loans`

📖 **Documentação Interativa (Swagger) | Interactive Documentation:**  
Seu projeto possui a dependência do Springdoc, então você pode testar ao vivo acessando:  
`http://localhost:8080/swagger-ui.html`

### 🧪 Executar testes | Run tests

```bash
# Executa os testes automatizados | Run automated tests
./mvnw test
```

## 📂 Estrutura | Project Structure

```text
src
└── main
    ├── java
    │   └── com
    │       └── loans
    │           ├── controller
    │           │   └── CustomerController.java
    │           ├── dto
    │           │   ├── request
    │           │   │   └── RequestCustomerDTO.java
    │           │   └── response
    │           │       └── ResponseCustomerDTO.java
    │           ├── enums
    │           │   └── TypeLoan.java
    │           ├── model
    │           │   └── Loan.java
    │           ├── service
    │           │   └── LoanService.java
    │           └── LoansApplication.java
    └── resources
        ├── static
        ├── templates
        └── application.properties
```

## 🧑‍💻 Autor | Author
Desenvolvido por | Developed by **Francisco Montalvao** 🚀

## 🏛️ Licença | License
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.  
This project is under the MIT license. See the LICENSE file for more details.
