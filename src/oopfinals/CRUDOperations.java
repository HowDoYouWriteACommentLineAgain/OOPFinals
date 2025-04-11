/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.sql.*;
import javax.swing.JOptionPane;
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
    
    static{
        ThemeManager.setGlobalFont();
    };

    public CRUDOperations(String frameName, String CRUDOper ,CustomFrame prevFrame) {
        super(frameName);
        
        ButtonPanel actionPanel = new ButtonPanel(CRUDOper, "Reset", "Go back");
        
        loadIntoTable();
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.setRowHeight(60);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        addTablePane(scrollPane);
        System.out.println(CRUDOper);
        switch (CRUDOper) {
            case "Add":
                addWest(addInputPanel.getScrollablePanel());
                break;
            case "Update":
                addWest(updateInputPanel.getScrollablePanel());
                break;
            case "Delete":
                addWest(deleteInputPanel.getScrollablePanel());
            case "Read":
                break;
            default:
                throw new AssertionError();
        }
        

        
        addSouth(actionPanel);
        
        setVisible(false);
        
        actionPanel.selectLastButton().addActionListener(e->{
            setVisible(false);
            prevFrame.setVisible(true);
        });
        
        actionPanel.getButtonByName("Reset").addActionListener(e->{
            addInputPanel.clearAll();
        });
        
        actionPanel.getButtonByName(CRUDOper).addActionListener(e->{
            addIntoTable();
            addInputPanel.clearAll();
            loadIntoTable();

        });
        
    }
    

    
    private JTable table = new JTable();

    
    private InputPanels addInputPanel = new InputPanels(
            "Name", "Category", "Direction", "Status", "Region","Sample"
        );
    
    private InputPanels updateInputPanel = new InputPanels(
            "ID","Name", "Category", "Direction", "Status", "Region","Sample"
        );
    
    private InputPanels deleteInputPanel = new InputPanels(
            "ID"
        );
    
    public void loadIntoTable(){
        try(Connection conn = JDBCUtil.getConnection()){
            String query = "SELECT * FROM alphabets_and_scripts";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel model = 
                new DefaultTableModel(new String[] {
                    "id","name", "category", "direction", "status", "region_of_origin","sample"
                },0);
            
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getString("direction"),
                    rs.getString("status"),
                    rs.getString("region_of_origin"),
                    rs.getString("sample")
                });
            }
            table.setModel(model);

            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void addIntoTable(){
        try(Connection conn = JDBCUtil.getConnection()){
            String query = "Insert into alphabets_and_scripts (name, category, direction, status, region_of_origin, sample) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, addInputPanel.getTextFieldByName("Name").getText());
            ps.setString(2, addInputPanel.getTextFieldByName("Category").getText());
            ps.setString(3, addInputPanel.getTextFieldByName("Direction").getText());
            ps.setString(4, addInputPanel.getTextFieldByName("Status").getText());
            ps.setString(5, addInputPanel.getTextFieldByName("Region").getText());
            ps.setString(6, addInputPanel.getTextFieldByName("Sample").getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully added records","Success",JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in adding records","Error",JOptionPane.ERROR_MESSAGE);

        }
        
    }
        
}














/*
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

*/
