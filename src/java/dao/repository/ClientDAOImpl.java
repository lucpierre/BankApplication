package dao.repository;

import dao.entity.ClientEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucqu
 */
@Repository
public class ClientDAOImpl extends GenericDAOImpl<ClientEntity> implements ClientDAO {
    
    public ClientDAOImpl(){
        super(ClientEntity.class);
    }
}
