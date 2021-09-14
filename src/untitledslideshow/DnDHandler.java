/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Cursor;
import javax.swing.*;
/**
 *
 * @author Annaleise
 * @author Roberto Murcia
 * 
 */
public class DnDHandler {
    private Item dragItem;
    private Cursor userCursor;
    private int startX;
    private int startY;
    private int stopX;
    private int stopY;
    
    
    /**
     * Change cursor during drag to match Item type.
     */
    private void changeCursor(Item selectedItem)
    {
        /*JPanel panel = new JPanel();
        panel.getRootPane().setCursor(userCursor);
        */
    };
    
    /**
     * Set the start mouse x/y.
     * If their coordinates are within a reel, call removeByPosition on that reel, and set the dragItem to the return.
     * Else if their coordinates are within the inspector, use inspector.getFocusItem(), and set the dragItem to the return.
     * Else if their coordinates are within a palette, use positionToItem on appropriate palette, and set the dragItem to the return.
     * Change the cursor.
     */
    public void startDrag()
    {
        Point cursorStart = MouseInfo.getPointerInfo().getLocation();
        startX = cursorStart.x;
        startY = cursorStart.y;
        if(isReel(startX, startY) == true){
            dragItem = reel.removeByPosition(startX, startY);
        }
        else if(isInspector(startX, startY) == true){
            dragItem = Inspector.getFocusItem();
        }
        else if(isPalette(startX,startY) == true){
            dragItem = pallete.positionToItem(startX, startY);
            
        }
        changeCursor(dragItem);
                
    };
    
    
    /**
     * Once the mouse is released, check if stop x/y are within a reel. 
     *      If so, call the insertAtPosition() on the appropriate reel with the dragged Item.
     */
    public void stopDrop()
    {
        Point cursorStop = MouseInfo.getPointerInfo().getLocation();
        stopX = cursorStop.x;
        stopY = cursorStop.y;
        if(isReel(stopX,stopY)){
            Reel.insertAtPosition(dragItem,stopX,stopY)
        }
        
    };
    
    
    
    
    
}
