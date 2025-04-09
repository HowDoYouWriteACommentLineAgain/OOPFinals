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

        JPanel buttonPanel = new ButtonPanel("Add Event", "View Events", "Update Event", "Delete Event");
        JLabel imageHolder = new JLabel(ImageUtils.rescale(icon, 100, 100));
        
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
    
    private static JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(80, 80));
        panel.setLayout(new FlowLayout());
        return panel;
    }
    
}
