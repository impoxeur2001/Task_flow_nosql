# Task_flow_nosql
Project Description
This project involved migrating a backend application from a SQL database to a NoSQL database, specifically MongoDB. The MongoDB database is running within a Docker container.

Installation
To install and run this project on your local machine, follow these steps:

Clone the repository to your local machine.

Ensure that you have Docker installed on your machine. 

Open a terminal window and navigate to the root directory of the project.


Start the Docker container by running the following command:

Copy
docker run -d --name mongo-on-docker -p 27017:27017 mongo
```

The application should now be running on http://localhost:8080.

Usage
To use the application, follow these steps:

Open your web browser and navigate to http://localhost:8080.

The application should display a list of items from the database.

You can add, edit, or delete items by using the appropriate buttons on the page.


Credits
This project was created by Malainine Mohamed Limame and the original application is by Allam Mohamed.
