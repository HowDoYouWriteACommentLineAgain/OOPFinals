/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ButtonPanel extends JPanel{
    public ButtonPanel(String... names){
        setBackground(new Color(160, 160, 160));
        setLayout(new FlowLayout());
        
        for(String name : names){
            JButton button = new CustomButton(name);
            add(button);
        }
    }
    
}
