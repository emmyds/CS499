/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untitledslideshow;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto Murcia
 */
public class FirstPopUp {
    private static OldSlideInfo oldSlideInfo = new OldSlideInfo();
    private static boolean isNew = false;
    private final JFrame firstFrame = new JFrame();
    private final JButton newSlide = new JButton();
    private final JButton oldSlide = new JButton();
    private File imageDirectory = null;
    private ArrayList<DisplayImage>imageThumbnails = null;
    private static boolean isDone = false;
    public void createPop(){
        firstFrame.setLayout(new FlowLayout());
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel firstLabel = new JLabel();
        JLabel secondLabel = new JLabel();
        firstLabel.setText("Welcome to the mightyPoint slideshow editor!");
        secondLabel.setText("Choose from either of the following options: ");
        newSlide.setText("Create a new slideshow");
        oldSlide.setText("Import an old slideshow");
        firstFrame.add(firstLabel);
        firstFrame.add(secondLabel);
        firstFrame.add(newSlide);
        firstFrame.add(oldSlide);
                
        /*
        Resizing and dimensions of the popup
        */
        firstFrame.setPreferredSize(new Dimension(400,150));
        firstFrame.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - firstFrame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - firstFrame.getHeight()) / 2);
        firstFrame.setLocation(x, y);
        firstFrame.setResizable(false);
        firstFrame.setVisible(true);
        newSlide.addActionListener((ActionEvent e) -> {setNew(); newSlideButtonActionPerformed(e);});
        oldSlide.addActionListener((ActionEvent e) -> {setOld(); oldSlideButtonActionPerformed(e); });
    }
    /**
     * This is performed whenever the new slide button is pressed. It asks the user for a directory
     * of images to import, and then verifies each of these files before then adding them to the editor.
     * @param evt
     * @return ArrayList of DisplayImages
     */
    private ArrayList<DisplayImage> newSlideButtonActionPerformed(java.awt.event.ActionEvent evt){
        setNew();
        boolean isNewSlide = true;
        boolean noDirectory = true;
        while(isNewSlide == true){
            ArrayList<String> imagePaths = new ArrayList<>();
            while(noDirectory == true){
                try{
                    JFileChooser filechooser = new JFileChooser();
                    filechooser.setDialogTitle("Choose a Directory of Images to use for your slideshow!");
                    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    filechooser.showOpenDialog(null);
                    imageDirectory = filechooser.getSelectedFile();
                    setImageDirectory(imageDirectory);
                    if(imageDirectory == null){
                        JOptionPane.showMessageDialog(filechooser, "New Slideshow Cancelled");
                        isNewSlide = false;
                        break;
                    }
                    else{
                        noDirectory = false;
                    }
            }catch(NullPointerException exception){}
            }
            try{
                File fileDirectories[] = this.imageDirectory.listFiles();
                int counter = 0;
            PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:^.*\\.jpg");
            PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("regex:^.*\\.png");
            try{
                for (File fileDirectory : fileDirectories) {
                    Path filePath = fileDirectory.toPath();
                    if (matcher.matches(filePath) || matcher2.matches(filePath)){
                        counter++;
                        System.out.print("Item name: " + filePath + " is an image!\n");
                        imagePaths.add(filePath.toString());
                    }
                    else{
                        System.out.print("\nIndex: " + filePath + " is not a JPEG or PNG!\n");
                        JOptionPane.showMessageDialog(null, "Item at: " + filePath + " is not a valid image!");

                    }
                }
                if(imagePaths.isEmpty()){
                    JFrame noImage = new JFrame();
                    noImage.setLocationRelativeTo(firstFrame);
                    noImage.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(noImage, "No JPEGs or PNGs were found within this directory. Please try again with a new directory.");
                    //isNewSlide = false;
                    break;
                }
                else{
                    ArrayList<DisplayImage> list = new ArrayList<>();
                    for(String jpegPath : imagePaths){                                  //For creates a display image object and holds the current image
                        DisplayImage newImage = new DisplayImage();                     //Then sets the image path of that image
                        newImage.setImagePath(jpegPath);                                //Then adds that display image object into imageThumbnails
                        if(newImage.getImage() == null){
                            JOptionPane.showMessageDialog(null, "Image at: " + newImage.getImagePath() + " is corrupted, or not a valid image.");
                            continue;
                        }
                        list.add(newImage);
                    }
                    setArrayList(list);
                    System.out.print(imageThumbnails.size());
                    this.firstFrame.setVisible(false);
                    setDone();
                    
                    return imageThumbnails;
                    
                }
            }
            catch(NullPointerException exception){System.out.print(exception);}
            }
            catch(NullPointerException e){}
            
            
        }
        return null;
    }
    private OldSlideInfo oldSlideButtonActionPerformed(java.awt.event.ActionEvent evt){
        setOld();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:^.*\\.JSON");
        File oldSave;
        boolean isOldSlide = true;
        boolean noFile = true;
        while(isOldSlide == true){
            while(noFile == true){
                try{
                    JFileChooser filechooser = new JFileChooser();
                    filechooser.setDialogTitle("Choose an old save file to use!");
                    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    filechooser.showOpenDialog(null);
                    oldSave = filechooser.getSelectedFile();
                    if(oldSave == null){
                        JOptionPane.showMessageDialog(filechooser, "Old Slideshow Cancelled.");
                        isOldSlide = false;
                        break;
                    }
                    else if(matcher.matches(oldSave.toPath())){
                        System.out.println("File is a .JSON file.");
                        noFile = false;
                    }
                    
                    
                    
                }catch(NullPointerException exception){
                    
                }
            }
        }
        setDone();
        return oldSlideInfo;
    }
    private void setArrayList(ArrayList<DisplayImage> list){
        imageThumbnails = list;
    }
    public ArrayList<DisplayImage> getArrayList(){
        return imageThumbnails;
    }
    private void setDone(){
        isDone = true;
    }
    public boolean getDone(){
        return isDone;
    }
    private void setImageDirectory(File directory){
        imageDirectory = directory;
    }
    public String getImageDirectory(){
        return imageDirectory.toString();
    }
    
    private void setNew(){
        isNew = true;
    }
    
    private void setOld(){
        isNew = false;
    }
    
    public boolean getNew(){
        return isNew;
    }

}
