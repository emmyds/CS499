/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untitledslideshow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Annaleise
 */
public class Exporter {
    private boolean isManual = true;
    private int intervalTime = -1;
    private String saveDirectory = "";
    private String filename = "file name here";
    private ArrayList<ImageItem> images = new ArrayList<>();

    public Exporter() {
    }

    public boolean isIsManual() {
        return isManual;
    }

    public void setIsManual(boolean isManual) {
        this.isManual = isManual;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public ArrayList<ImageItem> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageItem> images) {
        this.images = images;
    }

    public String getFilename() {
        return filename + ".JSON";
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    
    public void export(){
        try
        {
            boolean isSuccessful = new File("slideshows").mkdir();                          //Attempts to create a folder named slideshows in the root project folder
            if(isSuccessful)
            {
                
                System.out.println("\nDirectory for slides successfully created.");
            }
            else
            {
                System.out.println("\nDirectory already created.");
            }
        }
        catch(SecurityException e)
        {
        }
        
        File saveFile = new File("slideshows/" + this.getFilename());
        boolean isSuccessful;
        try
        {
            isSuccessful = saveFile.createNewFile();
            if(isSuccessful)
            {
                System.out.println("\nFile created at " + saveFile.getCanonicalPath());
            }
            else
            {
                System.out.println("\nFile already exists at location: " + saveFile.getCanonicalPath());
            }
        }
        catch(IOException e)
        {
        }
        try (FileWriter writer = new FileWriter("slideshows/" + filename)) {
            writer.write("This is a test, Hello World!");
            writer.write("\nThe name of this file is " + filename);
            writer.write("\nInterval Time: " + this.intervalTime);
        }
        catch(IOException e)
        {
              System.out.println("Exception durring export: " + e);
        }
    }
}


