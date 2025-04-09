/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class CustomButton extends JButton {
    public static Dimension defaultSize = new Dimension(140, 80);
    
    public CustomButton(String text){
        super(text);
        setPreferredSize(defaultSize);
    }
    
    public CustomButton(String text, double scale){
        super(text);
        setPreferredSize(scaleDefault(scale));
    }
    
    public static Dimension scaleDefault(double scale){
        return new Dimension(
                (int)(defaultSize.width*scale),
                (int)(defaultSize.height*scale)
        );
    }
}
