/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class ImageUtils {
    public static ImageIcon rescale(ImageIcon img, int width, int height){
        Image scaledImage = img.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
