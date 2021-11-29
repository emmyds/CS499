/*
Packages
*/
package untitledslideshow;
/*
Importations
*/
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ClickPopUp creates a JPopupMenu whenever the user clicks on a component
 * that contains the ClickListener MouseListener. This is to allow the user to
 * remove/add specific images, transitions, and sounds to their respective reels.
 * 
 * @author Roberto Murcia
 **/
public class ClickPopUp extends JPopupMenu{
  
    /*
    Actual Variables
    */

    private static final DefaultListModel imageTempModel = new DefaultListModel();
    private static DefaultListModel soundTempModel = new DefaultListModel();
    private float transitionTime = 1;
    Exporter exporter = MightyPointGui.exporter;
    /**
     * ClickPopUp creates a popup based on the component that was clicked over.
     * For example, if the component is the imagesList, it provides the options
     * to add images to parts of the image reel. If it is the imagesReel, it allows
     * the user to remove images/shift images in the reel.
     * @param c is the component that was clicked over
     */
    public ClickPopUp(Component c){
        SoundItem updateItem = new SoundItem(null, null, 0);
        
        if(c instanceof JList && "imagesList".equals(c.getName())){
            //Copies the elements found in the componenent into tempList
            JList tempList = (JList) c;
            //Gets the index of the selected items
            int index = tempList.getSelectedIndex();
            DefaultListModel model = (DefaultListModel) tempList.getModel();
            /**
             * Code that adds the selected image into the last index of the image reel
             * by creating a listener on the menu tab
             */
            this.add("Add to End of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                int endIndex = imageTempModel.size();
                imageTempModel.add(endIndex, temp);
                exporter.getImages().add(new ImageItem(temp.getDescription(), "no transition")); //push a new image item to the end of the list
                for (ImageItem i : exporter.getImages()){
                    System.out.println("Image: " + i.getPath() + " trans: " + i.getTransition());
                }
            });
            /**
             * Code that adds the selected image to the beginning of the image reel
             */
            this.add("Add to Start of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                imageTempModel.add(0, temp);
                exporter.getImages().add(0, new ImageItem(temp.getDescription(), "no transition"));
                for (ImageItem i : exporter.getImages()){
                    System.out.println("Image: " + i.getPath() + " trans: " + i.getTransition());
                }
            });            
            /*
            Testing and debug code
            System.out.println(model.getElementAt(index).toString());
            System.out.println("Index selected in image list is: " + index);
            System.out.println("Main Component is: " + c.getName());
            */  
        }
        else if(c instanceof JList && "imagesReel".equals(c.getName())){
            JList tempList = (JList) c;
            int index = tempList.getSelectedIndex();
            this.add("Remove from Reel:").addActionListener(e->{
                if(imageTempModel.getSize() == 0){
                    System.out.println("No Elements in Reel.");
                }
                else{
                    imageTempModel.remove(index);
                    exporter.getImages().remove(index);
                }

            });
            this.add("Shift Left").addActionListener(e->{
                if(index-1 >= 0){
                    var temp1 = imageTempModel.getElementAt(index);
                    var temp2 = imageTempModel.getElementAt(index - 1);
                    imageTempModel.setElementAt(temp1, index-1);
                    imageTempModel.setElementAt(temp2, index);
                    Collections.swap(exporter.getImages(), index, index-1);
                }
                else if(imageTempModel.getSize() == 0){
                    System.out.println("No Elements in Reel to shift.");
                }
                else{
                    System.out.println("Image is already at the beginning of the reel.");
                }
            });
            this.add("Shift Right").addActionListener(e->{
                try{
                    if(index >= imageTempModel.getSize()){
                    }
                    else if(imageTempModel.getSize() == 0){
                    System.out.println("No Elements in Reel to shift.");
                    }
                    else{
                        var temp1 = imageTempModel.getElementAt(index);
                        var temp2 = imageTempModel.getElementAt(index + 1);
                        imageTempModel.setElementAt(temp1, index+1);
                        imageTempModel.setElementAt(temp2, index);
                        Collections.swap(exporter.getImages(), index+1, index);
                    }
                }catch(ArrayIndexOutOfBoundsException error){
                    System.out.println("Image is already at the end of the reel.");
                }
                
            });
            this.addSeparator();
           
           this.add("Wipe Left (WL)").addActionListener(e -> {
              String trans = "WL";
              exporter.getImages().get(index).setTransition(trans);
              transitionTime = exporter.getTransitionTime();
              exporter.getImages().get(index).setTransitionTime(transitionTime);
              System.out.println(index);
              System.out.println(transitionTime);
              System.out.println("Wipe Left added to current image ");
           });
           
           
            this.add("Wipe Right (WR)").addActionListener(e -> {
                String trans = "WR";
                exporter.getImages().get(index).setTransition(trans);
                transitionTime = exporter.getTransitionTime();
                exporter.getImages().get(index).setTransitionTime(transitionTime);
                System.out.println(index);
                System.out.println(transitionTime);
                System.out.println("Wipe Right added to current image ");
           });
            
            
            this.add("Wipe Up (WU)").addActionListener(e -> {
                String trans = "WU";
                exporter.getImages().get(index).setTransition(trans);
                transitionTime = exporter.getTransitionTime();
                exporter.getImages().get(index).setTransitionTime(transitionTime);
                System.out.println(index);
                System.out.println(transitionTime);
                System.out.println("Wipe Up added to current image ");
           });
            
            
            this.add("Wipe Down (WD)").addActionListener(e -> {
                String trans = "WD";
                exporter.getImages().get(index).setTransition(trans);
                transitionTime = exporter.getTransitionTime();
                exporter.getImages().get(index).setTransitionTime(transitionTime);
                System.out.println(index);
                System.out.println(transitionTime);
                System.out.println("Wipe Down added to current image ");
           });
            
            
            this.add("Crossfade (CF)").addActionListener(e -> {
                String trans = "CF";
                exporter.getImages().get(index).setTransition(trans);
                transitionTime = exporter.getTransitionTime();
                exporter.getImages().get(index).setTransitionTime(transitionTime);
                System.out.println(index);
                System.out.println(transitionTime);
                System.out.println("Crossfade added to current image ");
           });
            this.add("Change Transition Time to: " + Float.toString(exporter.getTransitionTime())).addActionListener(e ->{
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                if(exporter.getImages().get(index).getTransitionTime() != exporter.getTransitionTime()){
                    JOptionPane.showMessageDialog(jf, "Image at position " + index + " transition time changed from " + 
                            Float.toString(exporter.getImages().get(index).getTransitionTime()) +
                            " to: " + Float.toString(exporter.getTransitionTime()));
                }
                exporter.getImages().get(index).setTransitionTime(exporter.getTransitionTime());
                System.out.println("Object at index: " + index + " set to: " + Float.toString(exporter.getTransitionTime()));
            });
            this.addSeparator();
            
            if(imageTempModel.getSize() > 0){
                this.add("Current Image Transition set to: " + exporter.getImages().get(index).getTransition());
                this.add("Current Transition time set to: " + Float.toString(exporter.getImages().get(index).getTransitionTime()));
            }
        }
        else if(c instanceof JList && "soundsReel".equals(c.getName())){
            JList tempList = (JList) c;
            soundTempModel = updateItem.getDLM();
            int index = tempList.getSelectedIndex();
            this.add("Remove from Reel").addActionListener(e -> {
                if(soundTempModel.getSize() == 0){
                    System.out.println("No sounds in reel to remove");
                }
                else{
                    soundTempModel.remove(index);
                    exporter.getSounds().remove(index);
                }
            });
            this.add("Shift Left").addActionListener(e -> {
                if(soundTempModel.getSize() == 0){
                    System.out.println("No sounds to shift in reel.");
                }
                else if(index == 0){
                    System.out.println("Sound cannot be shifted left");
                }
                else{
                    var temp1 = soundTempModel.get(index);
                    var temp2 = soundTempModel.get(index - 1);
                    soundTempModel.setElementAt(temp2, index);
                    soundTempModel.setElementAt(temp1, index - 1);
                    Collections.swap(exporter.getSounds(), index, index - 1);
                    for (SoundItem i : exporter.getSounds()){
                    System.out.println("Sound: " + i.getPath());
                    }
                }
            });
            this.add("Shift Right").addActionListener(e -> {
                try{
                    if(soundTempModel.getSize() == 0){
                    System.out.println("No sounds to shift in reel.");
                    }
                else if(index >= soundTempModel.getSize()){
                    System.out.println("Sound cannot be shifted right");
                    }
                else{
                    
                    var temp1 = soundTempModel.get(index);
                    var temp2 = soundTempModel.get(index + 1);
                    soundTempModel.setElementAt(temp2, index);
                    soundTempModel.setElementAt(temp1, index + 1);
                    Collections.swap(exporter.getSounds(), index, index + 1);
                    for (SoundItem i : exporter.getSounds()){
                    System.out.println("Sound: " + i.getPath());
                    }
                    }
                }catch(ArrayIndexOutOfBoundsException error){}
                
            });
        }
    }

    /**
     * Updates the primary GUI in real-time to any modifications to the reel
     * @return the reel created in the popUp class
     */
    public DefaultListModel getDLM(){
        DefaultListModel temp = imageTempModel;
        return temp;
    }
    
    public void UpdateDLMs(){
        ArrayList<DisplayImage> imageList = OldSlideInfo.getOldThumbnails();
        int i = 0;
        for(DisplayImage image : imageList){
            imageTempModel.add(i, image.getImage());
            exporter.getImages().add(i, new ImageItem(OldSlideInfo.getOldImagesList().get(i), OldSlideInfo.getOldImageTransitions().get(i)));
            exporter.getImages().get(i).setTransitionTime(OldSlideInfo.getOldImageTransLengths().get(i));
            i++;
        }
    }
    
}
