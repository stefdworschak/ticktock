/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import datechooser.beans.DateChooserCombo;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Stefan
 */
public class TickTockAddExceptionGUI extends JFrame {
    
    private JFrame oldForm;
    private int x,y, height,width, setHeight, setWidth;
    private JPanel p;
    private JLabel workcodeLbl, workflowLbl, dateLbl, timeLbl;
    private DateChooserCombo dateChooser;
    private JTextField timeTxt;
    private JComboBox workflowCbo, workcodeCbo;
    private JButton addExceptionBtn;
    private DefaultComboBoxModel workflowMdl, workcodeMdl;
    
    private String [] types = new String[12];
    private String [] workflows = new String[19];
    
    TickTockAddExceptionGUI (int x, int y, int height, int width, JFrame oldForm){
        this.oldForm = oldForm;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        initComponents();
    }
    
    public void initComponents(){
        
        types[0]="SRT"; types[1]="Tasks"; types[2]="POC"; types[3]="Meeting"; types[4]="Coaching"; 
        types[5]="Training"; types[6]="1-2-1"; types[7]="Sys Outage"; types[8]="Break"; types[9]="Lunch";
        types[10]="Login";types[11]="Logout";
        
        workflows[0]="PayOps - Ads - Payments"; workflows[1]="PayOps - Games - Payments"; workflows[2]="PayOps - P2P - Payments"; 
        workflows[3]="PayOps - P4P - Payments"; workflows[4]="PayOps - Donations - Payments"; workflows[5]="PayOps - Payouts - Payments"; 
        workflows[6]="PayOps - Ads - Tasks"; 
        
        workflows[7]="RiskOps - Ads - Review"; workflows[8]="RiskOps - Ads - Appeals"; workflows[9]="RiskOps - Oculus - Review";
        workflows[10]="RiskOps - Marketplace - Review"; workflows[11]="RiskOps - Marketplace - Appeals"; workflows[12]="RiskOps - Games - Review";
        workflows[13]="RiskOps - Games - Appeals"; workflows[14]="RiskOps - P2P - Review"; workflows[15]="RiskOps - P2P - Appeals";
        workflows[16]="RiskOps - P4p - Review"; workflows[17]="RiskOps - Sholay - Review"; workflows[18]="RiskOps - Ads - Tasks";
        
        setSize(530,130);
        setHeight= (int)(height-530)/2;
        setWidth= (int)(width-130)/2;
        setLocation(x+setHeight,y+setWidth);
        
        p = new JPanel();
        p.setLayout(null);
        add(p);
        
        workflowLbl = new JLabel("Workflow:");
        workcodeLbl = new JLabel("Work Code:");
        workflowMdl = new DefaultComboBoxModel(workflows);
        workcodeMdl = new DefaultComboBoxModel(types);
        workflowCbo = new JComboBox(workflowMdl);
        workcodeCbo = new JComboBox(workcodeMdl);
        
        workflowLbl.setBounds(10,10,70,20);
        workcodeLbl.setBounds(10,35,70,20);
        workflowCbo.setBounds(90,10,230,20);
        workcodeCbo.setBounds(90,35,230,20);
        
        dateLbl = new JLabel("Date:");
        timeLbl = new JLabel("Time:");
        dateChooser = new DateChooserCombo();
        timeTxt = new JTextField("HH:MM:SS");
        addExceptionBtn = new JButton("Add Exception");
        
        dateLbl.setBounds(360,10,70,20);
        dateChooser.setBounds(410,10,100,20);
        timeLbl.setBounds(360,35,70,20);
        timeTxt.setBounds(410,35,100,20);
        addExceptionBtn.setBounds(410,60,100,30);
        addExceptionBtn.setMargin(new Insets(0,0,0,0));
        
        p.add(workflowLbl);
        p.add(workcodeLbl);
        p.add(workflowCbo);
        p.add(workcodeCbo);
        
        p.add(dateLbl);
        p.add(dateChooser);
        p.add(timeLbl);
        p.add(timeTxt);
        p.add(addExceptionBtn);
        addEventListener();
    
    }
    
    public void addEventListener(){
        
        JFrame win = this;
        addExitListener(win);
        
    }
    
    public void addExitListener(JFrame window){
        JFrame win = window;
        
        WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
           oldForm.setEnabled(true);         
           win.dispose();
        }
    };
    win.addWindowListener(exitListener);
    
    }
}
