# 👾 MonsterShop API

This is the backend API for **MonsterShop**, an e-commerce application where users can explore products, read reviews, and rate items. It is built using **Java 21**, **Spring Boot**, and **MySQL**, with a clean, layered architecture and RESTful design.


<br>

## 📚 Table of Contents

* [Features](#-features)
* [Technologies Used](#-technologies-used)
* [Project Structure](#-project-structure)
* [Getting Started](#-getting-started)

    * [Prerequisites](#-prerequisites)
    * [Database Configuration](#-database-configuration)
    * [Run the Project](#-run-the-project)
* [API Endpoints](#-api-endpoints)
* [Error Handling](#-error-handling)
* [License](#-license)
* [Author](#-author)

<br>

## 🎯 Features

* 🛒 View, create, update, and delete products
* 📝 Add and view product reviews
* ⭐ Support for product ratings
* ✅ Request validation using Jakarta Bean Validation
* ⚠️ Centralized error handling via `@RestControllerAdvice`
* 🗃️ MySQL database integration
* 🔄 RESTful and modular service-layer design

<br>

## 🛠️ Technologies & Tools

* Java 21
* Spring Boot 3.x
* Spring Web (REST)
* Spring Data JPA
* MySQL
* Jakarta Bean Validation
* Maven
* Postman (for testing)
* Git & GitHub
* Trello (for task tracking)

<br>

## 📁 Project Structure

The project follows a clean **3-layer MVC architecture**:

```
src/
├── main/
│   ├── java/
│   │   └── com/femcoders/monstershop/
│   │       ├── controllers/
│   │       ├── dtos/
│   │       │   └── product/
│   │       │   └── review/
│   │       ├── exceptions/
│   │       ├── models/
│   │       ├── repositories/
│   │       └── services/
│   └── resources/
│       └── application.properties
```

<br>

## 🚀 Getting Started

### ✅ Prerequisites

* Java 21
* Maven
* MySQL running locally
* IDE (e.g., IntelliJ, VS Code)

<br>

### ⚙️ Database Configuration

In `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/monstershop
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

<br>

### ▶️ Run the Project

1. Clone the repository:

```bash
git clone https://github.com/Lizar22/monstershop-api.git
cd monstershop-api
```

2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

Base URL: `http://localhost:8080/api/`

<br>

## 🔌 API Endpoints

### 🛍️ Product Endpoints

| Method | Endpoint             | Description                                                   |
| ------ | -------------------- | ------------------------------------------------------------- |
| GET    | `/api/products`      | Returns all products registered in the system.                |
| GET    | `/api/products/{id}` | Returns the details of a specific product by its `id`.        |
| POST   | `/api/products`      | Creates a new product using the data provided in the request. |
| PUT    | `/api/products/{id}` | Updates an existing product identified by its `id`.           |
| DELETE | `/api/products/{id}` | Deletes an existing product identified by its `id`.           |

### 📝 Review Endpoints

| Method | Endpoint                   | Description                                          |
| ------ | -------------------------- | ---------------------------------------------------- |
| GET    | `/api/reviews/{productId}` | Returns all reviews associated with a given product. |
| POST   | `/api/reviews`             | Submits a new review for a product.                  |

<br>

## ⚠ Error Handling

All errors are handled globally using a `@RestControllerAdvice` class (`GlobalExceptionHandler`), which returns a structured response when exceptions are thrown.

Example of error response:

```json
{
  "message": "Product not found with id 99",
  "status": 404,
  "errorCode": "NOT_FOUND",
  "timestamp": "2025-06-18T12:34:56",
  "path": "/api/products/99"
}
```

Handled exceptions include:

* `NoSuchElementException`
* `IllegalArgumentException`
* Validation errors from DTOs

The response format is defined in the `ErrorResponse` class.

<br>

## 🧾 License

This project is part of the **FemCoders** educational program.

<br>

## 👩‍💻 Author

Developed with 💜 by [Lizar22](https://github.com/Lizar22)
GitHub Repo: [monstershop-api](https://github.com/Lizar22/monstershop-api)



