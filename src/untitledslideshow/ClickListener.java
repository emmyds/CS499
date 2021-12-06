/*
 * This class has been created and developed by Team F (Slideshow Editor).
 */

package untitledslideshow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ClickListener allows for certain GUI components to register that they have been
 * clicked on, such as the image pallete, image reel, and soundtrack reel. This
 * allows those components to detect whether the mouse has been pressed on it, or
 * the mouse has been released on it.
 * @author Roberto Murcia
 */
public class ClickListener extends MouseAdapter{
    /**
     * If the mouse is clicked over a component
     * @param e is the component that the mouse was clicked over
     */
    @Override
    public void mousePressed(MouseEvent e){
        showPopUp(e);
    }

    /**
     * If the mouse is released over a component
     * @param e is the component that the mouse was released over
     */
    @Override
    public void mouseReleased(MouseEvent e){
        showPopUp(e);
    }
    /**
     * Create a popup over the component that was clicked over.
     * @param e is the component that was clicked over.
     */
    public void showPopUp(MouseEvent e){
        ClickPopUp popUp = new ClickPopUp(e.getComponent());
        popUp.show(e.getComponent(), e.getX(), e.getY());
    }
}
