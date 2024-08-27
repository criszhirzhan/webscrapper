# Web Scrapper - Spring Boot Project

## Project Overview
This is a **Web Scrapper** application built using **Spring Boot**. The project aims to scrape web pages for specific data and process it. It uses modern web technologies like **Spring Boot**, **Jsoup** for web scraping, and **PostgreSQL** for data storage.

## Features
- **Spring Boot Framework**: Simplifies the setup and development of web applications.
- **Jsoup Library**: Efficiently parses HTML and extracts data from web pages.
- **PostgreSQL Database**: Used for storing scraped data with JPA for ORM support.
- **Lombok**: Reduces boilerplate code for Java classes by generating methods like getters and setters.
- **DevTools**: Provides auto-reload and easier development experience.

## Prerequisites
- **Java 17**
- **Maven 3.x** or higher
- **PostgreSQL** (Ensure PostgreSQL is installed and running)

## Project Structure
The project is structured as a standard Maven project. The main components are:
- `src/main/java`: Contains the Java source code for the project.
- `src/main/resources`: Contains configuration files like `application.properties`.
- `pom.xml`: Contains the project dependencies and configurations.

## Installation

### Clone the Repository
To get started with the project, clone the repository from GitHub:
```bash
git clone https://github.com/criszhirzhan/webscrapper.git
cd webscrapper
```

## Database Configuration
Edit the src/main/resources/application.properties file with your PostgreSQL configuration:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
Make sure the webscrapperdb database exists, and your credentials (yourusername and yourpassword) are correct.

## Technologies Used
- Spring Boot: Application framework to build Java-based applications.
- PostgreSQL: Database used for storing data.
- Jsoup: HTML parser for scraping and processing data.
- JPA: Object-relational mapping (ORM) framework.
- Lombok: To avoid boilerplate code.
- Maven: For managing dependencies and building the project.

## Access the Application
The application will run on 'http://localhost:8080' by default. You can access the API using the following endpoint:

```bash
GET http://localhost:8080/api/search?query=keyword
```

## Example Queries

You can perform a search using the following REST API endpoint:

```bash
GET http://localhost:8080/api/search?query=chocolate
```

