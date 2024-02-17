# Online Bookstore

## Description

The Online Bookstore is a comprehensive platform designed to facilitate an engaging and efficient book shopping experience. It allows users to easily browse, search, and purchase books from a wide range of genres and authors. The application is built with robust features including user authentication, inventory management, and order processing to ensure a seamless operation from browsing to checkout.

## Key Concepts

- **Spring MVC**: Utilized for the web layer, enabling the development of dynamic web pages and simplifying the handling of user requests and responses.
- **Spring Data JPA**: Employs the Java Persistence API for data access operations, enhancing the application's interaction with the database through a simplified data access layer.
- **Spring Security**: Provides comprehensive authentication and authorization functionalities to secure the application against unauthorized access.
- **Thymeleaf**: Used for views, allowing for the creation of dynamic HTML content with elegant syntax and integration with the Spring framework.

## Advanced Features

- **Payment Gateway Integration**: The application integrates with a payment gateway to facilitate secure and efficient processing of payments, offering users a variety of payment options.
- **Spring Boot Actuator**: Implemented for monitoring the application’s health and performance, providing insights into the application's runtime operations and environment.
- **Docker Deployment**: The application is containerized using Docker, streamlining the deployment process and ensuring consistency across different environments by encapsulating the application and its dependencies into a Docker container.

This platform is designed with scalability and security in mind, leveraging the strengths of the Spring framework and modern development practices to provide a user-friendly and reliable online bookstore.



2. What is it?
Spring framework that simplifies HTTP request and responses.
MVC - model-view-controller

Controller layer -> URL 
Model Layer -> Data representation 
View Layer -> Web page

Dispatcher Servlet -> Front controller, pattern
Handler Mapping


3. Models Needed
Books
@Entity 
@Id -> primary key
@GeneratedValue -> increment automatically 

4. CRUD
create, update, get, delete

5. DTO 
data transfer object -> models Book to DTO, we don't want the data to be floating around the app

6. Service 

specific methods with multiple repository calls


Validation should be on the DTO

7. JPQL

Named vs index
contains vs like