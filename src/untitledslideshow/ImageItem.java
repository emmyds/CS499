/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untitledslideshow;
/**
 * ImageItem stores information about an image that is used in the editor.
 * This stores information such as its path, the transition being used, and the
 * transition's interval.
 * @author Annaleise
 * @author Roberto Murcia
 */
public class ImageItem {
    
    private String path;
    private int transition = 0;
    private float transitionTime;
    /**
     * Initializes an ImageItem object with its path and transition
     * @param path is the path of the image
     * @param transition is defaulted to no transition
     */
    public ImageItem(String path, int transition){
        this.transitionTime = 1;
        this.path = path;
        this.transition = transition;
    }
    /**
     * Returns the file path of the image
     * @return 
     */
    public String getPath() {
        return path;
    }
    /**
     * Sets the file path of the image
     * @param path 
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * Returns the transition set to this image
     * @return the transition being used
     */
    public int getTransition() {
        return transition;
    }
    /**
     * Sets the transition to be used for this image
     * @param transition the transition to be used
     */
    public void setTransition(int transition) {
        this.transition = transition;
    }
    /**
     * Sets the transition time for the transition on the ImageItem
     * @param time the transition time of the transition
     */
    public void setTransitionTime(float time){
        this.transitionTime = time;
    }
    /**
     * Returns the transition time for the transition on the ImageItem
     * @return the transition time
     */
    public float getTransitionTime(){
        return this.transitionTime;
    }
}
