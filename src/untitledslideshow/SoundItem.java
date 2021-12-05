/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 * SoundItem allows information about a sound file to be stored into a SoundItem
 * which holds its path, length, and name, and allows for the DefaultListModel
 * to be updated as SoundItems are created.
 * @author Roberto Murcia
 */
public class SoundItem extends JLabel{
    private final String soundPath;
    private final String soundName;
    private final double soundLength;
    private static final DefaultListModel tempModel = new DefaultListModel();
    public SoundItem(String path, String name, double length){
        this.soundPath = path;
        this.soundName = name;
        this.soundLength = length;
        this.setText(soundName);
        
    }
    /**
     * Returns the file path for the sound item
     * @return sound item file path
     */
    public String getPath(){
        return this.soundPath;
    }
    /**
     * returns the length of the sound
     * @return sound length
     */
    public double getSoundLength(){
        return this.soundLength;
    }
    /**
     * returns the name of the sound
     * @return sound name
     */
    public String getSoundName(){
        return this.soundName;
    }
    /**
     * Adds the created sound item to the SoundItem DLM, to then be transferred to the main GUI
     * @param item is the item to be added
     */
    public void addToDLM(SoundItem item){
        if(item.soundPath == null && item.soundName == null && item.soundLength == 0){}
        else if(tempModel.size() == 0){
            tempModel.add(0, item.soundName);
        }
        else{
            int endIndex = tempModel.size();
            tempModel.add(endIndex, item.soundName);
        }
    }
    /**
     * Acquire the DLM created in the SoundItem class
     * @return 
     */
    public DefaultListModel getDLM(){
        return tempModel;
    }
}
