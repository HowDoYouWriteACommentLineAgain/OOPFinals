/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.awt.BorderLayout;
import javax.swing.JFrame;
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
    
//    public CustomFrame(String text, JPanel... panels){
//        super(text);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(600,600);
//        setLayout(new BorderLayout(10,10));
//        setLocationRelativeTo(null);
//        
//        for(JPanel panel : panels){
//            add(panel, BorderLayout.NORTH);
//            //... got stuck on implementtion
//        }
//    }
}
