package com.mycompany.finalproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileReaderWriterGUI extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton readButton;
    private JButton writeButton;
    private File selectedFile;

    public FileReaderWriterGUI() {
        setTitle("File Reader/Writer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea(10,50);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        readButton = new JButton("Start Quiz");
        readButton.addActionListener(this);

        writeButton = new JButton("Submit quiz");
        writeButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(writeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileReaderWriterGUI();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == readButton) {
            selectedFile = new File("quiz.txt"); // Change the file name as needed
            if (selectedFile.exists() && selectedFile.isFile()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                    String line;
                    textArea.setText("");
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == writeButton) {
            if (selectedFile != null) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile, true));
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Data written successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No file selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
