package dao.repository;

import dao.entity.ProfessionalEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucqu
 */
@Repository
public class ProfessionalDAOImpl extends GenericDAOImpl<ProfessionalEntity> implements ProfessionalDAO {
    
    public ProfessionalDAOImpl(){
        super(ProfessionalEntity.class);
    }
}
