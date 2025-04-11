/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopfinals;

import java.sql.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import oopfinals.components.CustomFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

        table.setRowHeight(60);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JTextField tf = new JTextField();
        tf.setEditable(false);
        tf.setFocusable(false);
        DefaultCellEditor editor = new DefaultCellEditor(tf);
        table.setDefaultEditor(Object.class, editor);
        
        JScrollPane scrollPane = new JScrollPane(table);
        addTablePane(scrollPane);
        
        addSouth(actionPanel);
        
//        System.out.println(CRUDOper);
        switch (CRUDOper) {
            case "Add":
                addWest(addInputPanel.getScrollablePanel());
                break;
            case "Update":
                actionPanel.getButtonByName("Reset").setVisible(false);
                addWest(updateInputPanel.getScrollablePanel());
                updateInputPanel.getTextFieldByName("ID").setEnabled(false);
                break;
             //                addWest(deleteInputPanel.getScrollablePanel());
            case "Read":
                actionPanel.getButtonByName(CRUDOper).setVisible(false);
            case "Delete":
                actionPanel.getButtonByName("Reset").setVisible(false);
                break;
            default:
                throw new AssertionError();
        }
        

        
        
        
        setVisible(false);
        
        actionPanel.selectLastButton().addActionListener(e->{
            setVisible(false);
            prevFrame.setVisible(true);
        });
        
        actionPanel.getButtonByName("Reset").addActionListener(e->{
            addInputPanel.clearAll();
            updateInputPanel.clearAll();
        });
        
        actionPanel.getButtonByName(CRUDOper).addActionListener(e->{
            doCRUDOper(CRUDOper);
            loadIntoTable();

        });
        
        table.getSelectionModel().addListSelectionListener(e->{
            if(CRUDOper == "Update"){
                if (!e.getValueIsAdjusting()) {
                    setUpdateInputPanelValues();
                }
            }
            
        });
        
        
    }
    

    
    private JTable table = new JTable();

    
    private InputPanels addInputPanel = new InputPanels(
            "Name", "Category", "Direction", "Status", "Region","Sample"
        );
    
    private InputPanels updateInputPanel = new InputPanels(
            "ID","Name", "Category", "Direction", "Status", "Region","Sample"
        );
    
//    private InputPanels deleteInputPanel = new InputPanels(
//            "ID"
//        );
    
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
            
            if(addInputPanel.checkValidation() == false){
                JOptionPane.showMessageDialog(null, "Please populate all fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            
            ps.setString(1, addInputPanel.getTextFieldByName("Name").getText());
            ps.setString(2, addInputPanel.getTextFieldByName("Category").getText());
            ps.setString(3, addInputPanel.getTextFieldByName("Direction").getText());
            ps.setString(4, addInputPanel.getTextFieldByName("Status").getText());
            ps.setString(5, addInputPanel.getTextFieldByName("Region").getText());
            ps.setString(6, addInputPanel.getTextFieldByName("Sample").getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully added records","Success",JOptionPane.INFORMATION_MESSAGE);
            addInputPanel.clearAll();


        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in adding records","Error",JOptionPane.ERROR_MESSAGE);

        }
        
    }
    
    private void updateFromTable() {
        try (Connection conn = JDBCUtil.getConnection()) {
            String query = 
                    "Update alphabets_and_scripts "
                    + "SET name = ?,"
                    + " category = ?,"
                    + " direction = ?,"
                    + " status = ?,"
                    + " region_of_origin = ? ,"
                    + " sample =? "
                    + "WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            if (updateInputPanel.checkValidation() == false) {
                JOptionPane.showMessageDialog(null, "Please populate all fields", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            

            ps.setString(1, updateInputPanel.getTextFieldByName("Name").getText());
            ps.setString(2, updateInputPanel.getTextFieldByName("Category").getText());
            ps.setString(3, updateInputPanel.getTextFieldByName("Direction").getText());
            ps.setString(4, updateInputPanel.getTextFieldByName("Status").getText());
            ps.setString(5, updateInputPanel.getTextFieldByName("Region").getText());
            ps.setString(6, updateInputPanel.getTextFieldByName("Sample").getText());
            ps.setString(7, updateInputPanel.getTextFieldByName("ID").getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated record", "Success", JOptionPane.INFORMATION_MESSAGE);
            updateInputPanel.clearAll();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in adding record", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    private void deleteFromTable(){
        int selectedRowNum = table.getSelectedRow();
        
        if(selectedRowNum == -1){
            JOptionPane.showMessageDialog(null, "Please select a row to delete", "Error Selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        TableModel tableModel = table.getModel();
        String rowId = String.valueOf(tableModel.getValueAt(selectedRowNum, 0));
        String rowName = String.valueOf(tableModel.getValueAt(selectedRowNum, 1));
        
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete: " + rowName+"?");
        
        
//        System.out.println(confirmation);
        if(confirmation == JOptionPane.OK_OPTION)
        {
            try (Connection conn = JDBCUtil.getConnection()) {
                String query = "DELETE from alphabets_and_scripts where id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, rowId);

                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
    }
    
    private boolean setUpdateInputPanelValues(){
        int selectedRowNum = table.getSelectedRow();
        if (selectedRowNum == -1) {
            return false;
        }

        TableModel tableModel = table.getModel();
        String ID = String.valueOf(tableModel.getValueAt(selectedRowNum, 0));
        String Name = String.valueOf(tableModel.getValueAt(selectedRowNum, 1));
        String Category = String.valueOf(tableModel.getValueAt(selectedRowNum, 2));
        String Direction = String.valueOf(tableModel.getValueAt(selectedRowNum, 3));
        String Status = String.valueOf(tableModel.getValueAt(selectedRowNum, 4));
        String Region = String.valueOf(tableModel.getValueAt(selectedRowNum, 5));
        String Sample = String.valueOf(tableModel.getValueAt(selectedRowNum, 6));
        
        
        updateInputPanel.getTextFieldByName("ID").setText(ID);
        updateInputPanel.getTextFieldByName("Name").setText(Name);
        updateInputPanel.getTextFieldByName("Category").setText(Category);
        updateInputPanel.getTextFieldByName("Direction").setText(Direction);
        updateInputPanel.getTextFieldByName("Status").setText(Status);
        updateInputPanel.getTextFieldByName("Region").setText(Region);
        updateInputPanel.getTextFieldByName("Sample").setText(Sample);
        
        return true;
    }
    
    private void doCRUDOper(String CRUDOper){
        switch (CRUDOper) {
            case "Add":
                addIntoTable();
                break;
            case "Delete":
                deleteFromTable();
                break;
            case "Update":
                updateFromTable();
            case "Read":
                break;
            default:
                throw new AssertionError();
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
