/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;


import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import oopfinals.components.CustomFrame;
import javax.swing.table.DefaultTableModel;
import oopfinals.components.ButtonPanel;

/**
 *
 * @author Admin
 */
public class CRUDOperations extends CustomFrame{

    public CRUDOperations(String text, String CRUDOper ,CustomFrame prevFrame) {
        super(text);
        
        actionPanel = new ButtonPanel(CRUDOper, "Reset", "Go back");
        
        String[] columns = {"Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Saturday", "Sunday"};
        Object[][] data = {
            {"08:30-11:00 AM", null, null, null, null, null,"OOP", null},
            {"11:00-01:30 PM", null, null, null, null, null,"EDM", null},
            {"01:30-04:00 PM", null, null, null, null, null,null, null},
            {"04:00-06:30 PM", null, null, null, null, null,"Ethics", null},
            {"04:00-06:30 PM", null, null, null, null, null,null, null},
        };
        
        DefaultTableModel model = new DefaultTableModel(data,columns);
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        
        add(scrollPane);
        addSouth(actionPanel);
        
        setVisible(false);
        
        actionPanel.selectLastButton().addActionListener(e->{
            setVisible(false);
            prevFrame.setVisible(true);
        });
        
    }

        private final ButtonPanel actionPanel;
        
//        private String CRUDOper;
//        
//        public String setCrudOper(String CrudOper){
//            return CRUDOper = CrudOper;
//        }

    
}
