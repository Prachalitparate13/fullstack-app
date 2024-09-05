

# Contacts Website

## Overview

The Contacts Website is a full-stack application designed to manage and display contact information. It is built using React for the front-end, Spring Boot for the back-end, and PostgreSQL for the database. This application allows users to create, read, update, and delete contact entries.

## Features

- CRUD (Create, Read, Update, Delete) operations for contacts
- Responsive user interface
- Secure API endpoints

## Technologies Used

- **Front-End:** React
- **Back-End:** Spring Boot
- **Database:** PostgreSQL
- **Build Tools:** Maven, npm
- **Version Control:** Git

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- **Java 11+** (for Spring Boot)
- **Node.js** (for React)
- **PostgreSQL** (for database)
- **Maven** (for building the Spring Boot application)
- **Git** (for version control)

## Installation

### Back-End (Spring Boot)

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/fullstack-app.git
    cd contacts-website/api.contact
    ```

2. **Configure Database**

    - Ensure PostgreSQL is running.
    - Create a new database named `contactDb`.
    - Update `src/main/resources/application.properties` with your database credentials.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/contactDb
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    ```

3. **Build and Run**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    The backend server will start on `http://localhost:8081`.

### Front-End (React)

1. **Navigate to Front-End Directory**

    ```bash
    cd ../appcontact
    ```

2. **Install Dependencies**

    ```bash
    npm install
    ```

3. **Configure API URL**

    - Update `src/api/ContactService.js` to point to your backend server URL.

    ```javascript
    export const API_URL = 'http://localhost:8081/contacts';
    ```

4. **Start the Development Server**

    ```bash
    npm start
    ```

    The front-end application will be available at `http://localhost:3000`.

## Usage

1. **Access the Application**

    Open your browser and navigate to `http://localhost:3000`.


2. **Manage Contacts**

    - Add new contacts
    - Edit existing contacts
    - Delete contacts
    - Search and filter contacts


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or issues, please contact:

- **Email:** prachalitparate13@gmail.com
- **GitHub:** [Prachalitparate13](https://github.com/Prachalitparate13)

---
