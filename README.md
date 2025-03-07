# project Name : ToDoApplication
## Description : 
The ToDoApplication is a simple and efficient task management system that helps users to create, update and manage daily tasks.Built using SpringBoot,Hibernate, and MYSQL,
this application provides a REST API for CRUD operations,a llowing users to add,update,delete and mark tasks as completed.
## Features :
✔️ Add to new tasks with a title and date

✔️ View all tasks in a structured list

✔️ Edit or delete tasks as needed

✔️Data stored securely using MYSQL+JPA/Hibernate

✔️User-friendly UI
## Tech Stack:
**Backend :** Java,SpringBoot,Hibernate

**Database :** MySQL

**Frontend :** Jsp
## Installation & Setup :
### Prerequisites
✅Java 17+

✅MySQL installed

✅Maven
### Steps to Run
-> Clone the repository

git clone

https://github.com/Kalyani-boora/ToDoApplication.git
## Database configuration :
### Create Database :
-> CREATE DATABASE ToDoApplication;

-> SHOW DATABASES;
### Configure application.properties :
spring.application.name=ToDoApplication

server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/ToDoApplication?createDatabaseIfNotExist=true

spring.datasource.username=root

spring.datasource.password=Boora12@sql

spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.format_sql=true

spring.jpa.open-in-view=false

spring.mvc.view.prefix=/WEB-INF/views/

spring.mvc.view.suffix=.jsp
### Steps to Run :
mvn spring-boot:run
## API Endpoints :
### Test in Browser:
#### View To-Do List
->  URL:  http://localhost:8080/viewToDoList 

-> Description: Displays the list of all tasks.
#### Add a New Task
->  URL:  http://localhost:8080/addToDoTask

->Description: Opens the page to add a new task.
#### Edit a Task (Example: Task ID = 1)
->  URL: http://localhost:8080/editToDoTask/1

->Description: Opens the page to edit the task with ID 1.
## Contributing :
To contribute:

Fork the repository.

Create a new branch (feature-branch-name).

Commit your changes with a meaningful message.

Push your changes to your forked repository.

Open a Pull Request with a clear description of your changes.
## Contact Information :
-> GitHub:https ://github.com/kalyani-boora

-> LinkedIn : www.linkedin.com/in/boora-kalyani-96b655314

