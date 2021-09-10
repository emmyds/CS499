/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberto Murcia
 */
public class MightyPointGui extends javax.swing.JFrame {
    
    /**
     * Creates new form untitledGUI
     */
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
        slideshowTitleLabel = new javax.swing.JLabel();
        currentContentBox = new javax.swing.JTextField();
        manualButton = new javax.swing.JRadioButton();
        intervalButton = new javax.swing.JRadioButton();
        slideshowImagesScrollBar = new javax.swing.JScrollBar();
        intervalLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        filenameTextBox = new javax.swing.JTextField();
        mainTabbedPane = new javax.swing.JTabbedPane();
        imagesPanel = new javax.swing.JPanel();
        imageDirectoryButton = new javax.swing.JButton();
        imagesScrollPane = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList<>();
        soundsPanel = new javax.swing.JPanel();
        soundsScrollPane = new javax.swing.JScrollPane();
        soundsList = new javax.swing.JList<>();
        soundSelectButton = new javax.swing.JButton();
        transitionsPanel = new javax.swing.JPanel();
        transitionsScrollPane = new javax.swing.JScrollPane();
        transitionsList = new javax.swing.JList<>();
        previewButton = new javax.swing.JButton();
        intervalSpinner = new javax.swing.JSpinner();
        exitButton = new javax.swing.JButton();
        iconPanel = new javax.swing.JPanel();
        imagesSlidesPanel = new javax.swing.JScrollPane();
        slideshowImagesList = new javax.swing.JList<>();
        soundsSlidesPanel = new javax.swing.JScrollPane();
        soundsSlidesList = new javax.swing.JList<>();
        extraOptionsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        slideshowTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slideshowTitleLabel.setText("Untitled Slideshow Editor");

        currentContentBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentContentBox.setText("The currently selected image will go here.");
        currentContentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentContentBoxActionPerformed(evt);
            }
        });

        manualIntervalButton.add(manualButton);
        manualButton.setText("Manual Slides");

        manualIntervalButton.add(intervalButton);
        intervalButton.setText("Interval");
        intervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalButtonActionPerformed(evt);
            }
        });

        slideshowImagesScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        intervalLabel.setText("User interval or manual selection");

        saveButton.setText("Save File");

        filenameTextBox.setText("fileName.file");

        imageDirectoryButton.setText("Select Image Directory");
        imageDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageDirectoryButtonActionPerformed(evt);
            }
        });

        imagesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        imagesScrollPane.setViewportView(imagesList);

        javax.swing.GroupLayout imagesPanelLayout = new javax.swing.GroupLayout(imagesPanel);
        imagesPanel.setLayout(imagesPanelLayout);
        imagesPanelLayout.setHorizontalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagesScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageDirectoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap())
        );
        imagesPanelLayout.setVerticalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addComponent(imageDirectoryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Images", imagesPanel);

        soundsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        soundsScrollPane.setViewportView(soundsList);

        soundSelectButton.setText("Select Sound File");

        javax.swing.GroupLayout soundsPanelLayout = new javax.swing.GroupLayout(soundsPanel);
        soundsPanel.setLayout(soundsPanelLayout);
        soundsPanelLayout.setHorizontalGroup(
            soundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, soundsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(soundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(soundsScrollPane)
                    .addComponent(soundSelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap())
        );
        soundsPanelLayout.setVerticalGroup(
            soundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(soundsPanelLayout.createSequentialGroup()
                .addComponent(soundSelectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soundsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Sounds", soundsPanel);

        transitionsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        transitionsScrollPane.setViewportView(transitionsList);

        javax.swing.GroupLayout transitionsPanelLayout = new javax.swing.GroupLayout(transitionsPanel);
        transitionsPanel.setLayout(transitionsPanelLayout);
        transitionsPanelLayout.setHorizontalGroup(
            transitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transitionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transitionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
        transitionsPanelLayout.setVerticalGroup(
            transitionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transitionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transitionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Transitions", transitionsPanel);

        previewButton.setText("Preview");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        intervalSpinner.setMaximumSize(new java.awt.Dimension(0, 10));
        intervalSpinner.setName(""); // NOI18N

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
            .addGap(0, 40, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        slideshowImagesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        imagesSlidesPanel.setViewportView(slideshowImagesList);

        soundsSlidesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        soundsSlidesPanel.setViewportView(soundsSlidesList);

        javax.swing.GroupLayout extraOptionsPanelLayout = new javax.swing.GroupLayout(extraOptionsPanel);
        extraOptionsPanel.setLayout(extraOptionsPanelLayout);
        extraOptionsPanelLayout.setHorizontalGroup(
            extraOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        extraOptionsPanelLayout.setVerticalGroup(
            extraOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slideshowTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(intervalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intervalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(intervalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filenameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saveButton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(mainTabbedPane)
                                    .addComponent(extraOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(manualButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(136, 136, 136)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(soundsSlidesPanel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagesSlidesPanel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slideshowImagesScrollBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(currentContentBox, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(previewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(exitButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slideshowTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton)
                    .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filenameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentContentBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagesSlidesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soundsSlidesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slideshowImagesScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewButton)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainTabbedPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(intervalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(intervalButton)
                            .addComponent(intervalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manualButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extraOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void currentContentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentContentBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentContentBoxActionPerformed

    private void intervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intervalButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed

       setVisible(false);
       System.exit(1);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_previewButtonActionPerformed

    private void imageDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageDirectoryButtonActionPerformed

    }//GEN-LAST:event_imageDirectoryButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MightyPointGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MightyPointGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MightyPointGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MightyPointGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MightyPointGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentContentBox;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel extraOptionsPanel;
    private javax.swing.JTextField filenameTextBox;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JButton imageDirectoryButton;
    private javax.swing.JList<String> imagesList;
    private javax.swing.JPanel imagesPanel;
    private javax.swing.JScrollPane imagesScrollPane;
    private javax.swing.JScrollPane imagesSlidesPanel;
    private javax.swing.JRadioButton intervalButton;
    private javax.swing.JLabel intervalLabel;
    private javax.swing.JSpinner intervalSpinner;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JRadioButton manualButton;
    private javax.swing.ButtonGroup manualIntervalButton;
    private javax.swing.JButton previewButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JList<String> slideshowImagesList;
    private javax.swing.JScrollBar slideshowImagesScrollBar;
    private javax.swing.JLabel slideshowTitleLabel;
    private javax.swing.JButton soundSelectButton;
    private javax.swing.JList<String> soundsList;
    private javax.swing.JPanel soundsPanel;
    private javax.swing.JScrollPane soundsScrollPane;
    private javax.swing.JList<String> soundsSlidesList;
    private javax.swing.JScrollPane soundsSlidesPanel;
    private javax.swing.JList<String> transitionsList;
    private javax.swing.JPanel transitionsPanel;
    private javax.swing.JScrollPane transitionsScrollPane;
    // End of variables declaration//GEN-END:variables
}
