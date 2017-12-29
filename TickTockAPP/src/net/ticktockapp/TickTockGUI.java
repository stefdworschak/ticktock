/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Stefan
 */
public class TickTockGUI extends JFrame {
    
    private Timer timer;
    private int speed = 1000;
    private int seconds = 0,minutes=0, hours=0;
    private int duration = 0;
    private JPanel p;
    private JLabel workflowLbl, statusOutputLbl, statusLbl, counterLbl;
    private JComboBox workflowCbo;
    
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, loginBtn, logoutBtn, 
                    adminBtn, monitorBtn;
    
    private String [] types = new String[10];
    private String [] workflows = new String[20];
    private DefaultComboBoxModel cboModel;
    private TickTock tick;
    
    public TickTockGUI (){
        initComponents();       
    }
    
    public void setEventListeners(){
    
        oneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneBtnActionPerformed(evt);
            }
        });
        twoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoBtnActionPerformed(evt);
            }
        });
        threeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeBtnActionPerformed(evt);
            }
        });
        fourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourBtnActionPerformed(evt);
            }
        });
        fiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveBtnActionPerformed(evt);
            }
        });
        sixBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixBtnActionPerformed(evt);
            }
        });
        sevenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenBtnActionPerformed(evt);
            }
        });
        sevenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenBtnActionPerformed(evt);
            }
        });
        eightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightBtnActionPerformed(evt);
            }
        });
        nineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineBtnActionPerformed(evt);
            }
        });
        zeroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroBtnActionPerformed(evt);
            }
        });
        
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });
        
        monitorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorBtnActionPerformed(evt);
            }
        });
    }
    public void addKeyListeners(){
        
                p.addKeyListener(new KeyListener(){
             @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println(e.getKeyCode());
                    switch(e.getKeyCode()){
                        case KeyEvent.VK_1: setStatus(0); break;
                        case KeyEvent.VK_2: setStatus(1); break;
                        case KeyEvent.VK_3: setStatus(2); break;
                        case KeyEvent.VK_4: setStatus(3); break;
                        case KeyEvent.VK_5: setStatus(4); break;
                        case KeyEvent.VK_6: setStatus(5); break;
                        case KeyEvent.VK_7: setStatus(6); break;
                        case KeyEvent.VK_8: setStatus(7); break;
                        case KeyEvent.VK_9: setStatus(8); break;
                        case KeyEvent.VK_0: setStatus(9); break;
                        case KeyEvent.VK_MULTIPLY: setStatus(10); break;
                        case KeyEvent.VK_NUMBER_SIGN: setStatus(10); break;
                        default:break;
                    }
                                        
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
        });
    
    }
    
    public void oneBtnActionPerformed(java.awt.event.ActionEvent evt) {
        startCounter();
        setStatus(0); 
        insertRecord(types[0]);
    }
    public void twoBtnActionPerformed(java.awt.event.ActionEvent evt) {
        startCounter();
        setStatus(1);  
        insertRecord(types[1]);
    }
    public void threeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        startCounter();
        setStatus(2);
        insertRecord(types[2]);
    }
    public void fourBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(3);
        startCounter();
    }
    public void fiveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(4);     
        startCounter();
    }
    public void sixBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(5); 
        startCounter();
    }
    public void sevenBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(6);
        startCounter();
    }
    public void eightBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(7);
        startCounter();
    }
    public void nineBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(8);
        startCounter();
    }
    public void zeroBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(9);
        startCounter();
    }
    public void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        minimizeOnClose();
        startCounter();
        setStatus(10);
        oneBtn.setEnabled(true);
        twoBtn.setEnabled(true);
        threeBtn.setEnabled(true);
        fourBtn.setEnabled(true);
        fiveBtn.setEnabled(true);
        sixBtn.setEnabled(true);
        sevenBtn.setEnabled(true);
        eightBtn.setEnabled(true);
        nineBtn.setEnabled(true);
        zeroBtn.setEnabled(true);
        logoutBtn.setEnabled(true);
        loginBtn.setEnabled(false);
        logoutBtn.setBackground(Color.red);
        loginBtn.setBackground(null);
        insertRecord("Login");
    }
    public void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        timer.stop();
        setStatus(11);
        oneBtn.setEnabled(false);
        twoBtn.setEnabled(false);
        threeBtn.setEnabled(false);
        fourBtn.setEnabled(false);
        fiveBtn.setEnabled(false);
        sixBtn.setEnabled(false);
        sevenBtn.setEnabled(false);
        eightBtn.setEnabled(false);
        nineBtn.setEnabled(false);
        zeroBtn.setEnabled(false);
        logoutBtn.setEnabled(false);
        loginBtn.setEnabled(true);
        logoutBtn.setBackground(null);
        loginBtn.setBackground(Color.green);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insertRecord("Logout");
        counterLbl.setText("00:00:00");
    }
    public void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        TickTockEditorGUI adminGui = new TickTockEditorGUI();
        adminGui.setVisible(true);
        adminGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminGui.setResizable(false);
    }
    public void monitorBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        TickTockMonitorGUI monitorGui = new TickTockMonitorGUI();
        monitorGui.setVisible(true);
        monitorGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monitorGui.setResizable(false);
    }
    
    public void setStatus(int type){
        if(type == 10){
            statusOutputLbl.setText("Logged in");
        } else if(type == 11){
            statusOutputLbl.setText("Logged out");
        } else {
            statusOutputLbl.setText(types[type]);
        }
        p.requestFocus();
    }
    public void startCounter(){
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seconds++;
                if(seconds == 61) {
                    seconds = 0; minutes++;
                }
                if(minutes == 61){
                    minutes = 0; hours++;
                }
                String str = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                counterLbl.setText(str);
            }
        };
        
        try {
            timer.stop();
            duration = (hours*60*60)+(minutes*60)+seconds;
        } catch(Exception e) {
            System.out.println("Calculation Error: "+e.getMessage());
        }
        seconds = 0;
        minutes = 0;
        hours = 0;
        timer = new Timer(speed, taskPerformer);
        timer.start();
    }
    
    public void initComponents(){
        
        tick = new TickTock();
        types[0]="SRT"; types[1]="Tasks"; types[2]="POC"; types[3]="Meeting"; types[4]="Coaching"; 
        types[5]="Training"; types[6]="1-2-1"; types[7]="Sys Outage"; types[8]="Break"; types[9]="Lunch";
        
        workflows[0]="PayOps - Ads - Payments"; workflows[1]="PayOps - Games - Payments"; workflows[2]="PayOps - P2P - Payments"; 
        workflows[3]="PayOps - P4P - Payments"; workflows[4]="PayOps - Donations - Payments"; workflows[5]="PayOps - Payouts - Payments"; 
        workflows[6]="PayOps - Ads - Tasks"; 
        
        workflows[7]="RiskOps - Ads - Review"; workflows[8]="RiskOps - Ads - Appeals"; workflows[9]="RiskOps - Oculus - Review";
        workflows[10]="RiskOps - Marketplace - Review"; workflows[11]="RiskOps - Marketplace - Appeals"; workflows[12]="RiskOps - Games - Review";
        workflows[13]="RiskOps - Games - Appeals"; workflows[14]="RiskOps - P2P - Review"; workflows[15]="RiskOps - P2P - Appeals";
        workflows[16]="RiskOps - P4p - Review"; workflows[17]="RiskOps - Sholay - Review"; workflows[18]="RiskOps - Ads - Tasks";
        
        cboModel = new DefaultComboBoxModel(workflows);
        
        setSize(420, 500);  //set size of JFrame
	setLocation(10, 10);//set Location of JFrame on Screen
	// rest of creation code follows
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        
        p.setFocusable(true);
        addKeyListeners();
        
        
        add(p);
        //x, y, width, height
        
        statusLbl = new JLabel("Status: ");
        statusOutputLbl = new JLabel("<html><strong>Logged Out</strong></html>");
        statusOutputLbl.setHorizontalAlignment(JLabel.CENTER);
        counterLbl = new JLabel("00:00:00");
        statusLbl.setBounds(50,10,120,20);
        statusOutputLbl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        statusOutputLbl.setBounds(140,10,120,20);
        counterLbl.setBounds(270,10,80,20);
        
        workflowLbl = new JLabel("Workflow:");
        workflowLbl.setBounds(50,40,120,20);
        workflowCbo = new JComboBox(cboModel);
        workflowCbo.setBounds(140,40,220,20);
        
        oneBtn = new JButton("<html><center><span style='font-size:8px'>"+types[0]+"</span><br /><span style='font-size:16px'>1</span><center><html>");
        twoBtn = new JButton("<html><center><span style='font-size:8px'>"+types[1]+"</span><br /><span style='font-size:16px'>2</span></center><html>");
        threeBtn = new JButton("<html><center><span style='font-size:8px'>"+types[2]+"</span><br /><span style='font-size:16px'>3</span></center><html>");
        fourBtn = new JButton("<html><center><span style='font-size:8px'>"+types[3]+"</span><br /><span style='font-size:16px'>4</span></center><html>");
        fiveBtn = new JButton("<html><center><span style='font-size:8px'>"+types[4]+"</span><br /><span style='font-size:16px'>5</span></center><html>");
        sixBtn = new JButton("<html><center><span style='font-size:8px'>"+types[5]+"</span><br /><span style='font-size:16px'>6</span></center><html>");
        sevenBtn = new JButton("<html><center><span style='font-size:8px'>"+types[6]+"</span><br /><span style='font-size:16px'>7</span></center><html>");
        eightBtn = new JButton("<html><center><span style='font-size:8px'>"+types[7]+"</span><br /><span style='font-size:16px'>8</span></center><html>");
        nineBtn = new JButton("<html><center><span style='font-size:8px'>"+types[8]+"</span><br /><span style='font-size:16px'>9</span></center><html>");
        zeroBtn = new JButton("<html><center><span style='font-size:8px'>"+types[9]+"</span><br /><span style='font-size:16px'>0</span></center><html>");
        loginBtn = new JButton("<html><center><span style='font-size:8px'>Login</span><br /><span style='font-size:16px'>*</span></center><html>");
        logoutBtn = new JButton("<html><center><span style='font-size:8px'>Logout</span><br /><span style='font-size:16px'>#</span></center><html>");
        adminBtn = new JButton("@");
        monitorBtn = new JButton(":-)");
                
        oneBtn.setBounds(70, 70, 80, 80);
        oneBtn.setMargin(new Insets(0,0,0,0));
        twoBtn.setBounds(160, 70, 80,80);
        twoBtn.setMargin(new Insets(0,0,0,0));
        threeBtn.setBounds(250, 70, 80,80);
        threeBtn.setMargin(new Insets(0,0,0,0));
        
        fourBtn.setBounds(70, 160, 80, 80);
        fourBtn.setMargin(new Insets(0,0,0,0));
        fiveBtn.setBounds(160, 160, 80,80);
        fiveBtn.setMargin(new Insets(0,0,0,0));
        sixBtn.setBounds(250, 160, 80,80);
        sixBtn.setMargin(new Insets(0,0,0,0));
        
        sevenBtn.setBounds(70, 250, 80, 80);
        sevenBtn.setMargin(new Insets(0,0,0,0));
        eightBtn.setBounds(160, 250, 80, 80);
        eightBtn.setMargin(new Insets(0,0,0,0));
        nineBtn.setBounds(250, 250, 80, 80);
        nineBtn.setMargin(new Insets(0,0,0,0));
        
        loginBtn.setBounds(70, 340, 80, 80);
        loginBtn.setMargin(new Insets(0,0,0,0));
        loginBtn.setBackground(Color.green);
        zeroBtn.setBounds(160, 340, 80, 80);
        zeroBtn.setMargin(new Insets(0,0,0,0));
        logoutBtn.setBounds(250, 340, 80, 80);
        logoutBtn.setMargin(new Insets(0,0,0,0));
        
        adminBtn.setBounds(380,435,30,30);
        adminBtn.setMargin(new Insets(0,0,0,0));
        
        monitorBtn.setBounds(345,435,30,30);
        monitorBtn.setMargin(new Insets(0,0,0,0));
        
        p.add(statusLbl);
        p.add(statusOutputLbl);
        p.add(counterLbl);
        p.add(workflowLbl);
        p.add(workflowCbo);
        p.add(oneBtn);
        p.add(twoBtn);
        p.add(threeBtn);
        p.add(fourBtn);
        p.add(fiveBtn);
        p.add(sixBtn);
        p.add(sevenBtn);
        p.add(eightBtn);
        p.add(nineBtn);
        p.add(loginBtn);
        p.add(zeroBtn);
        p.add(logoutBtn);
        p.add(adminBtn);
        p.add(monitorBtn);
        
        oneBtn.setEnabled(false);
        twoBtn.setEnabled(false);
        threeBtn.setEnabled(false);
        fourBtn.setEnabled(false);
        fiveBtn.setEnabled(false);
        sixBtn.setEnabled(false);
        sevenBtn.setEnabled(false);
        eightBtn.setEnabled(false);
        nineBtn.setEnabled(false);
        zeroBtn.setEnabled(false);
        logoutBtn.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setEventListeners();
        p.requestFocus();

    }
    
    public void insertRecord(String code){
        String username = System.getProperty("user.name");
        String workflow = workflowCbo.getItemAt(workflowCbo.getSelectedIndex()).toString();
        String workCode = code;
        String result;
        System.out.println("Test");
        result=tick.insertInto(username, workCode, workflow);
        if(!result.equals("Success")){
            JOptionPane.showMessageDialog(null,"There was an error saving the record");
            //Implement backup logic
        } else {
            
            System.out.println("Result Error: "+result);
        }
    }

    public void minimizeOnClose(){
        
        TickTockGUI win = this;
        win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// <- prevent closing
        win.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                win.setExtendedState(JFrame.ICONIFIED);
            }
        });
        
    }
    
}
