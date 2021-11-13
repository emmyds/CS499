/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untitledslideshow;
import javax.swing.ImageIcon;
/**
 *
 * @author Annaleise
 */
public class ImageItem {
    
    private String path;
    private String transition = "no transition";
    
    public ImageItem(String path, String transition){
        this.path = path;
        this.transition = transition;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }
   
}
