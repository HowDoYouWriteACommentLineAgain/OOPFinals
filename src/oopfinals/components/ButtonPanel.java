/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ButtonPanel extends JPanel{
    public ButtonPanel(String... names){
//        setBackground(new Color(160, 160, 160));
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
        for(String name : names){
            JButton button = new CustomButton(name, 1.5);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
            add(button);
            buttons.add(button);
        }
    }
    
    private static ArrayList<JButton> buttons = new ArrayList<JButton>();
    
    public JButton getButtonAt(int x){
        return buttons.get(x);
    }
}
