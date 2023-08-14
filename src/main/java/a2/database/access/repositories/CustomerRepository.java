package a2.database.access.repositories;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import a2.database.access.model.Customer;
import a2.database.access.model.CustomerCountry;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByName(String firstName);

    Collection<Customer> returnPage(Integer limit, Integer offset);

    CustomerCountry findCommonCountry();
}
