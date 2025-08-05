# JPA Basic Example

## Description

GraphQL is a query language and runtime for APIs that enables clients to request exactly the data they need, nothing more or less. Unlike REST, which relies on fixed endpoints returning predefined data structures, GraphQL allows clients to define the shape and depth of the response using a single flexible query. It operates over HTTP (typically via POST requests) and uses a type system to describe the API's capabilities, making it self-documenting. Servers resolve queries by fetching data from multiple sources (databases, microservices) and aggregating it into a tailored response. 
It includes the following key topics:

- Declarative data fetching (no over-fetching or under-fetching).
- Single endpoint (no versioned URLs like in REST).
- Real-time updates via subscriptions (WebSocket-based).
- Strong typing with schema validation.

- @QueryMapping
    - Used for query operations (data fetching).
    - The name attribute explicitly binds the method to a query in the schema.
    - If name is omitted, Spring uses the method name by default.

- @MutationMapping
    - Handles write operations (create, update, delete).
    - Follows the same naming rules as @QueryMapping.



## Quick Start

### Prerequisites

- Java 17+ (recommended for Spring Boot 3+)
- Spring Boot version: 3.2.9
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
   - spring-boot-starter-graphql
