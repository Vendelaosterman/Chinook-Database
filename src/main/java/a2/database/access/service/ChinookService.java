package a2.database.access.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import a2.database.access.model.Customer;
import a2.database.access.repositories.CustomerRepository;

@Service
public class ChinookService implements ApplicationRunner {

    private final CustomerRepository chDao;

    @Autowired
    public ChinookService(CustomerRepository chDao){
        this.chDao = chDao;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception{

        // Printing out all the customers from customer table
        Collection<Customer> customers = chDao.findAllCustomers();
        
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

        // Printing out a specific customer by id
        Customer customer = chDao.findById(7);
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
