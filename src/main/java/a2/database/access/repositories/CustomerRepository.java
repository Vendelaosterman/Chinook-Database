package a2.database.access.repositories;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import a2.database.access.model.Customer;
import a2.database.access.model.CustomerCountry;
import a2.database.access.model.CustomerSpender;
import a2.database.access.model.CustomerGenre;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    // Returns a customer by a specific name 
    Customer findByName(String firstName);

    // Returns a page of rows with limit and offset 
    Collection<Customer> returnPage(Integer limit, Integer offset);

    //Returns the most common country of customers
    CustomerCountry findCommonCountry();

    //Returns the highest spender of customers
    CustomerSpender findHighestSpender();

    //Returns a collection of a customers most popular genre 
    Collection<CustomerGenre> findPopularGenre(Integer id);
}
