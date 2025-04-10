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
import oopfinals.components.InputPanels;

/**
 *
 * @author Admin
 */
public class CRUDOperations extends CustomFrame{

    public CRUDOperations(String text, String CRUDOper ,CustomFrame prevFrame) {
        super(text);
        
        ButtonPanel actionPanel = new ButtonPanel(CRUDOper, "Reset", "Go back");
        InputPanels inputs = new InputPanels("Period", "Day", "Subject");
        
        String[] columns = {"Patient Name", "Triage", "Insurance Coverage", "Room No:", "Doctor Assigned"};
        Object[][] data = {
            {"Juan Dela Cruz", "Non-Urgent", "Phil Health", 101, "Dr. Juana Cruz"},
            {"Luigi Mario", "Critical", "United Health Care", 102, "Dr. Grey Anatovich"},
            {"Phil Swift", "Priority", "Phil Health", 204, "Dr Ezio Auditore"},
            {"John Doe", "Non-Urgent", null, 308, "Dr Nathan Drake"},
        };
        
        DefaultTableModel model = new DefaultTableModel(data,columns);
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.setRowHeight(60);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        addTablePane(scrollPane);
        addWest(inputs);
        addSouth(actionPanel);
        
        setVisible(false);
        
        actionPanel.selectLastButton().addActionListener(e->{
            setVisible(false);
            prevFrame.setVisible(true);
        });
        
    }

        
        

    
}
