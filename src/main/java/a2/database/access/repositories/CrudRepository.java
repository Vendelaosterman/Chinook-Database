package a2.database.access.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

// Generic CRUD parent interface
@Repository
public interface CrudRepository <T, ID>{

    /**
     * Retrieves all entities of type T.
     *
     * @return A collection of entities.
     */
    Collection<T> findAll();

     /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity.
     * @return An entity of type T, or null if not found.
     */
    T findById(ID id);

    /**
     * Inserts a new Customer.
     *
     * @param object The entity object to be inserted.
     * @return The number of affected rows or an indicator of success (e.g., 1 if successful, 0 if failed).
     */
    int insert(T object);
}
