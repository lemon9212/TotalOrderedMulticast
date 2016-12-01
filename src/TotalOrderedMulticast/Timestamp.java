/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;

/**
 *
 * @author Luca
 */
public class Timestamp {
    
    private int valore;

    public Timestamp(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void increaseValore() {
        valore ++;
    }
    
    
}
