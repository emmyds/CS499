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
    private static ArrayList<Integer> oldImageTransitions = new ArrayList<>();
    private static ArrayList<Float> oldImageTransLengths = new ArrayList<>();
    private static ArrayList<DisplayImage> oldThumbnails = new ArrayList<>();   
    private static boolean isManual;
    private static float imageDuration;
    private static String comments;
    
    /**
     * Returns the thumbnails of the images stored in the save file
     * @return 
     */
    public static ArrayList<DisplayImage> getOldThumbnails() {
        return oldThumbnails;
    }
    /**
     * Sets the thumbnail images of the previous slideshow
     * @param thumbnails 
     */
    public void setOldThumbnails(ArrayList<DisplayImage> thumbnails) {
        oldThumbnails = thumbnails;
    }
    /**
     * Returns the image directory used by the previous slideshow
     * @return directory
     */
    public static String getDirectory(){
        return oldImageDirectory;
    }
    /**
     * Sets the image directory of the previous slideshow
     * @param directory 
     */
    public void setDirectory(String directory){
        oldImageDirectory = directory;
    }
    /**
     * Returns the list of images used in the image reel of the previous slideshow
     * in the order they were placed in.
     * @return 
     */
    public static ArrayList<String> getOldImagesList() {
        return oldImagesList;
    }
    /**
     * Sets the list of images used in the image reel of the previous slideshow
     * @param oldImages 
     */
    public void setOldImagesList(ArrayList<String> oldImages) {
        oldImagesList = oldImages;
    }
    /**
     * Returns the list of sound files used in the soundtrack reel of the previous
     * slideshow in the order they were placed in.
     * @return 
     */
    public static ArrayList<String> getOldSoundsList() {
        return oldSoundsList;
    }
    /**
     * Sets the list of sound files used in the soundtrack reel of the previous
     * slideshow
     * @param oldSounds 
     */
    public void setOldSoundsList(ArrayList<String> oldSounds) {
        oldSoundsList = oldSounds;
    }
    /**
     * Returns the set of integers that represent the transitions of the images
     * of the previous slideshow
     * @return 
     */
    public static ArrayList<Integer> getOldImageTransitions() {
        return oldImageTransitions;
    }
    /**
     * Sets the integers that represent the transitions of the images of the
     * previous slideshow
     * @param oldTransitions 
     */
    public void setOldImageTransitions(ArrayList<Integer> oldTransitions) {
        oldImageTransitions = oldTransitions;
    }
    /**
     * Sets the list of float values that represent the lengths of the transitions of the
     * images in the previous slideshow
     * @param oldImageLengths 
     */
    public void setOldImageTransLengths(ArrayList<Float> oldImageLengths) {
        oldImageTransLengths = oldImageLengths;
    }
    /**
     * Returns the list of float values that represent the lengths of the transitions of 
     * the images in the previous slideshow
     * @return 
     */
    public static ArrayList<Float> getOldImageTransLengths(){
        return oldImageTransLengths;
    }
    /**
     * Sets isManual to true
     */
    public static void setManual(){
        isManual = true;
    }
    /**
     * Sets isManual to false
     */
    public static void isInterval(){
        isManual = false;
    }
    /**
     * Returns whether or not the previous slideshow was manual or interval
     * @return true or false
     */
    public static boolean getIsManual(){
        return isManual;
    }
    /**
     * Sets the interval between images changing in the previous slideshow
     * @param duration
     */
    public static void setImageDuration(float duration){
        imageDuration = duration; 
    }
    /**
     * Returns the interval between images changing in the previous slideshow
     * @return 
     */
    public static float getImageDuration(){
        return imageDuration;
    }
    /**
     * Returns comments
     * @return 
     */
    public static String getComments() {
        return comments;
    }
    
}