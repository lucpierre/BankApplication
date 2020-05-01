package service.entities;
import dao.entity.AdministratorEntity;
import exceptions.LoginAlreadyUsedException;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface AdministratorService {
    public AdministratorEntity find(String id);
    public List<AdministratorEntity> findAll();
    public void save(AdministratorEntity u) throws LoginAlreadyUsedException;
    public void update(AdministratorEntity entity) throws LoginAlreadyUsedException;
    public void delete(AdministratorEntity entity);
}
