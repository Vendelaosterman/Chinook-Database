package a2.database.access.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

// Generic CRUD parent interface
@Repository
public interface CrudRepository <T, ID>{

    //Returns a collection of all customers
    Collection<T> findAll();

    // Finds and returns a customer by its unique identifier.
    T findById(ID id);

    // Inserts a new customer
    int insert(T object);
}
