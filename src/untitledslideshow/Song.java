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
public class Song implements Item{

    private String path;
    private int length;
    
    @Override
    public String getString() {
        return path;
    }

    @Override
    public int getTime() {
        return length;
    }
    
}
