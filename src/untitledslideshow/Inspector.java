/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;

/**
 *
 * @author Annaleise
 * 
 * Controls behavior for inspector window
 */
public class Inspector {
    private Image image;
    private Transition transition;
    
    //state booleans to indicate what the inspector is displaying - if both are false, the inspector is empty.
    private boolean imageFocus; //true if currently displaying image
    private boolean transitionFocus; // true if currently displaying transition
    
    
    /**
     * Display the image full view in the inspector window.
     */
    public void displayImage()
    {
        setTransitionFocus(false);
        setImageFocus(true);
        
        
        
    };
    
    /**
     * Display the transition and transition controls in the inspector window.
     */
    public void displayTransition(){
        setImageFocus(false);
        setTransitionFocus(true);
        
        
    }
   
    
    
    //   GETTERS ---------------------------------------------------------------
    public Image getImage() {
        return image;
    }

    public Transition getTransition() {
        return transition;
    }

    public boolean isImageFocus() {
        return imageFocus;
    }

    public boolean isTransitionFocus() {
        return transitionFocus;
    }
    
    
    
    //   SETTERS ---------------------------------------------------------------
    public void setImage(Image image) {
        this.image = image;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public void setImageFocus(boolean imageFocus) {
        this.imageFocus = imageFocus;
    }

    public void setTransitionFocus(boolean transitionFocus) {
        this.transitionFocus = transitionFocus;
    }
}
