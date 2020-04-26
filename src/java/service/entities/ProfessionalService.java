package service.entities;

import dao.entity.ProfessionalEntity;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface ProfessionalService {
    public ProfessionalEntity find(String id);
    public List<ProfessionalEntity> findAll();
    public void save(ProfessionalEntity u);
    public void update(ProfessionalEntity entity);
    public void delete(ProfessionalEntity entity);
}
