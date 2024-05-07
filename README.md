# Task List API

The Todo List API is a RESTful web service built with Java and Spring Boot, allowing users to manage their tasks. It provides endpoints for creating tasks, retrieving tasks, and more. This API also integrates with Trello API, enabling users to send tasks directly to Trello boards if desired.
When the card is send to Trello selected Trello board, the user gets a prompt with link when the card was moved to.
##Features

- Create tasks with title, description, and option to send to Trello board
- Retrieve all tasks
- Retrieve a specific task by ID
- Update a task
- Delete a task
- Integration with Trello API

Technologies Used

- Java
- Spring Boot
- JS
- JQuery
- MySQL (for the tasks database)
- Trello API

## Getting Started

To get started with the Todo List API, follow these steps:

1. Clone this repository to your local machine.
2. Set up your MySQL database and Trello API credentials.
3. Configure application properties (e.g., database connection details, Trello API key, etc.).
4. Build the project using Gradle.
5. Run the application.
6 You can now access the API endpoints locally.

## API Documentation

The API documentation is available via Swagger UI. You can access it here.

[Swagger link](http://localhost:8080/swagger-ui/index.html#/task-controller/)

![Screenshot 2024-05-07 at 21-52-44 Swagger UI](https://github.com/Sebczak/task-crud-api/assets/33517299/a05ba85f-aa28-4af4-8e78-2c2552875e7e)


Swagger link will work when the build will run localy.
## Frontend

The frontend for the Todo List application is built using JavaScript and jQuery. Below are some screenshots of how the app looks:
![Screenshot 2024-05-07 at 21-56-11 CRUD](https://github.com/Sebczak/task-crud-api/assets/33517299/9b9bbe2b-1eba-477d-a998-43575139cd58)
![Screenshot 2024-05-07 at 22-00-31 CRUD](https://github.com/Sebczak/task-crud-api/assets/33517299/90067972-7c33-4fda-b51f-3439fe37ecf7)
![Screenshot 2024-05-07 at 22-00-55 CRUD](https://github.com/Sebczak/task-crud-api/assets/33517299/13c76e27-9759-46e7-9c92-d7a5729e80a8)

## Usage

To use the Todo List API, you can send HTTP requests to the provided endpoints. Here are some examples:

![Screenshot 2024-05-07 at 21-57-28 Swagger UI](https://github.com/Sebczak/task-crud-api/assets/33517299/b9781c7e-4b16-41ec-a0cd-57d0a549445d)
![Screenshot 2024-05-07 at 21-57-43 Swagger UI](https://github.com/Sebczak/task-crud-api/assets/33517299/a96c8f4f-c168-4d10-9778-c504a3530eec)
![Screenshot 2024-05-07 at 21-57-59 Swagger UI](https://github.com/Sebczak/task-crud-api/assets/33517299/2ad3ca20-0781-4ee8-aaf6-65d41e94f3e7)

## Contributions

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
