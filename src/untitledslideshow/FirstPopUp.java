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
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Roberto Murcia
 */
public class FirstPopUp {
    private static final OldSlideInfo oldSlideInfo = new OldSlideInfo();
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
        oldSlide.setText("Import an existing slideshow");
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
                    filechooser.setDialogTitle("Choose a directory of .png or .jpg images to use for your slideshow!");
                    filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    filechooser.showOpenDialog(null);
                    imageDirectory = filechooser.getSelectedFile();
                    setImageDirectory(imageDirectory);
                    if(imageDirectory == null){
                        JOptionPane.showMessageDialog(filechooser, "New Slideshow Cancelled");
                        isNewSlide = false;
                        break;
                    }
                    else if(!imageDirectory.isDirectory()){
                        JOptionPane.showMessageDialog(filechooser, "Item selected is not a directory.");
                        break;
                    }
                    else{
                        noDirectory = false;
                        MightyPointGui.exporter.setSaveDirectory(imageDirectory.toString());
                        System.out.println(MightyPointGui.exporter.getSaveDirectory());
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
                        JOptionPane.showMessageDialog(null, "Item at: " + filePath + " is not a valid image! Images must be JPEGs or PNGs.");

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
                            JOptionPane.showMessageDialog(null, "Image at: " + newImage.getImagePath() + " is corrupted, or not a valid image. Images must be JPEGs or PNGs.");
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
    /**
     * This method allows the user to import a previous slideshow.
     * The user will be asked to provide said save, and then the file is parsed.
     * Information such as the order of the images in the image reel, order of audio files
     * in the sound reel, the interval time, each of the image's transitions and their respective
     * transition times, and the directory to be used are acquired and presented to the user.
     * @param evt is the button being clicked.
     * @return the information in OldSaveInfo
     */
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
                        JSONParser jParser = new JSONParser();
                        try{
                            FileReader fileReader = new FileReader(oldSave);    //Read JSON file
                            Object obj = jParser.parse(fileReader);             //Parse file
                            JSONArray oldSaveList = new JSONArray();
                            oldSaveList.add(obj);
                            oldSaveList.forEach( emp -> parsePreviousSave( (JSONObject) emp));
                        }catch(FileNotFoundException e){} catch(IOException e){} catch(ParseException e){}
                        if(oldSlideInfo.getOldImagesList().isEmpty()){
                            JOptionPane.showMessageDialog(filechooser, "No Images Found in save file, or save file is corrupt, please try a new file.");
                            noFile = true;
                            break;
                        }
                        else{
                            ArrayList<DisplayImage> list = new ArrayList<>();
                            ArrayList<String> imagePaths = oldSlideInfo.getOldImagesList();
                            for(String path : imagePaths){
                                DisplayImage newImage = new DisplayImage();
                                newImage.setImagePath(path);
                                if(newImage.getImage() == null){
                                    JOptionPane.showMessageDialog(null, "Image at: " + newImage.getImagePath() + " is corrupted, or not a valid image.");
                                    continue;
                                }
                                list.add(newImage);
                            }
                            oldSlideInfo.setOldThumbnails(list);
                            noFile = false;
                            setDone();
                            this.firstFrame.setVisible(false);
                            return oldSlideInfo;
                            
                        }
                        
                    }
                    else if(!matcher.matches(oldSave.toPath())){
                        JOptionPane.showMessageDialog(null, "Selected file is not a .JSON file.");
                    }

                }catch(NullPointerException exception){
                    
                }
            }
        }
        return null;
        

    }
    /**
     * Sets the imageThumbnails list to list
     * @param list 
     */
    private void setArrayList(ArrayList<DisplayImage> list){
        imageThumbnails = list;
    }
    /**
     * Acquires image thumbnails
     * @return imageThumbnails
     */
    public ArrayList<DisplayImage> getArrayList(){
        return imageThumbnails;
    }
    /**
     * Sets isDone to true
     */
    private void setDone(){
        isDone = true;
    }
    /**
     * Returns whether or not isDone is true
     * @return true or false
     */
    public boolean getDone(){
        return isDone;
    }
    /**
     * Sets the image directory to directory
     * @param directory is the directory provided
     */
    private void setImageDirectory(File directory){
        imageDirectory = directory;
    }
    /**
     * Acquires the image directory stored
     * @return that image directory
     */
    public String getImageDirectory(){
        return imageDirectory.toString();
    }
    /**
     *  Sets isNew to true; 
     */
    private void setNew(){
        isNew = true;
    }
    /**
     * Sets isNew to false
     */
    private void setOld(){
        isNew = false;
    }
    /**
     * Returns whether isNew is true or false
     * @return true or false
     */
    public boolean getNew(){
        return isNew;
    }
    /**
     * parsePreviousSave will parse the JSON file that is provided by the user to acquire
     * information from the previous save file.
     * @param previousSave is the provided file from the user to be parsed.
     */
    private void parsePreviousSave(JSONObject previousSave){
      
        String isManual = (String) previousSave.get("changeManually");               //Get whether old slide show was manual or interval
        if(isManual.equals("true")){
            oldSlideInfo.setManual();
        }
        else if(isManual.equals("false")){
            oldSlideInfo.isInterval();
        }
        System.out.println(oldSlideInfo.getIsManual());
        
        oldSlideInfo.setImageDuration(Float.parseFloat((String) previousSave.get("imageDuration")));    //Get image duration of old slideshow
        System.out.println(oldSlideInfo.getImageDuration());
        oldSlideInfo.setDirectory((String) previousSave.get("imageDirectory"));
        //====================Get Images========================//
        
        ArrayList<String> imagesList = new ArrayList<>();                       //Create a string arraylist and acquire the paths of each image used.
        String[] imagePaths = previousSave.get("images").toString().split(",");      //Remove commas and then remove quotations from string
        for(String path : imagePaths){
            path = path.replace("\"", "");                                      //Remove quotations and brackets from string
            path = path.replace("[", "");
            path = path.replace("]", "");
            imagesList.add(path);
        }
        oldSlideInfo.setOldImagesList(imagesList);                              //Get list of image paths
        System.out.println(oldSlideInfo.getOldImagesList());
        
        //====================Get Transitions========================//
        

        ArrayList<Integer> transitionsList = new ArrayList<>();                  //Get image transitions from old slideshow
        String[] transitions = previousSave.get("transitions").toString().split(",");//Remove commas from strings
        for(String transition : transitions){
            transition = transition.replace("\"", "");                          //Remove quotations and brackets from string
            transition = transition.replace("[", "");
            transition = transition.replace("]", "");
            transitionsList.add(Integer.parseInt(transition));
        }
        oldSlideInfo.setOldImageTransitions(transitionsList);                   //Set list of transitions
        System.out.println(oldSlideInfo.getOldImageTransitions());
        
        //====================Get Transition Intervals========================//
        
        ArrayList<Float> transitionIntervals = new ArrayList<>();
        String[] intervals = previousSave.get("transitionLengths").toString().split(",");
        for(String interval : intervals){
            interval = interval.replace("\"", "");                              //Remove quotations and brackets from string
            interval = interval.replace("[", "");
            interval = interval.replace("]", "");
            if(interval.isEmpty() || interval.isBlank()){
                
            }
            else{
                transitionIntervals.add(Float.parseFloat(interval));
            }
            
        }
        oldSlideInfo.setOldImageTransLengths(transitionIntervals);
        System.out.println(oldSlideInfo.getOldImageTransLengths());
        
        ArrayList<String> soundsList = new ArrayList<>();
        String[] soundPaths = previousSave.get("sounds").toString().split(",");
        for(String path : soundPaths){
            path = path.replace("\"", "");                                      //Remove quotations and brackets from string
            path = path.replace("[", "");
            path = path.replace("]", "");
            soundsList.add(path);
        }
        oldSlideInfo.setOldSoundsList(soundsList);
        System.out.println(oldSlideInfo.getOldSoundsList());
        
            ArrayList<String> commentList = new ArrayList<>();   
        String[] comments = previousSave.get("_comments").toString().split("\n");
        for(String comment: comments)
        {
            comment = comment.replace("\"", "");                                      //Remove quotations and brackets from string
            comment = comment.replace("[", "");
            comment = comment.replace("]", "");
            commentList.add(comment);
        }
        System.out.println(OldSlideInfo.getComments());
    }
    /**
     * Acquires the images within the directory supplied by the previous slideshow file.
     * @param directory is the directory from the file
     * @return the images from that directory
     */
    public ArrayList<DisplayImage> getDirectoryImages(String directory){
        ArrayList<String> imagePaths = new ArrayList<>();
        System.out.println(directory);
        File fileDirectory = new File(directory);
        File[] fileList = fileDirectory.listFiles();
        ArrayList<DisplayImage> imageList = new ArrayList<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:^.*\\.jpg");
        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("regex:^.*\\.png");
        int counter = 0;
        try{
            for (File image : fileList) {
                Path filePath = image.toPath();
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
                    JOptionPane.showMessageDialog(noImage, "No JPEGs or PNGs were found within this directory. Try with a new save file!");
                    //isNewSlide = false;
                    return null;
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
                    imageList = list;
                    
                }
            }catch(NullPointerException exception){System.out.println(exception);}
            
        return imageList;
    }

}
