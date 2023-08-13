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

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

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

    //System.out.println("id: " + resultSet.getString(1));
	
	/*public List<Customer> findByFirstName(String firstName) {
        ArrayList<Customer> customerList = new Arraylist<>();
        try(Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE first_name= ?")){
            statement.setString(1, firstName);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(8)
                )
            }
        }
		// Implement
	}*/
	
	// Additional methods as per the interfaces to implement
}
