/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopfinals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class OOPFinals {

    /**
     * @param args the command line arguments
     */
    
    static ImageIcon icon = new ImageIcon(OOPFinals.class.getResource("/resources/Icon.png"));
    
    public static void main(String[] args) {
        JFrame landingFrame = createJFrame();

        JPanel buttonPanel = createButtonPanels("Create", "Add", "Update", "Delete");
        JLabel imageHolder = new JLabel(rescale(icon, 100, 100));
        
        landingFrame.add(imageHolder, BorderLayout.CENTER);
        landingFrame.add(buttonPanel, BorderLayout.SOUTH);
        landingFrame.setVisible(true);
    }
    
    private static JFrame createJFrame(){
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout(10,10));
        frame.setLocationRelativeTo(null);
        
        return frame;
    }
    
    private static JButton createJButton(String text){
        JButton button = new JButton();
        button.setSize(new Dimension(600,600));
        button.setPreferredSize(new Dimension(100, 40));
        button.setText(text);
        
        return button;
    }
    
    private static JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(80, 80));
        panel.setLayout(new FlowLayout());
        return panel;
    }
    
    private static JPanel createButtonPanels(String... names){
        JPanel panel = createPanel();
        panel.setBackground(new Color(160, 160, 160));
        for(String name : names){
            JButton button = createJButton(name);
            panel.add(button);
        }
        return panel;
    }
    
    private static ImageIcon rescale(ImageIcon img, int width, int height){
        Image scaledImg = img.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
        
    }
}
