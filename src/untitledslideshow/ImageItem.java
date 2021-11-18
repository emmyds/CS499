/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untitledslideshow;
/**
 *
 * @author Annaleise
 */
public class ImageItem {
    
    private String path;
    private String transition = "no transition";
    private float transitionTime;
    
    public ImageItem(String path, String transition){
        this.transitionTime = 1;
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
    
    public void setTransitionTime(float time){
        this.transitionTime = time;
    }
    public float getTransitionTime(){
        return this.transitionTime;
    }
}
