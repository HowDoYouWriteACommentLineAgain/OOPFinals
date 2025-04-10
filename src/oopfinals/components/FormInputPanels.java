/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class FormInputPanels extends JPanel{

    public FormInputPanels(String... inputs) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(10, 30, 10, 30));
        
        
        for (String i : inputs){
            final JLabel l = new JLabel(i+": ");
            final JTextField tf = new JTextField();
            
            l.setHorizontalAlignment(JLabel.LEFT);
            l.setPreferredSize(new Dimension(200, 100));
            l.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            
            tf.setPreferredSize(new Dimension(200, 20));
            tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            
            labels.add(l);
            inputs.
        }
        
    }
    
    private final ArrayList<JTextField> inputs = new ArrayList<>();
    
    private final ArrayList<JLabel> labels = new ArrayList<>();
}
