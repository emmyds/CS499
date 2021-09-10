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
public class Slideshow {

   
    private Item[] images;
    private Item[] songs;
    private Item[] transitions;
    private int delay; //-1 if manual delay, 1-10 if user input
    private String folderPath; // path location for export file save
    private String exportName; // name for export file
    
    /**
     * Export slideshow data to file.
     */
    public void export()
    {
        
    };
    
    /**
     * Check export name entered by user.
     * @return true if export name is valid 
     */
    private boolean validExportName()
    {
        return false;
    };
    
    
    // GETTERS --------------------------------------
    
    public Item[] getImages() {
        return images;
    }

    public Item[] getSongs() {
        return songs;
    }

    public Item[] getTransitions() {
        return transitions;
    }

    public int getDelay() {
        return delay;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public String getExportName() {
        return exportName;
    }

    
    // SETTERS --------------------------------------
    
    public void setImages(Item[] images) {
        this.images = images;
    }

    public void setSongs(Item[] songs) {
        this.songs = songs;
    }

    public void setTransitions(Item[] transitions) {
        this.transitions = transitions;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public void setExportName(String exportName) {
        this.exportName = exportName;
    }
    
}
