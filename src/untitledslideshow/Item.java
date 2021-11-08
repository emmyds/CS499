/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Roberto Murcia
 */
public class Item extends JLabel{
    private final String imagePath;
    private final String itemType;
    private final ImageIcon itemImage;
    public Item(String path, String type, ImageIcon image){
        this.imagePath = path;
        this.itemType = type;
        this.itemImage = image;
        this.setIcon(image);
    }
    public String getImagePath(){
        return this.imagePath;
    }
    public String getItemType(){
        return this.itemType;
    }
    public ImageIcon getImage(){
        return this.itemImage;
    }
}
