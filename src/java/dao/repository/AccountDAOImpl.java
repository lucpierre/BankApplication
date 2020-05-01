/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.repository;

import dao.entity.AccountEntity;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Charles
 */

@Repository
public class AccountDAOImpl extends GenericDAOImpl<AccountEntity> implements AccountDAO {
    
    public AccountDAOImpl(){
        super(AccountEntity.class);
    }
    
    @Transactional
    @Override
    public AccountEntity findByNumber(String account_number) {
        Query query = this.getEm().createNamedQuery("find_by_number");
        
        query.setParameter("account_number", account_number);
        try {
            return (AccountEntity)query.getSingleResult();
        } catch (NoResultException e) {
            return null;        //Lever une exception 
        }
    }
}

