/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;
import javax.swing.*;
import java.awt.event.*;

public class q1 {
    
}

class ClickCounterApp extends JFrame implements ActionListener {
    private JButton button;
    private JLabel label;
    private int clickCount;

    public ClickCounterApp() {
        setTitle("Click Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Click Me");
        label = new JLabel("Click count: 0");

        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickCount++;
        label.setText("Click count: " + clickCount);
    }
}
