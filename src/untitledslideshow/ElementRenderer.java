/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;

import java.awt.Color;
import java.awt.Component;
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
        setIconTextGap(16);
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try{
            //addMouseListener(new ClickListener());
            DisplayImage image = (DisplayImage) value;
            setText(image.getImagePath());
            setIcon(image.getImage());
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
