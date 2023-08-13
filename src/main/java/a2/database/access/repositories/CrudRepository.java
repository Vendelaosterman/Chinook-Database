package a2.database.access.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository <T, ID>{

    Collection<T> findAllCustomers();

    T findById(ID id);

   // T add(T entity);

    //T update(T entity);

    //void deleteById(ID id);
}
