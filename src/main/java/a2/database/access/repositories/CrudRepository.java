package a2.database.access.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository <T, ID>{
    Collection<T> findAll();
    T findById(ID id);

    //additional methods 
}
