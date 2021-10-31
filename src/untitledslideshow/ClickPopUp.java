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

/**
 * ClickPopUp creates a JPopupMenu whenever the user clicks on a component
 * that contains the ClickListener MouseListener. This is to allow the user to
 * remove/add specific images, transitions, and sounds to their respective reels.
 * 
 * @author Roberto Murcia
 */


public class ClickPopUp extends JPopupMenu{
    /*
    Test Variables
    */
    //private JMenuItem isJList;
    //private JMenuItem isJLabel;
    
    
    /*
    Actual Variables
    */
    private static final MightyPointGui tempGui = new MightyPointGui();
    private static final DefaultListModel tempModel = new DefaultListModel();
    public ClickPopUp(Component c){
        if(c instanceof JList && "imagesList".equals(c.getName())){
            //Copies the elements found in the componenent into tempList
            JList tempList = (JList) c;
            int index = tempList.getSelectedIndex();
            DefaultListModel model = (DefaultListModel) tempList.getModel();
            System.out.println("Parent Component Name: " + c.getComponentAt(c.getX(), c.getY()).getName());
            /**
             * Code that adds the selected image into the last index of the image reel
             */
            this.add("Add to End of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                int endIndex = tempModel.size();
                tempModel.add(endIndex, temp);
                tempGui.imagesReel.setModel(tempModel);
                System.out.println("Size of temp model is: " + tempGui.imagesReel.getModel().getSize());
                //System.out.println("Added to End of Reel: " + tempGui.imagesReel.getModel().getElementAt(endIndex).toString());
                if(tempGui.imagesReel.getModel().getSize() > 0){
                    tempGui.setVisible(true);
                }
            });
            /**
             * Code that adds the selected image to the beginning of the image reel
             */
            this.add("Add to Start of Reel").addActionListener(e->{
                ImageIcon temp = (ImageIcon) model.getElementAt(index);
                tempModel.add(0, temp);
                tempGui.imagesReel.setModel(tempModel);
                //System.out.println("Added to Start of Reel: " + tempGui.imagesReel.getModel().getElementAt(0).toString());
                //System.out.println("Image at end of reel: " + 
                //        tempGui.imagesReel.getModel().getElementAt(
                //        tempGui.imagesReel.getModel().getSize()).toString());
                System.out.println("Size of temp model is: " + tempGui.imagesReel.getModel().getSize());
                if(tempGui.imagesReel.getModel().getSize() > 0){
                    tempGui.setVisible(true);
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
                tempModel.remove(index);
                tempList.setModel(tempModel);
            });
            this.add("Shift Left").addActionListener(e->{
                if(index-1 >= 0){
                    var temp1 = tempModel.getElementAt(index);
                    var temp2 = tempModel.getElementAt(index - 1);
                    tempModel.setElementAt(temp1, index-1);
                    tempModel.setElementAt(temp2, index);
                }
                else{
                    System.out.println("Image is already at the beginning of the reel.");
                }
            });
            this.add("Shift Right").addActionListener(e->{
                try{
                    if(index >= tempModel.getSize()){}
                    else{
                        var temp1 = tempModel.getElementAt(index);
                        var temp2 = tempModel.getElementAt(index + 1);
                        tempModel.setElementAt(temp1, index+1);
                        tempModel.setElementAt(temp2, index);
                    }
                }catch(ArrayIndexOutOfBoundsException error){
                    System.out.println("Image is already at the end of the reel.");
                }
                
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
    
    
}
