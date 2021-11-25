/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;

import java.util.ArrayList;

/**
 * OldSlideInfo will store the information from a previous slide, such as the
 * images added to a slideshow, the sounds added to the slideshow, as well as
 * the directory of images used in the slideshow.
 * 
 * @author Roberto Murcia
 */
public class OldSlideInfo {
    private static String oldImageDirectory;
    private static ArrayList<String> oldImagesList = new ArrayList<>();
    private static ArrayList<String> oldSoundsList = new ArrayList<>();
    private static ArrayList<String> oldImageTransitions = new ArrayList<>();
    private static ArrayList<Float> oldImageTransLengths = new ArrayList<>();
    private static ArrayList<DisplayImage> oldThumbnails = new ArrayList<>();   
    private static boolean isManual;
    private static float imageDuration;

    public static ArrayList<DisplayImage> getOldThumbnails() {
        return oldThumbnails;
    }

    public void setOldThumbnails(ArrayList<DisplayImage> thumbnails) {
        oldThumbnails = thumbnails;
    }
    
    
    public static String getDirectory(){
        return oldImageDirectory;
    }
    
    public void setDirectory(String directory){
        oldImageDirectory = directory;
    }
    
    public static ArrayList<String> getOldImagesList() {
        return oldImagesList;
    }

    public void setOldImagesList(ArrayList<String> oldImages) {
        oldImagesList = oldImages;
    }

    public static ArrayList<String> getOldSoundsList() {
        return oldSoundsList;
    }

    public void setOldSoundsList(ArrayList<String> oldSounds) {
        oldSoundsList = oldSounds;
    }

    public static ArrayList<String> getOldImageTransitions() {
        return oldImageTransitions;
    }

    public void setOldImageTransitions(ArrayList<String> oldTransitions) {
        oldImageTransitions = oldTransitions;
    }
    
    public void setOldImageTransLengths(ArrayList<Float> oldImageLengths) {
        oldImageTransLengths = oldImageLengths;
    }
    
    public static ArrayList<Float> getOldImageTransLengths(){
        return oldImageTransLengths;
    }
    
    public void setManual(){
        isManual = true;
    }
    
    public void isInterval(){
        isManual = false;
    }
    
    public boolean getIsManual(){
        return isManual;
    }
    
    public void setImageDuration(float duration){
        imageDuration = duration; 
    }
    
    public float getImageDuration(){
        return imageDuration;
    }
    
}