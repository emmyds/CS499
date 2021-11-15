package untitledslideshow;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberto Murcia
 */
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.ImageIcon;
public class MightyPointGui extends javax.swing.JFrame {
    
    /**
     * Creates new form MightyPointGUI
     */
    private boolean isManual;
    private boolean isInterval;
    private int intervalTime;
    private String saveDirectory;
    private String imageDirectory;
    private ArrayList<ImageItem> images;
    public static final Exporter exporter = new Exporter();
    
    public MightyPointGui() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manualIntervalButton = new javax.swing.ButtonGroup();
        mainTabbedPane = new javax.swing.JTabbedPane();
        imagesPanel = new javax.swing.JPanel();
        imagesScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList<>();
        imagesList = new javax.swing.JList<>();
        soundsPanel = new javax.swing.JPanel();
        soundSelectButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        iconPanel = new javax.swing.JPanel();
        extraSettingsPanel = new javax.swing.JPanel();
        manualButton = new javax.swing.JRadioButton();
        intervalButton = new javax.swing.JRadioButton();
        intervalLabel = new javax.swing.JLabel();
        transitionSettingsPanel = new javax.swing.JPanel();
        transitionLengthLabel = new javax.swing.JLabel();
        transitionLengthField = new javax.swing.JTextField();
        intervalTextField = new javax.swing.JTextField();
        slideShowReelPanel = new javax.swing.JPanel();
        slideShowReelContainer = new javax.swing.JPanel();
        reelScrollPane = new javax.swing.JScrollPane();
        imagesReel = new javax.swing.JList<>();
        mightyPointLogo = new javax.swing.JLabel();
        saveExportPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        filenameTextBox = new javax.swing.JTextField();
        soundsReelPanel = new javax.swing.JPanel();
        soundsReelScroll = new javax.swing.JScrollPane();
        soundsReel = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mightyPoint Editor");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(153, 153, 153));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1212, 910));
        setName("mainFrame"); // NOI18N
        setSize(new java.awt.Dimension(0, 0));

        mainTabbedPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        imagesList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagesList.setModel(new javax.swing.DefaultListModel<String>() {
            String[] imageStrings = {null};
            public int getSize() { return imageStrings.length; }
            public String getElementAt(int i) { return imageStrings[i]; }
        });
        imagesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        imagesList.setToolTipText("");
        imagesList.setAutoscrolls(false);
        imagesList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imagesList.setDragEnabled(true);
        imagesList.setDropMode(javax.swing.DropMode.ON);
        imagesList.setFixedCellHeight(175);
        imagesList.setFixedCellWidth(175);
        imagesList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        imagesList.setName("imagesList"); // NOI18N
        imagesList.setSelectionBackground(new java.awt.Color(0, 51, 153));
        imagesList.setVisibleRowCount(1);
        imagesScrollPane.setViewportView(imagesList);
        imagesList.getAccessibleContext().setAccessibleName("");
        imagesList.addMouseListener(new ClickListener());

        javax.swing.GroupLayout imagesPanelLayout = new javax.swing.GroupLayout(imagesPanel);
        imagesPanel.setLayout(imagesPanelLayout);
        imagesPanelLayout.setHorizontalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagesScrollPane)
                .addContainerGap())
        );
        imagesPanelLayout.setVerticalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainTabbedPane.addTab("Images", imagesPanel);

        soundsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        soundSelectButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soundSelectButton.setText("Import Sound File");
        soundSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundSelectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout soundsPanelLayout = new javax.swing.GroupLayout(soundsPanel);
        soundsPanel.setLayout(soundsPanelLayout);
        soundsPanelLayout.setHorizontalGroup(
            soundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soundsPanelLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(soundSelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addGap(340, 340, 340))
        );
        soundsPanelLayout.setVerticalGroup(
            soundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soundsPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(soundSelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(88, 88, 88))
        );

        mainTabbedPane.addTab("Sounds", soundsPanel);

        exitButton.setText("X");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        extraSettingsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        manualIntervalButton.add(manualButton);
        manualButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        manualButton.setSelected(true);
        manualButton.setText("Manual Slides");
        manualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualButtonActionPerformed(evt);
            }
        });

        manualIntervalButton.add(intervalButton);
        intervalButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        intervalButton.setText("Interval");
        intervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalButtonActionPerformed(evt);
            }
        });

        intervalLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        intervalLabel.setText("User interval or manual selection");

        transitionSettingsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        transitionLengthLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        transitionLengthLabel.setText("Transition Length");

        ((AbstractDocument) transitionLengthField.getDocument()).setDocumentFilter(new untitledslideshow.IntervalTransitionFilter());

        javax.swing.GroupLayout transitionSettingsPanelLayout = new javax.swing.GroupLayout(transitionSettingsPanel);
        transitionSettingsPanel.setLayout(transitionSettingsPanelLayout);
        transitionSettingsPanelLayout.setHorizontalGroup(
            transitionSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transitionSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transitionLengthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transitionLengthField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transitionSettingsPanelLayout.setVerticalGroup(
            transitionSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transitionSettingsPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(transitionSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transitionLengthLabel)
                    .addComponent(transitionLengthField))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ((AbstractDocument) intervalTextField.getDocument()).setDocumentFilter(new untitledslideshow.IntervalTransitionFilter());

        javax.swing.GroupLayout extraSettingsPanelLayout = new javax.swing.GroupLayout(extraSettingsPanel);
        extraSettingsPanel.setLayout(extraSettingsPanelLayout);
        extraSettingsPanelLayout.setHorizontalGroup(
            extraSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(extraSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(extraSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(extraSettingsPanelLayout.createSequentialGroup()
                        .addComponent(intervalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(intervalLabel)
                    .addComponent(manualButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transitionSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        extraSettingsPanelLayout.setVerticalGroup(
            extraSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, extraSettingsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transitionSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(extraSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(intervalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(extraSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intervalButton)
                    .addGroup(extraSettingsPanelLayout.createSequentialGroup()
                        .addComponent(intervalTextField)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manualButton)
                .addGap(36, 36, 36))
        );

        slideShowReelPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        slideShowReelPanel.setPreferredSize(new java.awt.Dimension(1182, 178));

        imagesReel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagesReel.setFixedCellHeight(175);
        imagesReel.setFixedCellWidth(175);
        imagesReel.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        imagesReel.setName("imagesReel"); // NOI18N
        imagesReel.setVisibleRowCount(1);
        reelScrollPane.setViewportView(imagesReel);
        imagesReel.addMouseListener(new ClickListener());
        imagesReel.setModel(new DefaultListModel());
        imagesReel.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout slideShowReelContainerLayout = new javax.swing.GroupLayout(slideShowReelContainer);
        slideShowReelContainer.setLayout(slideShowReelContainerLayout);
        slideShowReelContainerLayout.setHorizontalGroup(
            slideShowReelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideShowReelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reelScrollPane)
                .addContainerGap())
        );
        slideShowReelContainerLayout.setVerticalGroup(
            slideShowReelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideShowReelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout slideShowReelPanelLayout = new javax.swing.GroupLayout(slideShowReelPanel);
        slideShowReelPanel.setLayout(slideShowReelPanelLayout);
        slideShowReelPanelLayout.setHorizontalGroup(
            slideShowReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideShowReelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slideShowReelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        slideShowReelPanelLayout.setVerticalGroup(
            slideShowReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideShowReelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slideShowReelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mightyPointLogo.setFont(new java.awt.Font("Comic Sans MS", 3, 30)); // NOI18N
        mightyPointLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mightypint.jpg"))); // NOI18N
        mightyPointLogo.setText("mightyPoint (We make a mighty Point!)");
        mightyPointLogo.setToolTipText("");
        mightyPointLogo.setMaximumSize(new java.awt.Dimension(150, 150));
        mightyPointLogo.setMinimumSize(new java.awt.Dimension(150, 150));
        mightyPointLogo.setPreferredSize(new java.awt.Dimension(150, 150));
        mightyPointLogo.setVerifyInputWhenFocusTarget(false);

        saveExportPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save and Export");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        ((AbstractDocument) filenameTextBox.getDocument()).setDocumentFilter(new untitledslideshow.SaveFileInputFilter());
        filenameTextBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout saveExportPanelLayout = new javax.swing.GroupLayout(saveExportPanel);
        saveExportPanel.setLayout(saveExportPanelLayout);
        saveExportPanelLayout.setHorizontalGroup(
            saveExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveExportPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filenameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        saveExportPanelLayout.setVerticalGroup(
            saveExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveExportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saveExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filenameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        soundsReelPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        soundsReel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        soundsReel.setToolTipText("This is the soundtrack Reel.");
        soundsReel.setFixedCellHeight(100);
        soundsReel.setFixedCellWidth(200);
        soundsReel.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        soundsReel.setVisibleRowCount(1);
        soundsReelScroll.setViewportView(soundsReel);
        soundsReel.addMouseListener(new ClickListener());
        soundsReel.setName("soundsReel");
        soundsReel.setModel(new DefaultListModel());

        javax.swing.GroupLayout soundsReelPanelLayout = new javax.swing.GroupLayout(soundsReelPanel);
        soundsReelPanel.setLayout(soundsReelPanelLayout);
        soundsReelPanelLayout.setHorizontalGroup(
            soundsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soundsReelPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(soundsReelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        soundsReelPanelLayout.setVerticalGroup(
            soundsReelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soundsReelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(soundsReelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(extraSettingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slideShowReelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(mightyPointLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveExportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(soundsReelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mightyPointLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveExportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slideShowReelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soundsReelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extraSettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Gives the user the option to have slides transition with a given interval
     * @param evt is the event of the user selecting the interval radio option
     */
    private void intervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalButtonActionPerformed
        System.out.println(evt.toString());
        isInterval = true;
        System.out.print(intervalTime);
    }//GEN-LAST:event_intervalButtonActionPerformed
    /**
     * Allows the user to exit the program
     * @param evt is the event of the user clicking the exit button
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.out.println(evt.toString());
        JFrame onExitFrame = new JFrame("Exit Menu");
        onExitFrame.setSize(200,200);
        onExitFrame.setLocationRelativeTo(this);
        onExitFrame.setAlwaysOnTop(true);
        int result = JOptionPane.showConfirmDialog(onExitFrame, "Please confirm that you have saved your slideshow first! "
               + "Would you like to exit anyway?");
        switch(result){
            case JOptionPane.YES_OPTION:
                System.out.println("\nExiting Now\n");
                System.exit(1);
            case JOptionPane.NO_OPTION:
                System.out.println("\nClosing Exit Dialog\n");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("\nExit Dialog Cancelled\n");
                break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("\nExit Dialog Closed\n");
       }
    }//GEN-LAST:event_exitButtonActionPerformed

   
   /**
     * Allows the user to save a file that can be opened in the companion application
     * Will also create a folder in the project directory for saved slideshows if not present already
     * @param evt is the event of the user clicking on the Save button
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        System.out.println(evt.toString());
        exporter.export();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void soundSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundSelectButtonActionPerformed
        System.out.println(evt.toString());
        boolean isValid = false;
        File soundDirectory;
        JFileChooser soundFileChooser = new JFileChooser();
        soundFileChooser.setDialogTitle("Choose a sound file to add to your slide show!");
        soundFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        soundFileChooser.showOpenDialog(this);
        soundDirectory = soundFileChooser.getSelectedFile();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:^.*\\.wav");
        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("regex:^.*\\.aiff");
        try{
            if (matcher.matches(soundDirectory.toPath()) || matcher2.matches(soundDirectory.toPath())){
                System.out.print("Item name: " + soundDirectory.toPath() + " is a sound!\n");
            }
            else{
                System.out.print("\nItem name: " + soundDirectory.toPath() + " is not a sound\n");
            }
            isValid = true;
        }
        catch(NullPointerException exception){
            System.out.print("An exception was found at index");
            JOptionPane.showMessageDialog(this, "No Valid Sound File was Found");
        }
        boolean isReal = false;
        double lengthSec = 0.0;
        if(isValid){
            try{
                AudioInputStream audioIS = AudioSystem.getAudioInputStream(soundDirectory);
                AudioFormat format = audioIS.getFormat();
                long frames = audioIS.getFrameLength();
                lengthSec = (frames + 0.0) / format.getFrameRate();
                
                isReal = true;
                if(lengthSec == 0){
                    JOptionPane.showMessageDialog(this, "Selected Sound file: " + soundDirectory.getName() + " has a length of 00.00");
                    isReal = false;
                }
            } catch (UnsupportedAudioFileException ex) {
                JOptionPane.showMessageDialog(this, "Selected Sound file: " + soundDirectory.getName() + " is not a valid sound file.");
            } catch (IOException ex) {
            }
        }
        if(isReal){
            System.out.println("Audio file: " + soundDirectory.getName() + " is valid with track length: " + lengthSec);
            SoundItem newSound = new SoundItem(soundDirectory.toString(), soundDirectory.getName(), lengthSec);
            newSound.addToDLM(newSound);
            //int endIndex = tempSoundReelModel.getSize();
            //tempSoundReelModel.add(endIndex, newSound);
            exporter.getSounds().add(newSound);
            for (SoundItem i : exporter.getSounds()){
                System.out.println("Sound: " + i.getPath());
            }
        }  
    }//GEN-LAST:event_soundSelectButtonActionPerformed

    private void manualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualButtonActionPerformed
        System.out.println(evt.toString());
        isManual = true;
        isInterval = false;
    }//GEN-LAST:event_manualButtonActionPerformed
//    public ArrayList<ImageItem> getImages(){
//        return this.images;
//    }
    /**
     * Main will begin by providing a popup, asking the user if they would like to
     * create a new slideshow, or import an old one. The editor should not open unless
     * an option is chosen by the user. Once a directory is chosen, all available .jpg files
     * will be found and put into ArrayList imagePaths. From there, this list can be sent to
     * various classes that will provide thumbnails, along with creating Item objects for these
     * images.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
        Creation of the frame for the popup
        */
        MightyPointGui mainGui = new MightyPointGui();
        FirstPopUp popUp = new FirstPopUp();
        popUp.createPop();
        ArrayList<DisplayImage> thumbImages = null;
        while(true){
            thumbImages = popUp.getArrayList();
            if(thumbImages != null){
                break;
            }
            try {
               Thread.sleep(100); 
            }
            catch(InterruptedException ex){
            }
        }
        System.out.println("Left PopUp");
        DefaultListModel dlm = new DefaultListModel();
        int i = 0;
        for (DisplayImage listImage : thumbImages) {
            ImageIcon newImg = listImage.getImage();
            newImg.setDescription(listImage.getImagePath());
            System.out.println(newImg.getDescription());
            dlm.add(i, listImage.getImage());
            i++;
        }
        
        mainGui.imageDirectory = popUp.getImageDirectory();
        mainGui.imagesList.setModel(dlm);
        
        /* Cell Renderer Shenanigans
        ElementRenderer renderer = new ElementRenderer();
        mainGui.imagesList.setCellRenderer(renderer);
        */
        
        mainGui.slideShowReelPanel.setLayout(new CardLayout());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            mainGui.setVisible(true);
            ClickPopUp updateGUI = new ClickPopUp(mainGui.imagesReel);
            mainGui.imagesReel.setModel(updateGUI.getDLM());
            SoundItem updateItem = new SoundItem(null, null, 0);
            mainGui.soundsReel.setModel(updateItem.getDLM());
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel extraSettingsPanel;
    private javax.swing.JTextField filenameTextBox;
    private javax.swing.JPanel iconPanel;
    protected javax.swing.JList<String> imagesList;
    private javax.swing.JPanel imagesPanel;
    protected javax.swing.JList<String> imagesReel;
    private javax.swing.JScrollPane imagesScrollPane;
    private javax.swing.JRadioButton intervalButton;
    private javax.swing.JLabel intervalLabel;
    private javax.swing.JTextField intervalTextField;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JRadioButton manualButton;
    private javax.swing.ButtonGroup manualIntervalButton;
    private javax.swing.JLabel mightyPointLogo;
    private javax.swing.JScrollPane reelScrollPane;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel saveExportPanel;
    private javax.swing.JPanel slideShowReelContainer;
    private javax.swing.JPanel slideShowReelPanel;
    private javax.swing.JButton soundSelectButton;
    private javax.swing.JPanel soundsPanel;
    private javax.swing.JList<String> soundsReel;
    private javax.swing.JPanel soundsReelPanel;
    private javax.swing.JScrollPane soundsReelScroll;
    private javax.swing.JTextField transitionLengthField;
    private javax.swing.JLabel transitionLengthLabel;
    private javax.swing.JPanel transitionSettingsPanel;
    // End of variables declaration//GEN-END:variables
}
