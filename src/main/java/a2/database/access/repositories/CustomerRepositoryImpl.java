package a2.database.access.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import a2.database.access.model.Customer;
import a2.database.access.model.CustomerCountry;
import a2.database.access.model.CustomerGenre;
import a2.database.access.model.CustomerSpender;
import a2.database.access.model.CustomerGenre;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    // Find all customers from customer table 
    public Collection<Customer> findAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(12)
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Find customer by specific id
    public Customer findById(Integer id){
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(12)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    // Find customer by specific name 
    public Customer findByName(String firstName){
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer WHERE first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(12)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    // return a page of customers
    public Collection<Customer> returnPage(Integer limit, Integer offset){
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM customer LIMIT ? OFFSET ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(12)
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Insert customer into customer table
    @Override
    public int insert(Customer customer){
        int rowsAffected = 0; // Initialize with zero, indicating failure
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO customer (first_name, last_name, country, postal_code, phone, email)" + 
            "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.firstName);
            preparedStatement.setString(2, customer.lastName);
            preparedStatement.setString(3, customer.country);
            preparedStatement.setString(4, customer.postalCode);
            preparedStatement.setString(5, customer.phone);
            preparedStatement.setString(6, customer.mail);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }

    @Override
    public CustomerCountry findCommonCountry(){
         CustomerCountry country = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT country FROM customer GROUP BY country ORDER BY COUNT(*) DESC LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                country = new CustomerCountry(
                    resultSet.getString(1)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }

    @Override
    public CustomerSpender findHighestSpender(){
        CustomerSpender highestSpender = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT customer.customer_id, customer.first_name , customer.last_name, SUM(invoice.total) AS total_spent\r\n" + //
                    "FROM customer\r\n" + //
                    "JOIN invoice ON customer.customer_id = invoice.customer_id\r\n" + //
                    "GROUP BY customer.customer_id, customer.first_name, customer.last_name\r\n" + //
                    "ORDER BY total_spent DESC\r\n" + //
                    "LIMIT 1;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                highestSpender = new CustomerSpender(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highestSpender;
    }

    @Override 
    public Collection<CustomerGenre> findPopularGenre(Integer id){
        List<CustomerGenre> popularGenres = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "WITH GenreCounts AS (\r\n" + //
                "SELECT c.customer_id, g.genre_id, g.name, COUNT(*) AS genre_count,\r\n" + //
                       "MAX(COUNT(*)) OVER() AS max_genre_count\r\n" + //
                "FROM customer c \r\n" + //
                "JOIN invoice i ON c.customer_id = i.customer_id\r\n" + //
                "JOIN invoice_line il ON i.invoice_id = il.invoice_id\r\n" + //
                "JOIN track t ON il.track_id = t.track_id\r\n" + //
                "JOIN genre g ON t.genre_id = g.genre_id\r\n" + //
                "WHERE c.customer_id = ? \r\n" + //
                "GROUP BY c.customer_id, g.genre_id, g.name)\r\n" + //
            "SELECT customer_id, genre_id, name, genre_count\r\n" + //
            "FROM GenreCounts \r\n" + //
            "WHERE genre_count = max_genre_count \r\n" + //
            "ORDER BY genre_count DESC;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CustomerGenre popularGenre = new CustomerGenre(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                );
                popularGenres.add(popularGenre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return popularGenres;

    }
}
