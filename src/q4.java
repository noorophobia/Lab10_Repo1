/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class q4 {
    
}
   class TemperatureConverter extends JFrame {

    private JTextField inputField;
    private JButton convertButton;
    private JComboBox<String> sourceUnitComboBox;
    private JComboBox<String> targetUnitComboBox;
    private JLabel resultLabel;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(5, 1));

        inputField = new JTextField(10);
        convertButton = new JButton("Convert");
        sourceUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        targetUnitComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius"});
        resultLabel = new JLabel("Result: ");

        add(new JLabel("Enter Temperature:"));
        add(inputField);
        add(sourceUnitComboBox);
        add(targetUnitComboBox);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        setVisible(true);
    }

    private void convertTemperature() {
        try {
            double inputTemp = Double.parseDouble(inputField.getText());
            String sourceUnit = sourceUnitComboBox.getSelectedItem().toString();
            String targetUnit = targetUnitComboBox.getSelectedItem().toString();
            double convertedTemp = 0;

            if (sourceUnit.equals("Celsius") && targetUnit.equals("Fahrenheit")) {
                convertedTemp = (inputTemp * 9 / 5) + 32;
            } else if (sourceUnit.equals("Fahrenheit") && targetUnit.equals("Celsius")) {
                convertedTemp = (inputTemp - 32) * 5 / 9;
            }

            resultLabel.setText("Result: " + convertedTemp + " " + targetUnit);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    
}
