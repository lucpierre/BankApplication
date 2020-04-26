package service.entities;
import dao.entity.AdministratorEntity;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface AdministratorService {
    public AdministratorEntity find(String id);
    public List<AdministratorEntity> findAll();
    public void save(AdministratorEntity u);
    public void update(AdministratorEntity entity);
    public void delete(AdministratorEntity entity);
}
