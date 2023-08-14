package a2.database.access.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository <T, ID>{

    Collection<T> findAllCustomers();

    T findById(ID id);

    int insert(T object);

    //T update(T entity);

    //void deleteById(ID id);
}
