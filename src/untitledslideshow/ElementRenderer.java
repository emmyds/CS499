/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Roberto Murcia
 */
public class ElementRenderer extends JLabel implements ListCellRenderer{
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    public ElementRenderer(){
        setOpaque(true);
        //setIconTextGap(16);
    }
    private Map<String, Icon> iconCache = new HashMap<>();
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try{
            
            DisplayImage image = (DisplayImage) value;
            this.setName(image.getImagePath());
            if(!iconCache.containsKey(image)){
                iconCache.put(value.toString(), new ImageIcon(image.getImagePath()));
                this.setIcon(image.getImage());
            }
            setName(image.getImagePath());
        }catch(UnsupportedOperationException e){}
        if(isSelected){
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        }else{
            setBackground(Color.white);
            setForeground(Color.black);
        }
        
        return this;
    }
}
