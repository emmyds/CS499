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
 * Palette interface.
 */
public interface Palette {
    
    /**
     * Add an item to the list.
     * @param item item to insert into the ordered list
     * @param pos position to insert item
     */
    public void addItem(Item item, int pos);
    
    /**
     * Display the list of Items in the Palette.
     */
    public void displayItems();
    
    /**
     * Get item at mouse position.
     * @param x 
     * @param y
     * @return
     */
    public Item positionToItem(int x, int y);
}
