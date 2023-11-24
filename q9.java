/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;

import javax.swing.*;
import java.awt.event.*;

  class ProgressBarApp extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton resetButton;

    public ProgressBarApp() {
        setTitle("Progress Bar App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        add(progressBar);

        startButton = new JButton("Start");
        resetButton = new JButton("Reset");

        add(startButton);
        add(resetButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startProgressBar();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetProgressBar();
            }
        });

        setVisible(true);
    }

    private void startProgressBar() {
        Timer timer = new Timer(100, new ActionListener() {
            int progress = 0;

            public void actionPerformed(ActionEvent e) {
                progress += 5;
                progressBar.setValue(progress);

                if (progress >= 100) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    private void resetProgressBar() {
        progressBar.setValue(0);
    }

    
}

public class q9 {
    
}
