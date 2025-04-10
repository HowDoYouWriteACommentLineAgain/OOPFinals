/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import oopfinals.components.ButtonPanel;

/**
 *
 * @author Admin
 */
public class LoginFrame extends CustomFrame{

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    private final JLabel usernameLabel = new JLabel("Username: ");
    private final JLabel passwordLabel = new JLabel("Password: ");

    private final JLabel messageLabel = new JLabel("*Username or password cannot be empty");
    
    private final JPanel loginPanel = new JPanel();
    private final ButtonPanel actionsPanel = new ButtonPanel("Login", "Reset");
    
    private final String hardUsername = "k";
    private final String hardPasswordString = "k";
    private final char[] hardPasswordChar = hardPasswordString.toCharArray();
    
    public LoginFrame(String text, JFrame nextFrame) {
        super(text, 600, 300);
        
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        usernameLabel.setHorizontalAlignment(JLabel.LEFT);
        passwordLabel.setHorizontalAlignment(JLabel.LEFT);
        
        usernameLabel.setPreferredSize(new Dimension(200, 100));
        passwordLabel.setPreferredSize(new Dimension(200, 100));
        
        usernameLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        passwordLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        
        usernameField.setPreferredSize(new Dimension(200, 20));
        passwordField.setPreferredSize(new Dimension(200, 20));
        
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        
                
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        
        loginPanel.add(messageLabel);
        messageLabel.setVisible(false);
        
        add(loginPanel);
        addSouth(actionsPanel);
        
        actionsPanel.getButtonAt(0).addActionListener(e->{
            messageLabel.setVisible(false);
            usernameField.setBorder(new LineBorder(null, 1));
            passwordField.setBorder(new LineBorder(null, 1));
            
            if(usernameField.getText().toLowerCase().trim().isEmpty() || passwordField.getPassword().length == 0){
                usernameField.setBorder(new LineBorder(Color.red, 1));
                passwordField.setBorder(new LineBorder(Color.red, 1));
                messageLabel.setVisible(true);
            }
            
            final String usernameInput = usernameField.getText();
            usernameField.setText("");
            final char[] passwordInput = passwordField.getPassword();
            passwordField.setText("");
            
            final boolean usernameMatched = usernameInput.equals(hardUsername);
            boolean passwordMatched = Arrays.equals(passwordInput, hardPasswordChar);
            
            
            if(passwordInput.length != hardPasswordChar.length || usernameMatched == false || passwordMatched == false){
                usernameField.setBorder(new LineBorder(Color.red, 1));
                passwordField.setBorder(new LineBorder(Color.red, 1));
                JOptionPane.showMessageDialog(null, "Invalid Username or Password try again.", "Error",JOptionPane.ERROR_MESSAGE);
                Arrays.fill(passwordInput, '0');                
                return;
                
            }else if((passwordMatched && usernameMatched)){
                
                
                Arrays.fill(passwordInput, '0');
                JOptionPane.showMessageDialog(null, "Welcome User", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                nextFrame.setVisible(true);
                return;
            }

        });
        
        actionsPanel.getButtonByName("Reset").addActionListener(e->{
            usernameField.setBorder(new LineBorder(null, 1));
            passwordField.setBorder(new LineBorder(null, 1));
            usernameField.setText("");
            passwordField.setText("");
        });
        
    }
    
}
