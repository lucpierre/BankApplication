package dao.repository;

import dao.entity.AdministratorEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucqu
 */
@Repository
public class AdministratorDAOImpl extends GenericDAOImpl<AdministratorEntity> implements AdministratorDAO {
    
    public AdministratorDAOImpl(){
        super(AdministratorEntity.class);
    }
}
