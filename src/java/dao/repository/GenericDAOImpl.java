package dao.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lucqu
 * @param <T>
 */
@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    
    private final Class<T> class_type;
    
    public GenericDAOImpl(Class<T> type) {
        this.class_type = type;
    }
    
    /*
    Get the entity manager
    */
    
    @PersistenceContext(unitName="BankPU")
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    /*
    Implementation of the GenericDAO methods
    */ 
    @Override
    @Transactional
    public List<T> findAll(){
        return this.em.createQuery("Select t from " + this.class_type.getSimpleName() + " t").getResultList();
    };

    
    @Override
    @Transactional
    public void save(T entity) {
        em.merge(entity);
        em.persist(entity);
    }

    @Override
    @Transactional
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }
    
    
    @Override
    @Transactional
    public T find(Object id) {
        return em.find(class_type, id);
    }
    
}
