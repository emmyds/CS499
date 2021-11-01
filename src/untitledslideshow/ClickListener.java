/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Roberto Murcia
 */
public class ClickListener extends MouseAdapter{
    /**
     * If the mouse is clicked over a component
     * @param e is the component that the mouse was clicked over
     */
    @Override
    public void mousePressed(MouseEvent e){
        //if(e.isPopupTrigger()){
            showPopUp(e);
       //}
    }

    /**
     * If the mouse is released over a component
     * @param e is the component that the mouse was released over
     */
    @Override
    public void mouseReleased(MouseEvent e){
        //if(e.isPopupTrigger()){
            showPopUp(e);
        //}
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
