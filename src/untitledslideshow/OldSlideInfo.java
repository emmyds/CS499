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
    private static ArrayList<ImageItem> oldImagesList = new ArrayList<>();
    private static ArrayList<SoundItem> oldSoundsList = new ArrayList<>();
    private static ArrayList<String> oldImageTransitions = new ArrayList<>();

    public ArrayList<ImageItem> getOldImagesList() {
        return oldImagesList;
    }

    public void setOldImagesList(ArrayList<ImageItem> oldImages) {
        oldImagesList = oldImages;
    }

    public ArrayList<SoundItem> getOldSoundsList() {
        return oldSoundsList;
    }

    public void setOldSoundsList(ArrayList<SoundItem> oldSounds) {
        oldSoundsList = oldSounds;
    }

    public ArrayList<String> getOldImageTransitions() {
        return oldImageTransitions;
    }

    public void setOldImageTransitions(ArrayList<String> oldTransitions) {
        oldImageTransitions = oldTransitions;
    }
    
    
}