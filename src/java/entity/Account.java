/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author lucqu
 */
public class Account {
    private ArrayList<User> owners;
    private double credit;
    private ArrayList<Movement> movements;

    public Account(ArrayList<User> owners, double credit, ArrayList<Movement> movements) {
        this.owners = owners;
        this.credit = credit;
        this.movements = movements;
    }

    //////////////
    // GETTERS //
    ////////////
    
    public ArrayList<User> getOwners() {
        return owners;
    }

    public double getCredit() {
        return credit;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }
    
    //////////////
    // SETTERS //
    ////////////
    
    public void setOwners(ArrayList<User> owners) {
        this.owners = owners;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }
    
}
