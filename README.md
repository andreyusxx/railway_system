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
