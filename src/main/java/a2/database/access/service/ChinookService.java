package a2.database.access.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import a2.database.access.model.Customer;
import a2.database.access.repositories.CustomerRepository;
import a2.database.access.model.CustomerCountry;
import a2.database.access.model.CustomerSpender;
import a2.database.access.model.CustomerGenre;


@Service
public class ChinookService implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public ChinookService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception{

        //printAll();

        //printById();

        //printByName();

        //printPage();

        //insertCustomer();

        //printCommonCountry();

        //printHighestSpender();

        printPopularGenre();

    }

    // Printing out all the customers from customer table
    public void printAll(){
         Collection<Customer> customers = customerRepository.findAllCustomers();
        
        for (Customer customer : customers) {
            System.out.println(
                "Id: " + customer.getId() + "\n"
             + "First name: " + customer.getFirstName() + "\n"
             + "Last name: " + customer.getLastName() + "\n"
             + "Country: " + customer.getCountry() + "\n"
             + "Postal Code: " + customer.getPostalCode() + "\n"
             + "Phone: " + customer.getPhone() + "\n"
             + "Email: " + customer.getEmail() + "\n");
        }
    }

     // Printing out a specific customer by id
    public void  printById(){
         Customer customerById = customerRepository.findById(7);
        System.out.println(
                "Id: " + customerById.getId() + "\n"
             + "First name: " + customerById.getFirstName() + "\n"
             + "Last name: " + customerById.getLastName() + "\n"
             + "Country: " + customerById.getCountry() + "\n"
             + "Postal Code: " + customerById.getPostalCode() + "\n"
             + "Phone: " + customerById.getPhone() + "\n"
             + "Email: " + customerById.getEmail() + "\n");
    }

     // Printing out a specific customer by name      
     public void printByName(){
        Customer customerByName = customerRepository.findByName("Emma");
        System.out.println(
                "Id: " + customerByName.getId() + "\n"
             + "First name: " + customerByName.getFirstName() + "\n"
             + "Last name: " + customerByName.getLastName() + "\n"
             + "Country: " + customerByName.getCountry() + "\n"
             + "Postal Code: " + customerByName.getPostalCode() + "\n"
             + "Phone: " + customerByName.getPhone() + "\n"
             + "Email: " + customerByName.getEmail() + "\n");    
    }
    
    // Printing out a page of customer 
    public void printPage(){
        Collection<Customer> page = customerRepository.returnPage(20, 9);
        for (Customer customer : page) {
            System.out.println(
                "Id: " + customer.getId() + "\n"
             + "First name: " + customer.getFirstName() + "\n"
             + "Last name: " + customer.getLastName() + "\n"
             + "Country: " + customer.getCountry() + "\n"
             + "Postal Code: " + customer.getPostalCode() + "\n"
             + "Phone: " + customer.getPhone() + "\n"
             + "Email: " + customer.getEmail() + "\n");
        }
    }     

    // Insert customer to customer table   
    public void insertCustomer(){
        Customer newCustomer = new Customer(0, "John", "Doe", "USA", "12345", "555-1234", "john.doe@example.com");   
        int result = customerRepository.insert(newCustomer);
        System.out.println(result);
        if(result == 1){
            System.out.print("Customer successfully inserted" + "\n");
        }else{
            System.out.println("Customer could not be inserted" + "\n");
        }
    }

    // Find most common Country 
    public void printCommonCountry(){
        CustomerCountry country = customerRepository.findCommonCountry();
        System.out.println("\n" + "Most common country: " + country.getCountry());  
    }

     // Find the highest spender on invoice 
    public void printHighestSpender(){
        CustomerSpender highestSpender = customerRepository.findHighestSpender();
        System.out.println("Highest spender: " + "\n"
        + "Customer id: " + highestSpender.getId() + "\n"
        + "First name: " + highestSpender.getFirstName() + "\n"
        + "Last name: " + highestSpender.getLastName() + "\n"
        + "Total spent: " + highestSpender.getTotalSpent());
    } 

    // Printing out most popular genre for given customer id 
    public void printPopularGenre(){
         CustomerGenre popularGenre = customerRepository.findPopularGenre(45);
        System.out.println("Popular genre for customer_id: " + popularGenre.getCustomerId() + "\n"
        + "Genre ID: " + popularGenre.getGenreId() + "\n"
        + "Genre name: " + popularGenre.getGenreName() + "\n"
        + "Genre count: " + popularGenre.getGenreCount());
    }
    
}
