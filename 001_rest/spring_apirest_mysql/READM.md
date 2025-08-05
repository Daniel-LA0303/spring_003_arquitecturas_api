# REST 

## Description

A REST API (Representational State Transfer Application Programming Interface) is a standardized architectural style for designing networked applications that communicate over HTTP. It follows stateless, client-server interactions where resources (like data objects) are identified by URLs (endpoints) and manipulated using predefined methods (GET, POST, PUT, DELETE). REST APIs return data in lightweight formats like JSON or XML, enabling seamless integration between systems. Key principles include uniform interfaces, cacheability, and scalability, making REST the dominant choice for web services, mobile backends, and microservices due to its simplicity, flexibility, and compatibility with web standards.

It includes the following key topics:

- Repository Layer:
    - Database connection (JPA, JDBC)
    - SQL/NoSQL queries
    - Basic CRUD operations

- Service Layer:
    - Business logic
    - Data validations
    - Transaction management

- Controller Layer
    - Request/response handling
    - Endpoint routing
    - Basic authentication



## Quick Start

### Prerequisites

- Java 17+ (recommended for Spring Boot 3+)
- Spring Boot version: 3.1.6
- Maven (optional, since `mvnw` is included)
- IDE: IntelliJ, Eclipse, or VS Code

### Run the Application

1. Execute the application:
   - **Windows**:
     ```bash
     mvnw.cmd clean spring-boot:run
     ```
   - **Linux/macOS**:
     ```bash
     ./mvnw clean spring-boot:run
     ```
   - **Using global Maven installation**:
     ```bash
     mvn clean spring-boot:run
     ```

   - **Run with a specific profile**:
     ```bash
     mvnw spring-boot:run -Dspring-boot.run.profiles=dev
     ```

2. Access the application:
   - Default URL: `http://localhost:8080/`

3. Execute tests:
   ```bash
   mvnw test
   ```

4. Dependencies used:
   - spring-boot-starter-web
   - spring-boot-devtools
   - mysql-connector-j
   - spring-boot-starter-data-jpa

