# 🎓 EduCore - Enterprise School Management System

**EduCore** is a learning-focused, enterprise-style project designed to simulate a real-world **School Management System** using modern microservices architecture.

The primary objective of EduCore is to gain hands-on experience with **Cloud-Native Java Development** by building a highly scalable, loosely coupled, and production-grade distributed system using the Spring ecosystem.

This project intentionally moves away from a monolithic mindset and demonstrates how real enterprise systems are designed, developed, and operated.

## 🏗️ Architecture & Design Principles

EduCore follows strict architectural principles inspired by real-world enterprise systems.

### ✅ Architectural Patterns
* **Hexagonal Architecture (Ports & Adapters):** Core business logic is isolated from infrastructure concerns like databases, messaging, and REST controllers.
* **Domain-Driven Design (DDD):** Services are structured around business domains (Student, School) instead of technical layers.
* **Event-Driven Architecture (EDA):** Asynchronous communication using **Apache Kafka** to decouple services and improve scalability.
* **Database-per-Service Pattern:** Each microservice owns its database schema, ensuring loose coupling and independent evolution.
* **API Gateway Pattern:** **Spring Cloud Gateway** acts as the single entry point, handling routing, filtering, and load balancing.
* **Service Discovery Pattern:** **Netflix Eureka** enables dynamic service registration and discovery without hardcoded URLs.
* **Externalized Configuration:** Configuration is centralized using **Spring Cloud Config Server** backed by a Git repository.

---

## 🚀 Tech Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.2 |
| **API Gateway** | Spring Cloud Gateway |
| **Service Discovery** | Netflix Eureka |
| **Config Management** | Spring Cloud Config Server |
| **Sync Communication** | OpenFeign |
| **Async Communication** | Apache Kafka |
| **Database** | PostgreSQL |
| **Observability** | Zipkin |
| **Containerization** | Docker, Docker Compose |

---

## ⚡ Getting Started

### 1️⃣ Prerequisites
Make sure the following are installed on your system:
* **Java 17+**
* **Maven 3.8+**
* **Docker & Docker Compose**

### 2️⃣ Start Infrastructure Services
This command will start PostgreSQL, Apache Kafka, Zookeeper, Kafka UI, and Zipkin.
```bash
docker-compose up -d
```

## 🔌 API Reference (via Gateway)

**Base URL:** `http://localhost:8080`
*(🚫 Do NOT access services directly using internal ports. Always use the API Gateway.)*

### 🏫 School APIs
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/schools` | Create a new school |
| `GET` | `/api/v1/schools` | Get all schools (includes students) |
| `GET` | `/api/v1/schools/{id}` | Get school by ID |

### 👨‍🎓 Student APIs
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/students` | Register a new student |
| `GET` | `/api/v1/students/school/{school-id}` | Get students by school |

---

## 🛠️ Configuration & Troubleshooting

### 🔧 Centralized Configuration
* All configuration files are stored in the `educore-config` Git repository.
* Services fetch configuration from Config Server during startup.

### 🔍 Service Discovery Issues
If an API returns `503 Service Unavailable`:
1.  Open Eureka Dashboard → [http://localhost:8761](http://localhost:8761)
2.  Verify the target service is in **UP** state.

### ⚠️ Common Issues
* **Port 8080 busy:** Stop other applications using it (or check if Kafka UI is incorrectly mapped).
* **Kafka not reachable:** Ensure Docker containers are running (`docker ps`).
* **Config not loading:** Verify Config Server is started first.

---

## 🎯 Learning Outcomes
By working on EduCore, you will gain experience in:
* Designing enterprise-grade microservices.
* Applying Hexagonal Architecture & DDD.
* Service-to-service communication (Feign + Kafka).
* Centralized configuration & service discovery.
* Containerized development workflows.
* Observability and tracing with Zipkin.

---

## 📌 Disclaimer
This project is intended for learning and architectural exploration. It mimics enterprise patterns but is not production-hardened.