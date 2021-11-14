/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author Roberto Murcia
 */
public class SoundItem extends JLabel{
    private final String soundPath;
    private final String soundName;
    private final double soundLength;
    private static final DefaultListModel tempModel = new DefaultListModel();
    private final ArrayList <SoundItem> tempFiles = new ArrayList<>();
    private int modelSize = 0;
    private int index;
    public SoundItem(String path, String name, double length){
        this.index = 0;
        this.soundPath = path;
        this.soundName = name;
        this.soundLength = length;
        this.setText(soundName);
        
    }
    /**
     * 
     * @param i 
     */
    public void setIndex(int i){
        this.index = i;
    }
    /**
     * 
     * @return 
     */
    public int getIndex(){
        return this.index;
    }
    /**
     * 
     * @return 
     */
    public String getPath(){
        return this.soundPath;
    }
    /**
     * 
     * @return 
     */
    public double getSoundLength(){
        return this.soundLength;
    }
    /**
     * 
     * @return 
     */
    public String getSoundName(){
        return this.soundName;
    }
    /**
     * 
     * @param item 
     */
    public void addToDLM(SoundItem item){
        if(item.soundPath == null && item.soundName == null && item.soundLength == 0){}
        else{
            tempModel.add(modelSize, item.soundName);
            tempFiles.add(item);
            incrementCounter();
        }
        
    }
    /**
     * 
     * @return 
     */
    public DefaultListModel getDLM(){
        return tempModel;
    }
    /**
     * 
     */
    public void incrementCounter(){
        modelSize++;
    }
    public void decrementCounter(){
        modelSize--;
    }
    public ArrayList<SoundItem> getSoundFiles(){
        return tempFiles;
    }
}
