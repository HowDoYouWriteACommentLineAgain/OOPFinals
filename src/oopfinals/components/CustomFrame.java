/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import oopfinals.ThemeManager;

/**
 *
 * @author Admin
 */
public class CustomFrame extends JFrame{
    
    static {
        // Set the Look and Feel globally when the class is loaded
        ThemeManager.setGlobalLookAndFeel();
    }
    public CustomFrame(String text){
        super(text);
        ThemeManager.setGlobalLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        
        setVisible(false);
        allFrames.add(this);
    }
    
    public CustomFrame(String text, int x, int y){
        super(text);
        ThemeManager.setGlobalLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(x,y);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);
        
        setVisible(false);
        allFrames.add(this);
    }
    
    public void addCenter(JPanel panel){
        add(panel, BorderLayout.CENTER);
    }
    
    public void addCenterImage(ImageIcon img){
        JLabel labelImg = new JLabel(img);
        add(labelImg, BorderLayout.CENTER);
    }
    
    public void addTablePane (JScrollPane pane){
        add(pane, BorderLayout.CENTER);
    }
    
    public void addNorth(JPanel panel){
        add(panel, BorderLayout.NORTH);
    }
    
    public void addSouth(JPanel panel){
        add(panel, BorderLayout.SOUTH);
    }
    
    public void addWest(JPanel panel){
        add(panel, BorderLayout.WEST);
    }
    
    public void addWest(JScrollPane pane){
        add(pane, BorderLayout.WEST);
    }
    
    public void setFrameSize(int w, int h){
        setSize(new Dimension(w, h));
    }
    
    private static ArrayList<JFrame> allFrames = new ArrayList<>();
    public static void setAllFramesToInvisible(){
        for (JFrame f : allFrames){
            f.setVisible(false);
        }
    }

}
