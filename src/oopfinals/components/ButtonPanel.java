/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;


import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ButtonPanel extends JPanel{
    public ButtonPanel(String... names){
            
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
        for(String name : names){
            JButton button = new CustomButton(name, 1.2);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
            add(button);
            buttons.add(button);
        }
    }
    
    private final ArrayList<JButton> buttons = new ArrayList<>();
    
    public int getLastItemIndex(){
        return buttons.size()-1;
    }
    
    public JButton selectLastButton(){
        return buttons.get(getLastItemIndex());
    }
    
    public JButton getButtonAt(int x){
//        System.out.println(buttons.indexOf(x) + " is " +buttons.get(x).getText());
        return buttons.get(x);
    }
    
    public JButton getButtonByName(String name){
        for (JButton b : buttons){
            if (b.getText().equals(name)) return b;
        }
        
        return null;
    }
}
