/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author Roberto Murcia
 */
public class ImageReel extends JList{
    private DefaultListModel imageModel;
    private int modelSize;

    public ImageReel() {
        super(new DefaultListModel());
        this.imageModel = (DefaultListModel) getModel();
        setFixedCellHeight(150);
        setFixedCellWidth(150);
        setAutoscrolls(true);
        setVisibleRowCount(1);
        setLayoutOrientation(HORIZONTAL_WRAP);
        //this.addMouseListener(new ClickListener(this));
        setSize(500, 1000);
        this.setName("imagesReel");
        modelSize = imageModel.size();
        
    }
    public void addImage2Reel(ImageIcon image, int index){
        this.imageModel.add(index, image);
        this.modelSize++;
        updateReelModel(this.imageModel);
        
    }
    public void removeImageFromReel(int index){
        this.imageModel.remove(index);
        this.modelSize--;
        updateReelModel(this.imageModel);
    }
    public void shiftLeft(int index){
        if(index - 1 < 0){
            System.out.println("Cannot shift left, out of index");
        }
        else{
            var tempElement = this.imageModel.getElementAt(index);
            var tempElement2 = this.imageModel.getElementAt(index-1);
            this.imageModel.setElementAt(tempElement, index-1);
            this.imageModel.setElementAt(tempElement2, index);
            updateReelModel(this.imageModel);
            System.out.println("Element shifted to the left");
        }
    }
    public void shiftRight(int index){
        if(index + 1 > modelSize){
            System.out.println("Cannot shift right, out of index");
        }
        else{
            var tempElement = this.imageModel.getElementAt(index);
            var tempElement2 = this.imageModel.getElementAt(index+1);
            this.imageModel.setElementAt(tempElement, index+1);
            this.imageModel.setElementAt(tempElement2, index);
            updateReelModel(this.imageModel);
            System.out.println("Element shifted to the right");
        }
    }
    
    public DefaultListModel updateModel(){
        return imageModel;
    }
    private void updateReelModel(DefaultListModel newModel){
        imageModel = newModel;
    }
}
