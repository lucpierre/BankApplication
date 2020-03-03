/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Charles
 */

@Entity
@Table(name="SavingAccountsEntity")
@DiscriminatorValue("SavingAccountsEntity")
public class SavingAccountsEntity extends AccountEntity implements Serializable {
    
}
