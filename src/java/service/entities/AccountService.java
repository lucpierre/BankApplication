/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.entities;

import dao.entity.AccountEntity;
import exceptions.CreateAccountException;
import java.util.List;

/**
 *
 * @author Charles
 */
public interface AccountService {
    public AccountEntity find(String id);
    public AccountEntity findByNumber(String account_number);
    public List<AccountEntity> findAll();
    public void save(AccountEntity entity);
    public void update(AccountEntity entity);
    public void delete(AccountEntity entity);
    public void openNewAccount(String client_id, String account_type, String balance) throws CreateAccountException;
}
