# 🛒 Product Management API  
## A Secure, Role-Based Spring Boot Backend Application

---

## 📌 Introduction

This project is a production-style backend application built using **Spring Boot 3** that provides a secure REST API for managing products.

The system implements modern backend development standards including:

- Stateless authentication using JWT
- Role-based authorization using Spring Security
- Layered architecture (Controller → Service → Repository)
- DTO-based data transfer
- Pagination and sorting support
- PostgreSQL database integration
- Interactive API documentation using Swagger

The application is designed to demonstrate real-world backend development practices with clean code structure and proper security configuration.

---

## 🎯 Objective

The primary goal of this project is to build a secure and scalable backend system that:

- Authenticates users using JWT
- Restricts API access based on user roles
- Manages product data efficiently
- Follows clean architectural separation
- Maintains production-level coding standards

---

## 🏗️ Application Architecture

The application follows a layered architecture to ensure separation of concerns and maintainability.

### 1️⃣ Controller Layer
Handles HTTP requests and responses.

**Responsibilities:**
- Mapping endpoints
- Request validation
- Returning standardized API responses

### 2️⃣ Service Layer
Contains business logic.

**Responsibilities:**
- Processing data
- Applying validations
- Handling transformations between Entity and DTO

### 3️⃣ Repository Layer
Handles database interaction using Spring Data JPA.

**Responsibilities:**
- CRUD operations
- Pagination and sorting queries

### 4️⃣ Security Layer

Implements:

- JWT token generation and validation
- Custom UserDetails and UserDetailsService
- Role-based method security using `@PreAuthorize`

---

## 🔐 Security Design

### 🔑 Authentication

- Implemented using JWT (JSON Web Token)
- Stateless session management
- Passwords encrypted using BCrypt
- Login endpoint returns signed JWT token

### 🛡 Authorization

The application supports two roles:

| Role  | Permissions |
|-------|------------|
| ADMIN | Create, Update, Delete, View products |
| USER  | View products only |

Method-level security is implemented using:

```java
@PreAuthorize("hasRole('ADMIN')")
```

Spring Security internally validates authorities prefixed with `ROLE_`.

---

## 🗃️ Database Design

### 👤 Users Table

| Column   | Description        |
|----------|-------------------|
| id       | Primary key        |
| username | Unique username    |
| password | Encrypted password |
| role     | ADMIN or USER      |

---

### 📦 Products Table

| Column      | Description          |
|-------------|----------------------|
| id          | Primary key          |
| name        | Product name         |
| description | Product description  |
| price       | Product price        |
| quantity    | Available stock      |

Username is enforced as unique to prevent duplication.

---

## 📦 Features Implemented

- JWT Authentication
- Role-Based Access Control
- Secure Password Encryption
- Custom UserDetails Implementation
- DTO Pattern
- Pagination & Sorting
- Standardized API Response Wrapper
- Swagger OpenAPI Integration
- PostgreSQL Database Connectivity
- Clean Project Structure

---

## 🚀 How to Run the Application

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/product-api-springboot.git
cd product-api-springboot
```

---

### Step 2: Configure Database

Create PostgreSQL database:

```sql
CREATE DATABASE productdb;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

### Step 3: Run Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run `ProductApiApplication` from your IDE.

---

## 📘 API Documentation

Once the application is running, access Swagger documentation:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows:

- Testing APIs interactively
- Authorizing using JWT
- Viewing request and response schemas

---

## 🔑 Authentication Flow

### Register

```
POST /api/auth/register
```

Example:

```json
{
  "username": "admin",
  "password": "12345",
  "role": "ADMIN"
}
```

---

### Login

```
POST /api/auth/login
```

Response:

```json
{
  "token": "JWT_TOKEN_HERE"
}
```

Use this token in Swagger:

```
Bearer JWT_TOKEN_HERE
```

---

## 📊 Product Endpoints

| Method | Endpoint | Access |
|--------|----------|--------|
| POST   | /api/products | ADMIN |
| GET    | /api/products | USER, ADMIN |
| GET    | /api/products/{id} | USER, ADMIN |
| PUT    | /api/products/{id} | ADMIN |
| DELETE | /api/products/{id} | ADMIN |

Supports pagination and sorting:

```
GET /api/products?page=0&size=5&sortBy=id&sortDir=asc
```

---

## 🧠 Key Technical Concepts Demonstrated

- Spring Security role prefix handling
- JWT-based stateless authentication
- Custom UserDetails integration
- Method-level security using annotations
- Clean layered architecture
- Dependency management via Spring Boot
- Database constraint management
- Secure password hashing
- RESTful API design principles

---

## 🔮 Possible Enhancements

- Refresh token mechanism
- Docker containerization
- Unit and integration testing
- Centralized global exception handling
- API rate limiting
- Logging & monitoring integration
- CI/CD pipeline setup

---

## 👨‍💻 Author

**Rogith Goud**  
Mechanical Engineering Student | Backend Developer  
Focused on building secure and scalable backend systems using Spring Boot and modern Java technologies.

---

## ⭐ Conclusion

This project demonstrates a strong understanding of backend architecture, security principles, and REST API development using Spring Boot. It serves as a foundation for building scalable enterprise-grade applications.
