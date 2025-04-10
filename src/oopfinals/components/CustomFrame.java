/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class CustomFrame extends JFrame{
    public CustomFrame(String text){
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
    }
    
    public CustomFrame(String text, int x, int y){
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(x,y);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
    }
    
    public void addCenter(JPanel panel){
        add(panel, BorderLayout.CENTER);
    }
    
    public void addCenterImage(ImageIcon img){
        JLabel labelImg = new JLabel(img);
        add(labelImg, BorderLayout.CENTER);
    }
    
    public void addNorth(JPanel panel){
        add(panel, BorderLayout.NORTH);
    }
    
    public void addSouth(JPanel panel){
        add(panel, BorderLayout.SOUTH);
    }

}
