/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;

/**
 *
 * @author Annaleise
 */
public class DnDHandler {
    private Item dragItem;
    private int startX;
    private int startY;
    private int stopX;
    private int stopY;
    
    
    /**
     * Change cursor during drag to match Item type.
     */
    private void changeCursor()
    {
        
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
        
    };
    
    
    /**
     * Once the mouse is released, check if stop x/y are within a reel. 
     *      If so, call the insertAtPosition() on the appropriate reel with the dragged Item.
     */
    public void stopDrop()
    {
        
    };
    
    
    
    
    
}
