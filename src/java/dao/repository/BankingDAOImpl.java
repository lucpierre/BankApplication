/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;


import dao.entity.BankingEntity;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Charles
 */

@Repository
public class BankingDAOImpl extends GenericDAOImpl<BankingEntity> implements BankingDAO {
    
    public BankingDAOImpl(){
        super(BankingEntity.class);
    }
    
}
