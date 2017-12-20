/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Stefan
 */
public class TickTockGUI extends JFrame {
    private JPanel p;
    private JLabel workflowLbl, statusOutputLbl, statusLbl;
    private JComboBox workflowCbo;
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, loginBtn, logoutBtn;
    
    private String [] types = new String[10];
    
    private TickTock tick;
    
    public TickTockGUI (){
        types[0]="SRT"; types[1]="Tasks"; types[2]="POC"; types[3]="Meeting"; types[4]="Coaching"; 
        types[5]="Training"; types[6]="1-2-1"; types[7]="Sys Outage"; types[8]="Break"; types[9]="Lunch";
        tick = new TickTock();
        String createStmt = "CREATE TABLE IF NOT EXISTS users (\n"
                +"userid INT AUTO_INCREMENT NOT NULL PRIMARY KEY,\n"
                +"username VARCHAR(20) NOT NULL,\n"
                +"first_name VARCHAR(32),\n"
                +"last_name VARCHAR(32)"
                +")";
        tick.createTable(createStmt);
        
        setSize(420, 500);  //set size of JFrame
	setLocation(10, 10);//set Location of JFrame on Screen
	// rest of creation code follows
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        
        p.setFocusable(true);
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
        
        
        add(p);
        //x, y, width, height
        
        statusLbl = new JLabel("Status: ");
        statusOutputLbl = new JLabel("<html><div style='text-align:center;width:100%;'>&nbsp;<strong>Logged Out</strong></div></html>");
        statusLbl.setBounds(50,10,120,20);
        statusOutputLbl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        statusOutputLbl.setBounds(140,10,220,20);
        
        workflowLbl = new JLabel("Workflow:");
        workflowLbl.setBounds(50,40,120,20);
        workflowCbo = new JComboBox();
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
        logoutBtn.setBackground(Color.red);
        
        p.add(statusLbl);
        p.add(statusOutputLbl);
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
        
        setEventListeners();
        p.requestFocus();
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
        
    }
    
    public void oneBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(0); 
    }
    public void twoBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(1);   
    }
    public void threeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(2);
        
    }
    public void fourBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(3);
        
    }
    public void fiveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(4);     
    }
    public void sixBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(5); 
    }
    public void sevenBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(6);
    }
    public void eightBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(7);
        
    }
    public void nineBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(8);
        
    }
    public void zeroBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(9);
        
    }
    public void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(10);
    }
    public void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(11);
        System.exit(0);
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
    
}
