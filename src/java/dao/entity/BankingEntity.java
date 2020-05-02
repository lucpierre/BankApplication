/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Charles
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="BankingEntity")
@DiscriminatorColumn(name="accounttype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AccountEntity")

@NamedQueries({
    @NamedQuery(
        name = "find_by_number",
        query = "SELECT u FROM BankingEntity u WHERE u.banking_number = :banking_number"
    )
})

public class BankingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    

}