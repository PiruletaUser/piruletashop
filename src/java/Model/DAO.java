package Model;

import java.io.Serializable;

public interface DAO<T, I extends Serializable> {
    
    void save(T entity);
    
    T getById(Class<T> classe, I pk);
}
