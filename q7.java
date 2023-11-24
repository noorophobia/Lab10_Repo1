/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

  class SimpleDrawingProgram extends JFrame {

    private JButton lineButton;
    private JButton rectangleButton;
    private JButton ellipseButton;
    private Canvas canvas;

    private enum DrawMode { LINE, RECTANGLE, ELLIPSE }
    private DrawMode currentMode;

    public SimpleDrawingProgram() {
        setTitle("Simple Drawing Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);

        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rectangle");
        ellipseButton = new JButton("Ellipse");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);
        add(buttonPanel, BorderLayout.SOUTH);

        lineButton.addActionListener(e -> currentMode = DrawMode.LINE);
        rectangleButton.addActionListener(e -> currentMode = DrawMode.RECTANGLE);
        ellipseButton.addActionListener(e -> currentMode = DrawMode.ELLIPSE);

        canvas.addMouseListener(new MouseAdapter() {
            private int x1, y1, x2, y2;

            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                Graphics g = canvas.getGraphics();
                g.setColor(Color.BLACK);

                switch (currentMode) {
                    case LINE:
                        g.drawLine(x1, y1, x2, y2);
                        break;
                    case RECTANGLE:
                        int width = Math.abs(x2 - x1);
                        int height = Math.abs(y2 - y1);
                        g.drawRect(Math.min(x1, x2), Math.min(y1, y2), width, height);
                        break;
                    case ELLIPSE:
                        width = Math.abs(x2 - x1);
                        height = Math.abs(y2 - y1);
                        g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
                        break;
                }
            }
        });

        setVisible(true);
    }

    

    class Canvas extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}

public class q7 {
    
}
