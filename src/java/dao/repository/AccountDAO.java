package dao.repository;

import dao.entity.AccountEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charles
 */
public interface AccountDAO extends GenericDAO<AccountEntity>{
    public AccountEntity findByNumber(String account_number);
}
