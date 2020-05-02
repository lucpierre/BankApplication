package dao.repository;

import dao.entity.AccountEntity;

/**
 *
 * @author Charles
 */
public interface AccountDAO extends GenericDAO<AccountEntity>{
    public AccountEntity findByNumber(String account_number);
}
