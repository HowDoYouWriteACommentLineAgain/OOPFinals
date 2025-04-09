/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oopfinals.components.ButtonPanel;

/**
 *
 * @author Admin
 */
public class LoginFrame extends CustomFrame{

    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();

    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");

    JLabel messageLabel = new JLabel("Lorem");
    
    JPanel loginPanel = new JPanel();
    ButtonPanel actionsPanel = new ButtonPanel("Login", "Reset");
    
    public LoginFrame(String text, JFrame nextFrame) {
        super(text);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(messageLabel);
        
        add(loginPanel);
        add(actionsPanel);
        
        actionsPanel.getButtonAt(0).addActionListener(e->{
            this.setVisible(false);
            nextFrame.setVisible(true);
        });
        
    }
    
}
