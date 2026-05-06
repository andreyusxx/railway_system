# 🚆 Railway Management System

A comprehensive **Spring Boot** web application designed for managing railway operations, including train schedules, passenger accounts, and secure ticket booking. This project demonstrates the implementation of **Spring Security**, **JPA/Hibernate**, and a **Relational Database** architecture.

## 🚀 Features

* **Security & Authentication:**
    * Full integration with **Spring Security**.
    * Secure password storage using **BCrypt** hashing with encoding prefixes.
    * Custom login and logout flows.
* **Role-Based Access Control (RBAC):**
    * `ROLE_ADMIN`: Access to the administrative dashboard, full CRUD operations on train schedules, and passenger management.
    * `ROLE_USER`: Access to search routes, view personal ticket history, and manage profiles.
* **Train Management:**
    * Real-time search for active train routes.
    * Pricing and destination management.
* **Database Integration:**
    * Relational schema with automated data initialization via `CommandLineRunner`.
    * Persistent storage using **MySQL**.

## 🛠 Tech Stack

* **Language:** Java 17 (JDK 17)
* **Framework:** Spring Boot 3.x / 4.x
* **Security:** Spring Security 6/7
* **ORM:** Spring Data JPA (Hibernate)
* **Database:** MySQL 8.x
* **Templating:** FreeMarker (.ftlh)
* **Build Tool:** Maven

## 📋 Prerequisites

Before you begin, ensure you have the following installed:
* **JDK 17** (Crucial for class version compatibility)
* **MySQL Server**
* **Maven** (or use the provided `mvnw` wrapper)

## 🔧 Configuration & Installation

### 1. Database Setup
Create a new schema in your MySQL instance:
```sql
CREATE DATABASE railway_db;
```

### 2. Application Properties
Configure your connection details in src/main/resources/application.properties:Properties# Server settings
```java
server.port=8081

# Database settings
spring.datasource.url=jdbc:mysql://localhost:3306/railway_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Security settings
spring.jpa.open-in-view=false
```

### 3. Building the Project
Use Maven to package the application into a JAR file:
```bash
mvn clean package
```

### 4. Running the Application
Run the generated JAR file from the target directory:
```bash
java -jar target/railway-system-0.0.1-SNAPSHOT.jar
```
### 🏗 Project Structure
* ua.com.kisit.railwaysystem.config: Security and MVC configurations.
* ua.com.kisit.railwaysystem.entity: Database models (User, Role, Passenger, Train).
* ua.com.kisit.railwaysystem.repository: Data access layers (JPA Repositories).
* ua.com.kisit.railwaysystem.service: Business logic and security implementation.
* ua.com.kisit.railwaysystem.controller: Web request handling.

🔑 Default CredentialsUpon the first startup, the application automatically initializes the following accounts:
| Role | Username | Password |
| :--- | :---: | ---: |
| Administrator | andrii | admin123 |
| Standard User | manager | 12345 |
