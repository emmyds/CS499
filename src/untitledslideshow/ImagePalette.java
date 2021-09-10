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
public class ImagePalette implements Palette{

    private Image[] images; 
    private String directoryPath;
    
    @Override
    public void addItem(Item item, int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item positionToItem(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Set the directory path to the user's choice and add the images in the directory to the image list;
     */
    public void selectDirectory(){
        
    }

    public Image[] getImages() {
        return images;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    private void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }
    
}
