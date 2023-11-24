/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_7;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

  class MonthlyCalendar extends JFrame {
    private JLabel monthYearLabel;
    private JList<String> daysList;
    private Map<LocalDate, String> eventsMap;

    public MonthlyCalendar() {
        setTitle("Monthly Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        monthYearLabel = new JLabel("", SwingConstants.CENTER);
        add(monthYearLabel, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        daysList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(daysList);
        add(scrollPane, BorderLayout.CENTER);

        eventsMap = new HashMap<>();
        loadCalendar(LocalDate.now());

        daysList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = daysList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedDate = daysList.getModel().getElementAt(selectedIndex);
                    String event = eventsMap.get(LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    if (event != null) {
                        JOptionPane.showMessageDialog(this, "Events for " + selectedDate + ":\n" + event);
                    } else {
                        String newEvent = JOptionPane.showInputDialog(this, "Enter event for " + selectedDate + ":");
                        if (newEvent != null && !newEvent.isEmpty()) {
                            eventsMap.put(LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), newEvent);
                        }
                    }
                }
            }
        });

        setVisible(true);
    }

    private void loadCalendar(LocalDate date) {
        eventsMap.clear();
        DefaultListModel<String> listModel = (DefaultListModel<String>) daysList.getModel();
        listModel.clear();

        Month month = date.getMonth();
        int year = date.getYear();

        monthYearLabel.setText(month.toString() + " " + year);

        LocalDate firstDay = date.withDayOfMonth(1);
        int lastDayOfMonth = date.lengthOfMonth();
        DayOfWeek dayOfWeek = firstDay.getDayOfWeek();

        int index = 1;
        for (int i = 1; i <= 42; i++) { // 6 rows x 7 days
            if (i < dayOfWeek.getValue() || index > lastDayOfMonth) {
                listModel.addElement("");
            } else {
                LocalDate currentDate = LocalDate.of(year, month, index);
                listModel.addElement(currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                index++;
            }
        }
    }

    
}

public class q10 {
    
}
