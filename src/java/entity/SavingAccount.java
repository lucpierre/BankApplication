/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author clepaire
 */
public class SavingAccount extends Account{

    public SavingAccount(ArrayList<User> owners, double credit, ArrayList<Movement> movements){
        super(owners, credit, movements);
    }
}
