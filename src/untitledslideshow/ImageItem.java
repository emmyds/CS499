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
    private int transition = 0;
    private float transitionTime;
    
    public ImageItem(String path, int transition){
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

    public int getTransition() {
        return transition;
    }

    public void setTransition(int transition) {
        this.transition = transition;
    }
    
    public void setTransitionTime(float time){
        this.transitionTime = time;
    }
    public float getTransitionTime(){
        return this.transitionTime;
    }
}
