package com.mycompany.finalproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainpage extends JFrame {
    private JButton studentButton;
    private JButton teacherButton;

    public mainpage() {
        setTitle("Main page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        studentButton = new JButton("Start Program");
     

        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                openLoginPage("Student");
            }
        });

     

        setLayout(new FlowLayout());
        add(studentButton);
   
    }

    private void openLoginPage(String userType) {
        LoginFrame loginFrame = new LoginFrame(userType);
        loginFrame.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainpage app = new mainpage();
                app.setVisible(true);
            }
        });
    }
}

class LoginFrame extends JFrame {
    private String userType;

    public LoginFrame(String userType) {
        this.userType = userType;
        setTitle("Login - " + userType);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton loginButton = new JButton("Login as Student");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
            new Studentpage(); }
        });
         JButton loginButton2 = new JButton("Login as teacher");
        loginButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               
            new Teacherpage();
            }
        });

        setLayout(new FlowLayout());
        add(loginButton);
        add(loginButton2);
    }
}
