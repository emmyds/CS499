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
public class Image implements Item{
    private String path;
    private int time;
    
    @Override
    public String getString() {
        return path;
    }

    
    /**
     * Get the time that the image should be displayed in the presentation
     * @return 
     */
    @Override
    public int getTime() {
        //return the user-set time interval here;
        return -1;
    }
    
}
