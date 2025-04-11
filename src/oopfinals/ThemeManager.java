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
            Font noto = Font.createFont(Font.TRUETYPE_FONT,
                    ThemeManager.class.getResourceAsStream("/resources/NotoSans-VariableFont_wdth,wght.ttf"))
                    .deriveFont(14f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(noto);
            
            UIManager.put("Table.font", noto);
            UIManager.put("TextField.font", noto);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
