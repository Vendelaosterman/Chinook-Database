# Chinook Database Access Application

This is a Java application that provides access to the Chinook database, allowing you to perform various operations on customer data and analyze sales information. The application utilizes the Repository Pattern to interact with the database, providing a modular and structured approach to data access.

## Features

- Retrieve a list of all customers in the database, displaying their details including ID, first name, last name, country, postal code, phone number, and email.
- Find a specific customer by their ID, displaying all their details.
- Find a specific customer by their first name.
- Retrieve a page of customers from the database using limit and offset parameters.
- Add a new customer to the database.
- Find the country with the most customers.
- Identify the customer with the highest spending based on the total from the invoice table.
- Determine the most popular genre for a given customer based on the number of tracks from invoices associated with that customer.

## Setup and Usage

1. Clone the repository.
2. Open the project in your preferred Java development environment.
3. Configure the database connection settings in `application.properties` or the appropriate configuration file for your environment.

4. Build and run the application.

5. Use the provided service methods to interact with the database and perform the desired operations. Examples of how to use each method are provided in the `ChinookService` class.

## Folder Structure

- `src/main/java`: Contains the Java source code.
- `a2/database/access`: The main package for the application.
 - `models`: Contains the model classes for each data structure.
 - `repositories`: Contains the repository interfaces and their implementations.
 - `services`: Contains the service classes that interact with repositories.
- `resources`: Contains configuration files, such as `application.properties`.

## Dependencies

- Java 8 or higher
- JDBC Driver for your chosen database (e.g., PostgreSQL, MySQL)
- Spring Framework (for dependency injection and configuration)

## Authors

@VendelaOsterman / Vendela Österman
@ninita11 / Karina Esbjörsson
