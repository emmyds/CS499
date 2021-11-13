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

/**
 * ClickPopUp creates a JPopupMenu whenever the user clicks on a component
 * that contains the ClickListener MouseListener. This is to allow the user to
 * remove/add specific images, transitions, and sounds to their respective reels.
 * 
 * @author Roberto Murcia
 **/
public class ClickPopUp extends JPopupMenu{
    /*
    Test Variables
    */
    //private JMenuItem isJList;
    //private JMenuItem isJLabel;
    
    
    /*
    Actual Variables
    */
    /**
     * Variable declarations for temporary GUI
     */
    private static MightyPointGui tempGui;
    private static final JList tempReelList = tempGui.imagesReel;
    private static final DefaultListModel tempModel = new DefaultListModel();
    //private static final JFrame tempFrame = new JFrame();
    //private static final JPanel tempPanel = new JPanel();
    /**
     * ClickPopUp creates a popup based on the component that was clicked over.
     * For example, if the component is the imagesList, it provides the options
     * to add images to parts of the image reel. If it is the imagesReel, it allows
     * the user to remove images/shift images in the reel.
     * @param c is the component that was clicked over
     */
    public ClickPopUp(Component c){
        this.tempGui = new MightyPointGui();
        Exporter exporter = MightyPointGui.exporter;
        tempReelList.setName("imagesReel");
        if(c instanceof JList && "imagesList".equals(c.getName())){
            //Copies the elements found in the componenent into tempList
            JList tempList = (JList) c;
            //Gets the index of the selected items
            int index = tempList.getSelectedIndex();
            DefaultListModel model = (DefaultListModel) tempList.getModel();
            //System.out.println("Parent Component Name: " + c.getComponentAt(c.getX(), c.getY()).getName());
            /**
             * Code that adds the selected image into the last index of the image reel
             * by creating a listener on the menu tab
             */
            this.add("Add to End of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                
                int endIndex = tempModel.size();
                tempModel.add(endIndex, temp);
                exporter.getImages().add(new ImageItem(temp.getDescription(), "no transition")); //push a new image item to the end of the list
                //tempGui.imagesReel.setModel(tempModel);
                tempReelList.setModel(tempModel);
                System.out.println("Size of temp model is: " + tempGui.imagesReel.getModel().getSize());
                for (ImageItem i : exporter.getImages()){
                    System.out.println("Image: " + i.getPath() + " trans: " + i.getTransition());
                }

            });
            /**
             * Code that adds the selected image to the beginning of the image reel
             */
            this.add("Add to Start of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                tempModel.add(0, temp);
                exporter.getImages().add(0, new ImageItem(temp.getDescription(), "no transition"));
                tempGui.imagesReel.setModel(tempModel);
                tempReelList.setModel(tempModel);
                //System.out.println("Added to Start of Reel: " + tempGui.imagesReel.getModel().getElementAt(0).toString());
                //System.out.println("Image at end of reel: " + 
                //        tempGui.imagesReel.getModel().getElementAt(
                //        tempGui.imagesReel.getModel().getSize()).toString());
                System.out.println("Size of temp model is: " + tempGui.imagesReel.getModel().getSize());
                for (ImageItem i : exporter.getImages()){
                    System.out.println("Image: " + i.getPath() + " trans: " + i.getTransition());
                }
            });            
            /*
            Testing and debug code
            */
            System.out.println(model.getElementAt(index).toString());
            System.out.println("Index selected in image list is: " + index);
            System.out.println("Main Component is: " + c.getName());
            
        }
        else if(c instanceof JList && "imagesReel".equals(c.getName())){
            JList tempList = (JList) c;
            int index = tempList.getSelectedIndex();
            //DefaultListModel tempModel = (DefaultListModel) tempListModel;
            this.add("Remove from Reel:").addActionListener(e->{
                if(tempModel.getSize() == 0){
                    System.out.println("No Elements in Reel.");
                }
                else{
                    tempModel.remove(index);
                }

            });
            this.add("Shift Left").addActionListener(e->{
                if(index-1 >= 0){
                    var temp1 = tempModel.getElementAt(index);
                    var temp2 = tempModel.getElementAt(index - 1);
                    tempModel.setElementAt(temp1, index-1);
                    tempModel.setElementAt(temp2, index);
                    Collections.swap(exporter.getImages(), index, index-1);
                }
                else if(tempModel.getSize() == 0){
                    System.out.println("No Elements in Reel to shift.");
                }
                else{
                    System.out.println("Image is already at the beginning of the reel.");
                }
            });
            this.add("Shift Right").addActionListener(e->{
                try{
                    if(index >= tempModel.getSize()){
                    }
                    else if(tempModel.getSize() == 0){
                    System.out.println("No Elements in Reel to shift.");
                    }
                    else{
                        var temp1 = tempModel.getElementAt(index);
                        var temp2 = tempModel.getElementAt(index + 1);
                        tempModel.setElementAt(temp1, index+1);
                        tempModel.setElementAt(temp2, index);
                        Collections.swap(exporter.getImages(), index+1, index);
                    }
                }catch(ArrayIndexOutOfBoundsException error){
                    System.out.println("Image is already at the end of the reel.");
                }
                
            });
            this.addSeparator();
           
           this.add("Wipe Left").addActionListener(e -> {
              String trans = "WL";
              var image = tempModel.getElementAt(index);
              exporter.getImages().get(index).setTransition(trans);
                System.out.println(image);
                System.out.println(index);
              System.out.println("Wipe Left added to current image ");
           });
           
           
            this.add("Wipe Right").addActionListener(e -> {
                String trans = "WR";
                var image = tempModel.getElementAt(index);
                exporter.getImages().get(index).setTransition(trans);
                System.out.println(image);
                System.out.println(index);
               System.out.println("Wipe Right added to current image ");
           });
            
            
            this.add("Wipe Up").addActionListener(e -> {
                String trans = "WU";
                var image = tempModel.getElementAt(index);
                exporter.getImages().get(index).setTransition(trans);
                System.out.println(image);
                System.out.println(index);
               System.out.println("Wipe Up added to current image ");
           });
            
            
            this.add("Wipe Down").addActionListener(e -> {
                String trans = "WD";
                var image = tempModel.getElementAt(index);
                exporter.getImages().get(index).setTransition(trans);
                System.out.println(image);
                System.out.println(index);
               System.out.println("Wipe Down added to current image ");
           });
            
            
            this.add("Crossfade").addActionListener(e -> {
                String trans = "CF";
                var image = tempModel.getElementAt(index);
                exporter.getImages().get(index).setTransition(trans);
                System.out.println(image);
                System.out.println(index);
               System.out.println("Crossfade added to current image ");
           });
            
        }
        else if("soundsList".equals(c.getName())){
            /*
            this.addToSoundReel = new JMenuItem("Add to End of Reel");
            this.shiftLeft = new JMenuItem("Move sound one spot to the left");
            this.shiftRight = new JMenuItem("Move sound one spot to the right");
            this.add(addToSoundReel); this.add(shiftLeft); this.add(shiftRight);
            */
        }
        else{
        }  
    }
    /**
     * For the live/video presentation, must integrate into actual main gui
     * 
     */
    /*private void createTempReel(){
        tempFrame.add(tempPanel);
        tempFrame.setSize(1000, 300);
        tempFrame.setResizable(true);
        tempFrame.setLocation(500, 500);
        tempFrame.setLayout(new FlowLayout());
        tempPanel.setLayout(new FlowLayout());
        JScrollPane tempScroll = new JScrollPane(tempReelList);
        //tempPanel.add(new JScrollPane(tempReelList));
        tempReelList.setDragEnabled(false);
        tempReelList.setSize(500,250);
        tempScroll.setSize(500, 250);
        tempPanel.add(tempScroll);
        tempPanel.setSize(500,300);
        tempFrame.setAlwaysOnTop(true);
        tempFrame.setVisible(true);
    }*/
    /**
     * Updates the primary GUI in real-time to any modifications to the reel
     * @return the reel created in the popUp class
     */
    public DefaultListModel getDLM(){
        DefaultListModel temp = tempModel;
        return temp;
    }
    
}
