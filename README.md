# domain-model-orm-challenge

## Introduction
This project was developed as part of the **Module 2 Challenge** of the **Java Spring Professional** course on the DevSuperior platform. The system is designed to manage events, including participants, activities, categories, and time blocks.

## Class Diagram
Below is the class diagram for the system:

![image](https://github.com/user-attachments/assets/313b8da8-a036-4e52-880d-d8259230682b)


### Explanation
- **Participant**: Represents an individual who registers for activities. Contains `id`, `name`, and `email` attributes.
- **Activity**: Represents an event activity. Contains `id`, `name`, `description`, and `price` attributes. Each activity belongs to a **Category** and is linked to one or more **Participants**.
- **Category**: Defines the type of an activity. Contains `id` and `description` attributes.
- **Block**: Represents a time slot for an activity. Contains `id`, `start`, and `end` attributes. Each **Block** is associated with one **Activity**.

## How to Run the Project
To run this project locally, follow these steps:

### Prerequisites
Ensure you have the following installed on your machine:
- Java 17+
- Maven
- Docker (for database setup, if applicable)
- An IDE like IntelliJ IDEA or VS Code (with Spring Boot support)

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/GabrielPongelupe/domain-model-orm-challenge.git
   cd domain-model-orm-challenge
   ```
2. **Build and Run the Application**
   ```sh
   mvn spring-boot:run
   ```
3. **Access the API**
   The application will be available at: `http://localhost:8080`

## Technologies Used
- Java with Spring Boot
- JPA/Hibernate
- H2 Database (or PostgreSQL/MySQL if configured)
- Maven

## Contact
For any questions or improvements, feel free to contribute to the repository or contact the author.

---

*This project was developed as part of the DevSuperior Java Spring Professional course.*

