package fixtures;

import dao.entity.SavingAccountEntity;
import dao.entity.CurrentAccountEntity;
import dao.entity.AccountEntity;
import java.util.ArrayList;

/**
 *
 * @author Charles
 */
public class AccountFixtures {
        
    ArrayList<AccountEntity> accounts;
    
    public AccountFixtures(){
        accounts = new ArrayList<>();
        
        accounts.add(new SavingAccountEntity()
        );
        
        accounts.add(
            new CurrentAccountEntity()
        );
    }
    
    public ArrayList<AccountEntity> getAccounts(){
        return this.accounts;
    }
}
