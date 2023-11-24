/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;
  
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

  class ImageBrowserApp extends JFrame {
    private JLabel imageLabel;
    private int currentIndex = 0;
    private String[] imagePaths;

    public ImageBrowserApp() {
        setTitle("Image Browser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton loadButton = new JButton("Load Image");
        buttonPanel.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadImages();
            }
        });

        JButton previousButton = new JButton("Previous");
        buttonPanel.add(previousButton);
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    displayImage();
                }
            }
        });

        JButton nextButton = new JButton("Next");
        buttonPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < imagePaths.length - 1) {
                    currentIndex++;
                    displayImage();
                }
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadImages() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            imagePaths = new String[selectedFiles.length];
            for (int i = 0; i < selectedFiles.length; i++) {
                imagePaths[i] = selectedFiles[i].getAbsolutePath();
            }
            if (imagePaths.length > 0) {
                currentIndex = 0;
                displayImage();
            }
        }
    }

    private void displayImage() {
        ImageIcon image = new ImageIcon(imagePaths[currentIndex]);
        Image scaledImage = image.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage);
        imageLabel.setIcon(image);
    }

    
}

public class q5 {
    
}
