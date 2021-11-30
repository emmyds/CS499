package untitledslideshow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Annaleise
 */
public class Exporter{
    private boolean isManual;
    private float intervalTime = -1;
    private String saveDirectory = "";
    private String filename = "file name here";
    private ArrayList<ImageItem> images = new ArrayList<>();
    private ArrayList<SoundItem> sounds = new ArrayList<>();
    private float transitionTime = 1;

    public Exporter(){
    }

    public boolean isIsManual() {
        return isManual;
    }

    public void setIsManual(boolean isManual) {
        this.isManual = isManual;
    }

    public float getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(float intervalTime) {
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
    
    public ArrayList<SoundItem> getSounds(){
        return sounds;
    }

    public void setImages(ArrayList<ImageItem> images) {
        this.images = images;
    }
    
    public void setSounds(ArrayList<SoundItem> sounds) {
        this.sounds = sounds;
    }

    public String getFilename() {
        return filename + ".JSON";
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public float getTransitionTime() {
        return this.transitionTime;
    }
    
    public void setTransitionTime(float time) {
        this.transitionTime = time;
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
        /*boolean isSuccessful;
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
        }*/
         try (FileWriter writer = new FileWriter(saveFile)) {
            writer.write('{');
            writer.write(String.format("\n\"changeManually\": \"%b\",", this.isManual));
            writer.write(String.format("\n\"imageDuration:\": \"%f\"," , this.intervalTime));
            writer.write(String.format("\n\"imageDirectory\": \"%s\",", this.saveDirectory));
            
            //WRITE IMAGES
            writer.write("\n\"images\":[");
            for(ImageItem image : images){
                writer.write(String.format("\n\"%s\",", image.getPath()));
            }
            writer.write("\n],");
            
            //WRITE TRANSITIONS
            writer.write("\n\"transitions\":[");
            for(ImageItem image : images){
                writer.write(String.format("\n\"%s\",", image.getTransition()));
            }
            writer.write("\n],");
            
            writer.write("\n\"transitionLengths\":[");
            for(ImageItem image : images){
                writer.write(String.format("\n\"%f\",", image.getTransitionTime()));
            }
            writer.write("\n],");
            
            //WRITE SOUNDS
            writer.write("\n\"sounds\":[");
            for(SoundItem sound : sounds){
                writer.write(String.format("\n\"%s\",", sound.getPath()));
            }
            writer.write("\n]");
            
            writer.write("\n}");
            
        }
        catch(IOException e)
        {
              System.out.println("Exception during export: " + e);
        }
    }
}


