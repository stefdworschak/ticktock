/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stefan
 */
public class TickTockMonitorGUI extends JFrame {
    
    private JLabel jLabel1, jLabel4, jLabel3;
    private JTable jTbl;
    private JScrollPane scr;
    private JPanel p;
    private DefaultTableCellRenderer centerRenderer;
    
    private TickTock tick = new TickTock();
    
    //String[] cols = {"Col 1", "Col2"};
    //String[][] data = {{"Hello", "World"},{"Hello", "World"}};
    DefaultTableModel model = new DefaultTableModel();
    
    
    public TickTockMonitorGUI (){
        
        initComponents();
    
    }
    
    public void initComponents(){
        
        setSize(750,500);
        setLocation(10,10);
        
        p = new JPanel();
        p.setLayout(null);
        add(p);
        
        String[] cols = {"Col 1", "Col2"};
        String[][] data ={{},{}};
        
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTbl = new JTable();
        createTblModel(jTbl, model);
        jTbl.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        
        scr = new JScrollPane(jTbl);
        scr.setBounds(10,10,730,480);
        jTbl.setEnabled(false);
        p.add(scr);
        
    }
    
    public String [] getCols(){
        String [] result = new String[10];
    
        return result;
    }
    public String [][] queryData(){
        String [][] result = new String[10][5];
    
        return result;
    }
    
    public void createTblModel(JTable table, DefaultTableModel dModel){
        
        JTable tbl= table;
        DefaultTableModel mdl = dModel;
        
        mdl.addColumn("Name");
        mdl.addColumn("Time Changed");
        mdl.addColumn("Work Code");
        mdl.addColumn("Duration");
        mdl.addColumn("Workflow");
        
        mdl.addRow(populate("Stefan","10:00:00","Break",30,"PayOps - Ads - Payements"));
        
        tbl.setModel(mdl);
        
    }
    public String[] populate(String name, String timeChanged, String workCode, int duration, String workflow){
        String[] rowData = {name, timeChanged, workCode, ""+duration, workflow};
        return rowData;
    }
    
}
