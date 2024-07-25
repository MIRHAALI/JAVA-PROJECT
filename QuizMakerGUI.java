
package com.mycompany.finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class QuizMakerGUI extends JFrame implements ActionListener {
    private JTextArea questionTextArea;
    private JButton saveButton;

    public QuizMakerGUI() {
        setTitle("Quiz Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionTextArea = new JTextArea(20,50);
        add(new JScrollPane(questionTextArea), BorderLayout.CENTER);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizMakerGUI();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String quizData = questionTextArea.getText();
            if (!quizData.isEmpty()) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("quiz.txt"));
                    writer.write(quizData);
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Quiz saved successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No questions entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

