/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class JDBCUtil {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPFinals", "root", "");
        }catch(Exception e){
            System.out.println("Error connecting: ");
            e.printStackTrace();
            return null;
        }
    }
}
