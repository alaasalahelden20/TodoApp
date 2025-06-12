
---

````markdown
# TodoApp

A simple Todo Application built with **Spring Boot**, **Spring Security**, and **postgreSQL**. It allows users to register, log in, and manage personal todo tasks.

## Features

- User registration and login
- Password encoding with BCrypt
- Spring Security integration
- Role-based access control (optional) //todo
- RESTful endpoints for todos
- Persistent storage using PostgreSQL
- Custom `UserDetailsService` implementation

## Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Getting Started

### Prerequisites

- Java 17 or newer
- PostgreSQL database
- Maven

### Clone the Repository

```bash
git clone https://github.com/your-username/TodoCRUD.git
cd TodoApp
````

### Configure Application Properties

Create or edit the `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Build and Run the Application

```bash
mvn spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080)

## API Endpoints

| Method | Endpoint               | Description            |
| ------ | -----------------------| ---------------------- |
| POST   | `/api/auth/register`   | Register new user      |
| POST   | `/api/auth/login`      | Authenticate user      |
| GET    | `/api/auth`            | Get all user           |
| POST   | `api/todos`            | Create a new todo item |
| GET    | `api/todos`            | Get all user todos     |
| GET    | `api/todos/{id}`       | Get a specific todo    |
| DELETE | `api/todos/{id}`       | Delete a specific todo |
| PUT    | `api/todos/{id}`       | Update a specific todo |


## Authentication

This app uses Spring Security:

* `/login` endpoint uses custom `AuthenticationManager`
* Passwords are securely stored using `BCryptPasswordEncoder`
* `UserDetailsService` fetches users from the database

## Folder Structure

```
src
├── main
│   ├── java
│   │   └── com.example.TodoApp
│   │       ├── controller
│   │       ├── entity
│   │       ├── repository
│   │       ├── security
│   │       ├── service
│   │       ├── Exceptions //todo
│   │       └── TodoAppApplication.java
│   └── resources
│       ├── application.properties
```

## License

This project is open-source and available under the [MIT License](LICENSE).

---

## Contact

For questions or support, feel free to open an issue or reach out at [alaasalahelden06@gmail.com](mailto:alaasalahelden06@gmail.com)

```

---

Let me know if you want to include a section on JWT, Swagger UI, or Docker support! I can also help you generate a [sample Swagger doc](f) or [Dockerfile](f).
```
