/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class CustomButton extends JButton {
    public CustomButton(String text){
        super(text);
        setPreferredSize(new Dimension(100,40));
    }
}
