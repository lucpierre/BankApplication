package service.entities;
import dao.entity.AdvisorEntity;
import java.util.List;

/**
 *
 * @author lucqu
 */
public interface AdvisorService {
    public AdvisorEntity find(String id);
    public List<AdvisorEntity> findAll();
    public void save(AdvisorEntity u);
    public void update(AdvisorEntity entity);
    public void delete(AdvisorEntity entity);
}
