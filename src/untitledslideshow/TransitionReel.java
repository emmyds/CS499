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
public class TransitionReel implements Reel{

    private Transition[] transitions;
    
    @Override
    public void displayReel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAtPosition(Item item, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Remove an item from the reel based on x/y mouse position.
     * @param x mouse pos
     * @param y mouse pos
     * @return the removed item
     */
    @Override
    public Item removeAtPosition(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item[] getReelItems() {
        return transitions;
    }
    
}
