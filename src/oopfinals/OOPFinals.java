/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopfinals;

import java.awt.Font;
import oopfinals.components.LoginFrame;
import oopfinals.components.CustomFrame;
import oopfinals.components.ButtonPanel;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class OOPFinals {

    /**
     * @param args the command line arguments
     */
    
    private static ImageIcon icon = new ImageIcon(OOPFinals.class.getResource("/resources/Background.png"));
    
    private static final CustomFrame landingFrame = new CustomFrame("Welcome");
    private static final LoginFrame loginFrame = new LoginFrame("Login",landingFrame);
    
    private static final CRUDOperations createFrame = new CRUDOperations("Add Writing System", "Add", landingFrame);
    private static final CRUDOperations readFrame = new CRUDOperations("Read Writing System", "Read", landingFrame);
    private static final CRUDOperations updateFrame = new CRUDOperations("Update Writing System", "Update", landingFrame);
    private static final CRUDOperations deleteFrame = new CRUDOperations("Delete Writing System", "Delete", landingFrame);
    
    public static void main(String[] args) {
        

        ThemeManager.setGlobalLookAndFeel();

        ButtonPanel crudMenu = new ButtonPanel("Create", "Read", "Update", "Delete", "Go Back");
        
        landingFrame.addCenterImage(ImageUtils.rescale(icon, (int)(1280*0.8), (int)(592*0.8)));
        landingFrame.addSouth(crudMenu);
        
        loginFrame.setVisible(true); //change these two before passing
        landingFrame.setVisible(false);
        
        //TODO ADD MORE FRAMES
        
        //CREATE
        //READ
        //UPDATE
        //DELETE
        
        //JDBC CONNECTION
        //TABLE
        
        
        crudMenu.getButtonByName("Go Back").addActionListener(e->{
            CustomFrame.setAllFramesToInvisible();
            loginFrame.setVisible(true);
        });
        
        crudMenu.getButtonByName("Create").addActionListener(e->{
            CustomFrame.setAllFramesToInvisible();
            createFrame.setVisible(true);
            createFrame.loadIntoTable();
        });
        
        crudMenu.getButtonByName("Read").addActionListener(e->{
            CustomFrame.setAllFramesToInvisible();
            readFrame.setVisible(true);
            readFrame.loadIntoTable();            
        });
        
        crudMenu.getButtonByName("Update").addActionListener(e->{
            CustomFrame.setAllFramesToInvisible();
            updateFrame.setVisible(true);
            updateFrame.loadIntoTable();
        });
        
        crudMenu.getButtonByName("Delete").addActionListener(e->{
            CustomFrame.setAllFramesToInvisible();
            deleteFrame.setVisible(true);
            deleteFrame.loadIntoTable();
        });
    }
    
    

    
}
//
//    private static JPanel createPanel(){
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(80, 80));
//        panel.setLayout(new FlowLayout());
//        return panel;
//    }
//