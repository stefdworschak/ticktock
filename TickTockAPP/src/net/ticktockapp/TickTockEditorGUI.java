/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Stefan
 */
public class TickTockEditorGUI extends JFrame {
    
    //private String directory = System.getProperty("user.dir");
    //private String url = "jdbc:sqlite:"+directory+"/database.db";
    private TickTock tick;
    private JPanel p;
    private JComboBox statementType;
    private JLabel statementTypeLbl,statementLbl,returnLbl;
    private JTextArea statementArea, resultArea;
    private JButton execBtn, resetBtn, backBtn;
    private JScrollPane stmtScr, resScr;
    private String[] stmtArr = {"WILDCARD","CREATE TABLE", "INSERT", "UPDATE","SELECT", "PRAGMA","TEST CONNECTION"};
    private DefaultComboBoxModel cboModel = new DefaultComboBoxModel(stmtArr);
    
    TickTockEditorGUI(){
        //PRAGMA table_info([tablename]); <-- will get you table schema!!
        initComponents();
    }

    public void initComponents(){
        
        tick = new TickTock();
        tick.setUrl();
        
        setSize(750,600);
        setLocation(50,50);
        
        p = new JPanel();
        p.setLayout(null);
        
        add(p);
        
        statementType = new JComboBox(cboModel);
        statementTypeLbl = new JLabel("Statement Type:");
        statementLbl = new JLabel("SQL Statement");
        returnLbl = new JLabel("Result");
        statementArea = new JTextArea(); 
        resultArea = new JTextArea();
        execBtn = new JButton("Execute");
        resetBtn = new JButton("Reset");
        backBtn = new JButton("<");
        
        statementTypeLbl.setBounds(20,10,100,20);
        statementType.setBounds(130,10,200,20);
        execBtn.setBounds(20,310,80,30);
        execBtn.setMargin(new Insets(0,0,0,0));
        resetBtn.setBounds(340,10,60,20);
        resetBtn.setMargin(new Insets(0,0,0,0));
        backBtn.setBounds(400,10,20,20);
        backBtn.setMargin(new Insets(0,0,0,0));
        
        //statementArea.setBounds(20,40,200,300);
        stmtScr = new JScrollPane(statementArea);
        stmtScr.setBounds(20,40,710,260);
        stmtScr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        //resultArea.setBounds(20,40,200,300);
        resScr = new JScrollPane(resultArea);
        resScr.setBounds(20,350,710,200);
        resScr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        resScr.setEnabled(false);
        
        p.add(statementTypeLbl);
        p.add(statementType);
        p.add(execBtn);
        p.add(resetBtn);
        p.add(backBtn);
        p.add(stmtScr);
        
        p.add(resScr);
        setEventListeners();
    
    }
    
    public void setEventListeners(){
        execBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execBtnActionPerformed(evt);
            }
        });
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        
    }
    
    public void execBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        String selectedCbo = statementType.getItemAt(statementType.getSelectedIndex()).toString();
        String result = "";
        ArrayList <ArrayList> selectResult;
        
        if(!statementArea.getText().contains(selectedCbo) && !selectedCbo.equals("TEST CONNECTION") && !selectedCbo.equals("WILDCARD")){
            JOptionPane.showMessageDialog(null, "The entered statement does not match the selected Statement Type");
        } else {
            //{"CREATE DATABASE","CREATE TABLE", "INSERT", "UPDATE","SELECT"};
            if(selectedCbo.equals("CREATE TABLE")){
                result=tick.createTable(statementArea.getText());
                resultArea.setText(result);
            } else if(selectedCbo.equals("INSERT") || selectedCbo.equals("UPDATE")){
                result=tick.insert(statementArea.getText());
                resultArea.setText(result);
            } else if(selectedCbo.equals("SELECT") || selectedCbo.equals("WILDCARD")){
                selectResult=tick.select(statementArea.getText());
                String outputStr = "";
                for(int i=0; i < selectResult.size();i++){
                    ArrayList<String> arr = (ArrayList<String>) selectResult.get(i);
                    String temp = "";
                    for(int j = 0; j <arr.size(); j++){
                        if(j == 0) {
                            temp += arr.get(j);
                        } else {
                            temp += ", "+arr.get(j);
                        }
                    }
                    outputStr += arr+"\n";
                }
                resultArea.setText(outputStr);
            } else if(selectedCbo.equals("TEST CONNECTION")){
                result=tick.testConnection();
                resultArea.setText(result);
            } else {
                JOptionPane.showMessageDialog(null, "This feature is currently not available.");
            }
            
        }
    }
    public void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
    
    }
    public void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        
        String username = System.getProperty("user.name");
        TickTockGUI gui = new TickTockGUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Aux Codes App - "+username);
        gui.setResizable(false);
    }
    
}
