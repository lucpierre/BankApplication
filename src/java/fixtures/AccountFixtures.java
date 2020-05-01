/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixtures;

import dao.entity.SavingAccountsEntity;
import dao.entity.CurrentAccountEntity;
import dao.entity.AccountEntity;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Charles
 */
public class AccountFixtures {
        
    ArrayList<AccountEntity> accounts;
    
    public AccountFixtures(){
        accounts = new ArrayList<>();
        
        accounts.add(
            new SavingAccountsEntity(
            )
        );
        
        accounts.add(
            new CurrentAccountEntity(
            )
        );
    }
    
public ArrayList<AccountEntity> getAccounts(){
        return this.accounts;
    }
}
