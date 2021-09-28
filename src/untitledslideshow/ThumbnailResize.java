import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics2D;

/*
 * .jpg resize code snippet
 * 
 */

class DisplayImage {

    public static void main(String avg[]) throws IOException
    {
        DisplayImage image =new DisplayImage();                                 // call DisplayImage class to resize .jpegs
    }

    public DisplayImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("c://josh.jpg"));
        BufferedImage thumbnail = resize(img,100,150);                          // 100x150 is preferred size for thumbnails
        ImageIcon icon=new ImageIcon(thumbnail);                                //display thumnail on screen
        //This should be good to excude when merging with main, GUI is already built in
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(990,700);             
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //resize takes a .jpg via its file path, along with the new height and width to change the image to
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
