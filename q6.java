/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

  class ColorPalette extends JFrame {

    private JPanel colorPanel;
    private JButton[] colorButtons;

    public ColorPalette() {
        setTitle("Color Palette");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Creating the panel to change the background color
        colorPanel = new JPanel();
        add(colorPanel, BorderLayout.CENTER);

        // Creating an array of color buttons
        String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Orange", "Pink", "Cyan", "Magenta"};
        colorButtons = new JButton[colorNames.length];

        JPanel buttonPanel = new JPanel(new FlowLayout());
        for (int i = 0; i < colorNames.length; i++) {
            Color color = getColorByName(colorNames[i]);
            colorButtons[i] = new JButton(colorNames[i]);
            colorButtons[i].setBackground(color);
            colorButtons[i].addActionListener(new ColorButtonListener(color));
            buttonPanel.add(colorButtons[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    // Get Color object by name
    private Color getColorByName(String colorName) {
        try {
            return (Color) Color.class.getField(colorName.toLowerCase()).get(null);
        } catch (Exception e) {
            return Color.BLACK; // Default to black if color name not found
        }
    }

    // ActionListener for color buttons
    class ColorButtonListener implements ActionListener {
        private Color color;

        public ColorButtonListener(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(color);
        }
    }

    
}

public class q6 {
    
}
