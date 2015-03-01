package Model;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class DAOJPA<T, I extends Serializable> implements DAO<T, I> {
    
    private EntityManager manager;

    public DAOJPA(EntityManager manager){
        this.manager = manager;
    }
    
    @Override
    public void save(T entity) {
        try{
        this.manager.merge(entity);
        }catch(NullPointerException e){
            System.out.print(e.getMessage() + e.getCause());
        }
    }

    @Override
    public T getById(Class<T> classe, I pk) {
        try{
            return this.manager.find(classe, pk);
        } catch(NoResultException e){
            return null;
        }
    }
}