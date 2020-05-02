package service.entities;
import dao.entity.ClientEntity;
import exceptions.LoginAlreadyUsedException;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface ClientService {
    public ClientEntity find(String id);
    public List<ClientEntity> findAll();
    public void save(ClientEntity u) throws LoginAlreadyUsedException;
    public void update(ClientEntity entity);
    public void delete(ClientEntity entity);
}
