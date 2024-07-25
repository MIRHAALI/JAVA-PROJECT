/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Studentpage extends JFrame implements ActionListener {
    private JButton attendanceButton;
    private JButton quizButton;
    private JButton exitButton;

    public Studentpage() {
        setTitle("Action page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        attendanceButton = new JButton("Check Attendance");
        attendanceButton.addActionListener(this);

        quizButton = new JButton("Start Quiz");
        quizButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(attendanceButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Studentpage();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attendanceButton) {
            // Perform attendance check logic here
            JOptionPane.showMessageDialog(this, "Attendance is 75%");
        } else if (e.getSource() == quizButton) {
            // Start quiz logic here
          new FileReaderWriterGUI();
        } else if (e.getSource() == exitButton) {
            // Exit the program
            System.exit(0);
        }
    }
}
