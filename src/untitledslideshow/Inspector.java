/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;

/**
 *
 * @author Annaleise
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
        transitionFocus = false;
        imageFocus = true;
      
    };
    
    /**
     * Display the transition and transition controls in the inspector window.
     */
    public void displayTransition(){
        imageFocus = false;
        transitionFocus = true;
    }
   
    /**
     * Get the item that is currently being focused on in the inspector.
     * @return focused item
     */
    public Item getFocusItem(){
        if(imageFocus){
            return image;
        }
        else if(transitionFocus){
            return transition;
        }
        else{
            return null;
        }
    };
}
