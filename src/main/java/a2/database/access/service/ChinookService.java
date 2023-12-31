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

/**
 * Service class that implements the ApplicationRunner interface to perform various data access operations.
 */
@Service
public class ChinookService implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public ChinookService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception{

        printAll();

        printById();

        printByName();

        printPage();

        insertCustomer();

        printCommonCountry();

        printHighestSpender();

        printPopularGenre();

    }

    /**
     * Prints out all customers from the customer table.
     */
    public void printAll(){
         Collection<Customer> customers = customerRepository.findAll();
        
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

    /**
     * Prints out a specific customer by their ID.
     */
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

      /**
     * Prints out a specific customer by their name.
     */      
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
    
    /**
     * Prints out a page of customers from the customer table.
     */ 
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

        /**
     * Inserts a new customer into the customer table.
     */   
    public void insertCustomer(){
        Customer newCustomer = new Customer(
            0, 
            "John", 
            "Doe", 
            "USA", 
            "12345", 
            "555-1234", 
            "john.doe@example.com");   
        int result = customerRepository.insert(newCustomer);

        if(result == 1){
            System.out.print("Customer successfully inserted" + "\n");
        }else{
            System.out.println("Customer could not be inserted" + "\n");
        }
    }

    /**
     * Prints the most common country among customers.
     */
    public void printCommonCountry(){
        CustomerCountry country = customerRepository.findCommonCountry();
        System.out.println("\n" + "Most common country: " + country.getCountry());  
    }

    /**
     * Prints the customer who is the highest spender.
     */ 
    public void printHighestSpender(){
        CustomerSpender highestSpender = customerRepository.findHighestSpender();
        System.out.println("Highest spender: " + "\n"
        + "Customer id: " + highestSpender.getId() + "\n"
        + "First name: " + highestSpender.getFirstName() + "\n"
        + "Last name: " + highestSpender.getLastName() + "\n"
        + "Total spent: " + highestSpender.getTotalSpent());
    } 

    /**
     * Prints out the most popular genre(s) for a given customer ID.
     */ 
    public void printPopularGenre(){
        Collection<CustomerGenre> genres = customerRepository.findPopularGenre(12);
         
        System.out.println("Popular genres for specific customer:");
        for (CustomerGenre genre : genres) {
            System.out.println("Genre ID: " + genre.getGenreId() + "\n"
        + "Genre name: " + genre.getGenreName() + "\n"
        + "Genre count: " + genre.getGenreCount() + "\n");
        }
    }
    
}
