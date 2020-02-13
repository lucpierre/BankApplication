/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author lucqu
 */
public class Movement {
    private final User FROM;
    private final User TO;
    private final Date DATE;
    private final double CREDIT;

    public Movement(User FROM, User TO, Date DATE, double CREDIT) {
        this.FROM = FROM;
        this.TO = TO;
        this.DATE = DATE;
        this.CREDIT = CREDIT;
    }
    
    //////////////
    // GETTERS //
    ////////////

    public User getFROM() {
        return FROM;
    }

    public User getTO() {
        return TO;
    }

    public Date getDATE() {
        return DATE;
    }

    public double getCREDIT() {
        return CREDIT;
    }
    
}
