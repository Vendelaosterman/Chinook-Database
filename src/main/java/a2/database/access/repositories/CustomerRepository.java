package a2.database.access.repositories;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import a2.database.access.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    //Collection<Customer> findAllCustomers();

    //additional methods 

}
