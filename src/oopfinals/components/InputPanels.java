/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals.components;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class InputPanels extends JPanel{

    public InputPanels(String... inputs) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBorder(new EmptyBorder(10, 30, 10, 30));
        setPreferredSize(new Dimension(280, 200));
        
        
        for (String i : inputs){
            final JLabel l = new JLabel(i+": ");
            final JTextField tf = new JTextField();
            
            l.setHorizontalAlignment(JLabel.LEFT);
            l.setMinimumSize(new Dimension(60, 40));
            l.setPreferredSize(new Dimension(60, 40));
            l.setMaximumSize(new Dimension(200, 40));
            l.setBorder(new LineBorder(Color.red,1));
            
            tf.setMinimumSize(new Dimension(600, 40));
            l.setPreferredSize(new Dimension(800, 40));
            tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            
            JPanel inputRow = new JPanel();
            inputRow.setLayout(new BoxLayout(inputRow, BoxLayout.X_AXIS));
            inputRow.setAlignmentX(LEFT_ALIGNMENT);
            inputRow.add(l);
            inputRow.add(Box.createRigidArea(new Dimension(10, 0))); // spacer
            inputRow.add(tf);
            
            inputRow.setBorder(new LineBorder(Color.red,1));

            
            ALlabels.add(l);
            ALinputs.add(tf);
            add(inputRow);
            inputRow.add(Box.createRigidArea(new Dimension(0, 100))); // spacer

        }
        
        JLabel validationMessage = new JLabel("*All Fields Must Be Populated");
        validationMessage.setVisible(false);
        ALlabels.add(validationMessage);
    }
    
    private final ArrayList<JTextField> ALinputs = new ArrayList<>();
    
    private final ArrayList<JLabel> ALlabels = new ArrayList<>();
    
    public JTextField getTextFieldByName(String name){
        for (JTextField t : ALinputs){
            if(t.getText().equals(name)) return t; 
        }
        
        return null;
    }
    
    public void setInvalidValidation(){
        for(JTextField t : ALinputs){
            t.setBorder(new LineBorder(Color.red, 1));
        }
        
        ALlabels.get(ALlabels.size()-1).setVisible(true);
    }
    
    public void unsetInvalidValidation() {
        for (JTextField t : ALinputs) {
            t.setBorder(new LineBorder(Color.black, 1));
        }

        ALlabels.get(ALlabels.size() - 1).setVisible(false);
    }
}
