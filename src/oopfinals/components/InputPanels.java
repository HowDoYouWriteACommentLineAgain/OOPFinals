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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import oopfinals.ThemeManager;

/**
 *
 * @author Admin
 */
public class InputPanels extends JPanel{
    static{
        ThemeManager.setGlobalFont();
    }

    public InputPanels(String... inputs) {
        super();
        ThemeManager.setGlobalLookAndFeel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(LEFT_ALIGNMENT);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(200, 600));
        
        
        for (String i : inputs){
            final JLabel l = new JLabel(i+": ");
            final JTextField tf = new JTextField();
            tf.setName(i);
            
            l.setHorizontalAlignment(JLabel.LEFT);
            l.setMinimumSize(new Dimension(60, 20));
            l.setPreferredSize(new Dimension(60, 30));
            l.setMaximumSize(new Dimension(200, 30));

            
            tf.setMinimumSize(new Dimension(600, 20));
            tf.setPreferredSize(new Dimension(300, 30));
            tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            
            JPanel inputRow = new JPanel();
            inputRow.setMinimumSize(new Dimension(300, 40));
            inputRow.setPreferredSize(new Dimension(300, 65));
            inputRow.setMaximumSize(new Dimension(300, 80));
            inputRow.setLayout(new BoxLayout(inputRow, BoxLayout.X_AXIS));
            inputRow.setAlignmentX(LEFT_ALIGNMENT);
            inputRow.add(l);
            inputRow.add(Box.createRigidArea(new Dimension(10, 0))); // spacer
            inputRow.add(tf);
            
//            l.setBorder(new LineBorder(Color.red,1));            
//            inputRow.setBorder(new LineBorder(Color.red,1));

            
            ALlabels.add(l);
            ALinputs.add(tf);
            add(inputRow);
            inputRow.add(Box.createRigidArea(new Dimension(0, 40))); // spacer

        }
        
        JLabel validationMessage = new JLabel("*All Fields Must Be Populated");
        validationMessage.setVisible(false);
        ALlabels.add(validationMessage);
    }
    
    private final ArrayList<JTextField> ALinputs = new ArrayList<>();
    
    private final ArrayList<JLabel> ALlabels = new ArrayList<>();
    
    public JTextField getTextFieldByName(String name){
        for (JTextField t : ALinputs){
            if(t.getName().equals(name)) return t; 
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
    
    public void clearAll(){
        for (JTextField t: ALinputs){
            t.setText("");
            unsetInvalidValidation();
        }
    }
    
    public JScrollPane getScrollablePanel(){
        JScrollPane scroll = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(300,300));
        return scroll;
    }

    public boolean checkValidation(){
        unsetInvalidValidation();
        int numberOfBlanks = 0;
        for(JTextField tf : ALinputs){
            if(tf.getText().isBlank())
            {
                numberOfBlanks++;
                tf.setBorder(new LineBorder(Color.red, 1));
            }
        }
        
        return (numberOfBlanks == 0) ? true : false;
    }
}
