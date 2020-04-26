package dao.repository;

import dao.entity.AdvisorEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucqu
 */
@Repository
public class AdvisorDAOImpl extends GenericDAOImpl<AdvisorEntity> implements AdvisorDAO {
    
    public AdvisorDAOImpl(){
        super(AdvisorEntity.class);
    }
}
