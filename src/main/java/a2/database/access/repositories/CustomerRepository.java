package a2.database.access.repositories;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import a2.database.access.model.Customer;
import a2.database.access.model.CustomerCountry;
import a2.database.access.model.CustomerSpender;
import a2.database.access.model.CustomerGenre;

// Interface that extends the CrudRepository
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

        /**
     * Retrieves a customer by their specific first name.
     *
     * @param firstName The first name of the customer.
     * @return A Customer object representing the customer with the given first name, or null if not found.
     */
    Customer findByName(String firstName);

     /**
     * Retrieves a page of customers with the specified limit and offset.
     *
     * @param limit  The maximum number of customers to retrieve.
     * @param offset The starting index of customers to retrieve.
     * @return A collection of Customer objects representing the retrieved customers.
     */
    Collection<Customer> returnPage(Integer limit, Integer offset);

    /**
     * Retrieves the most common country among customers.
     *
     * @return A CustomerCountry object representing the most common country among customers.
     */
    CustomerCountry findCommonCountry();

    /**
     * Retrieves the customer who is the highest spender.
     *
     * @return A CustomerSpender object representing the highest spender customer.
     */
    CustomerSpender findHighestSpender();

    /**
     * Retrieves the most popular genre(s) of a specific customer.
     *
     * @param id The unique identifier of the customer.
     * @return A collection of CustomerGenre objects representing the most popular genre(s) of the customer.
     */ 
    Collection<CustomerGenre> findPopularGenre(Integer id);
}
