/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopfinals;

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
    
    private static ImageIcon icon = new ImageIcon(OOPFinals.class.getResource("/resources/Icon.png"));
    
    private static final CustomFrame landingFrame = new CustomFrame("Welcome");
    private static final LoginFrame loginFrame = new LoginFrame("Login",landingFrame);
    
    private static final CRUDOperations createFrame = new CRUDOperations("Add Event", "Add Event", landingFrame);
    
    public static void main(String[] args) {

        ButtonPanel crudMenu = new ButtonPanel("Add Event", "View Events", "Update Event", "Delete Event", "Go Back");
        
        landingFrame.addCenterImage(ImageUtils.rescale(icon, 100, 100));
        landingFrame.addSouth(crudMenu);
        
        loginFrame.setVisible(false); //change these two before passing
        landingFrame.setVisible(true);
        
        //TODO ADD MORE FRAMES
        
        //CREATE
        //READ
        //UPDATE
        //DELETE
        
        //JDBC CONNECTION
        //TABLE
        
        
        crudMenu.getButtonByName("Go Back").addActionListener(e->{
            loginFrame.setVisible(true);
            landingFrame.setVisible(false);
        });
        
        crudMenu.getButtonAt(0).addActionListener(e->{
            createFrame.setVisible(true);
            landingFrame.setVisible(false);
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