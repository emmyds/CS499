/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;

/**
 *
 * @author Annaleise
 */
public class Transition implements Item{
    
    private String name;
    private int time;
    
    @Override
    public String getString() {
        return name;
    }

    @Override
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
