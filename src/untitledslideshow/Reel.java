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
 * Reel interface enforces support for:
 *  - 
 *  - 
 */
public interface Reel {
    
    /**
     * displaying all Items in the Reel
     */
    public void displayReel();
    
    /**
     * inserting an Item into the Reel
     * @param item Item to insert
     * @param x mouse position x
     * @param y mouse position y
     */
    public void insertAtPosition(Item item, int x, int y);
    
    /**
     * Removes item displayed at mouse position from the Reel
     * @param x mouse position x
     * @param y mouse position y
     */
    public void removeAtPosition(int x, int y);
    
}
