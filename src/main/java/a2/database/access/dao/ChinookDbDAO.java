package a2.database.access.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChinookDbDAO {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void testDatabaseConnection(){
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println(String.format("\n>>> Connected to database: %s\n", conn.getMetaData().getURL()));
        }catch(SQLException sqle){
            // handle exception
            sqle.printStackTrace();
        }

    }

    public void printAllCustomers(){
        String sql = "SELECT * FROM customer";

        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("\n");
                System.out.println("id: " + resultSet.getString(1));
                System.out.println("first name: " + resultSet.getString(2));
                System.out.println("last name: " + resultSet.getString(3));
                System.out.println("country: " + resultSet.getString(8));
                System.out.println("postal code: " + resultSet.getString(9));
                System.out.println("phone: " + resultSet.getString(10));
                System.out.println("email: " + resultSet.getString(12));
            }
        }catch(SQLException sqle){
            // handle exception
            sqle.printStackTrace();
        }
    }
    
}
