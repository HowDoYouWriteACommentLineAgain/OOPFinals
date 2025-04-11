/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import javax.swing.UIManager;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
/**
 *
 * @author Admin
 */
public class ThemeManager {
    public static void setGlobalLookAndFeel() {
        try{
            UIManager.setLookAndFeel(new LunaLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void setGlobalFont(){
        
        try {

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            String[] fontNames = ge.getAvailableFontFamilyNames();
            
            Font font = Font.createFont(Font.TRUETYPE_FONT,
                    ThemeManager.class.getResourceAsStream("/resources/DejaVuSans.ttf"))
//                    ThemeManager.class.getResourceAsStream("/resources/DroidSans.ttf"))
                    .deriveFont(14f);
            
            UIManager.put("Table.font", font);
            UIManager.put("TextField.font", font);

            System.out.println("Using: " + font.getName());

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//            Font noto = Font.createFont(Font.TRUETYPE_FONT,
//                    ThemeManager.class.getResourceAsStream("/resources/NotoSans-VariableFont_wdth,wght.ttf"))
//                    .deriveFont(14f);