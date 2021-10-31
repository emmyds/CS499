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

    public void mousePressed(MouseEvent e){
        //if(e.isPopupTrigger()){
            showPopUp(e);
        //}
    }
    public void mouseReleased(MouseEvent e){
        if(e.isPopupTrigger()){
            showPopUp(e);
        }
    }
    public void showPopUp(MouseEvent e){
        ClickPopUp popUp = new ClickPopUp(e.getComponent());
        popUp.show(e.getComponent(), e.getX(), e.getY());
    }
}
