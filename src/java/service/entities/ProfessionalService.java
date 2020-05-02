package service.entities;

import dao.entity.ProfessionalEntity;
import exceptions.LoginAlreadyUsedException;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface ProfessionalService {
    public ProfessionalEntity find(String id);
    public List<ProfessionalEntity> findAll();
    public void save(ProfessionalEntity u) throws LoginAlreadyUsedException;
    public void update(ProfessionalEntity entity);
    public void delete(ProfessionalEntity entity);
}
