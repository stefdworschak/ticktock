/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import datechooser.beans.DateChooserCombo;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stefan
 */
public class TickTockGUI extends JFrame {
    
    //Collapse All = Ctrl + Shift + Minus;
    
    private KeyListener k;
    private Timer timer;
    private int speed = 1000;
    private int seconds = 0,minutes=0, hours=0;
    private int duration = 0;
    private JPanel p;
    private JLabel workflowLbl, statusOutputLbl, statusLbl, counterLbl, nameLbl, dateChooserLblOne, dateChooserLblTwo;
    private JComboBox workflowCbo;
    private JTextField nameTxt;
    private JTable tbl;
    private DefaultTableModel mdl;
    private JScrollPane scr;
    private DateChooserCombo dateOneChooser, dateTwoChooser;
    private JInternalFrame iFrame;
    
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, loginBtn, logoutBtn, 
                    adminBtn, monitorBtn, showRecordsBtn, hideRecordsBtn, filterBtn, addExceptionBtn;
    
    private String [] types = new String[10];
    private String [] workflows = new String[19];
    private DefaultComboBoxModel cboModel;
    
    //private String directory = System.getProperty("user.dir");
    //private String url = "jdbc:sqlite:"+directory+"/database.db";
    private TickTock tick;
    
    
    
    public TickTockGUI (){
        initComponents();     
        //System.out.println(directory);
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
        showRecordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRecordsBtnActionPerformed(evt);
            }
        });
        hideRecordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideRecordsBtnActionPerformed(evt);
            }
        });
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterRecordsBtnActionPerformed(evt);
            }
        });
        addExceptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExceptionBtnActionPerformed(evt);
            }
        });
    }
    public void addKeyListeners(){
            
        k = new KeyListener(){
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
        };
        
            p.addKeyListener(k);
    
    }
    public void removeKeyListeners(){
            p.removeKeyListener(k);
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
        insertRecord(types[3]);
    }
    public void fiveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(4);     
        startCounter();
        insertRecord(types[4]);
    }
    public void sixBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(5); 
        startCounter();
        insertRecord(types[5]);
    }
    public void sevenBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(6);
        startCounter();
        insertRecord(types[6]);
    }
    public void eightBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(7);
        startCounter();
        insertRecord(types[7]);
    }
    public void nineBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(8);
        startCounter();
        insertRecord(types[8]);
    }
    public void zeroBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setStatus(9);
        startCounter();
        insertRecord(types[9]);
    }
    public void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        addKeyListeners();
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
        removeKeyListeners();
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
    public void showRecordsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        loadRecords(tbl,"","");
        this.setSize(950, 500);
        showRecordsBtn.setVisible(false);
        hideRecordsBtn.setVisible(true);
    }
    public void hideRecordsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        this.setSize(420, 500);
        showRecordsBtn.setVisible(true);
        hideRecordsBtn.setVisible(false);
    }
    public void filterRecordsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        String fromDate, toDate;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat conv = new SimpleDateFormat("dd/mm/yy HH:mm:ss");
        String fromDateFormat, toDateFormat;
        
        fromDate = dateOneChooser.getText()+ " 00:00:00";
        toDate = dateTwoChooser.getText() + " 23:59:59";
        
        System.out.println(fromDate+" - "+toDate);
        try{
            fromDateFormat = sd.format(conv.parse(fromDate).getTime());    
            toDateFormat = sd.format(conv.parse(toDate).getTime());
            System.out.println(fromDateFormat+" - "+toDateFormat);
            loadRecords(tbl,fromDateFormat,toDateFormat);
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
        //loadRecords(tbl,"","");
        
    }
    public void addExceptionBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        Point onScreen = this.getLocationOnScreen();
        int winHeight = this.getHeight();
        int winWidth = this.getWidth();
        int x = (int) onScreen.getX();
        int y = (int) onScreen.getY();
        System.out.println("x: "+x+", y: "+y);
        TickTockGUI win = this;
        TickTockAddExceptionGUI exceptionGui = new TickTockAddExceptionGUI(x,y,winWidth,winHeight, win);
        exceptionGui.setVisible(true);
        exceptionGui.setTitle("Add an Exception");
        exceptionGui.setResizable(false);
        this.setEnabled(false);
        
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
        mdl = new DefaultTableModel();
        tbl = new JTable();
        
        tick = new TickTock();
        tick.setUrl();
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
        showRecordsBtn = new JButton("Show My Records");
        hideRecordsBtn = new JButton("Hide My Records");
        
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
        
        nameLbl = new JLabel("Logged in as:");
        nameTxt = new JTextField(System.getProperty("user.name"));
        nameLbl.setBounds(10,435,80,20);
        nameTxt.setBounds(90,435,80,20);
        showRecordsBtn.setBounds(180, 435, 150, 20);
        showRecordsBtn.setMargin(new Insets(0,0,0,0));
        hideRecordsBtn.setBounds(180, 435, 150, 20);
        hideRecordsBtn.setMargin(new Insets(0,0,0,0));
        
        dateOneChooser = new DateChooserCombo();
        dateTwoChooser = new DateChooserCombo();
        
        dateChooserLblOne = new JLabel("Display Records from:");
        dateChooserLblTwo = new JLabel("To:");
        filterBtn = new JButton(">");
        addExceptionBtn = new JButton("Add Exception");
        
        dateChooserLblOne.setBounds(430,10,130,20);
        dateOneChooser.setBounds(570,10,80,20);
        dateChooserLblTwo.setBounds(665,10,30,20);
        dateTwoChooser.setBounds(700,10,80,20);

        filterBtn.setBounds(785,10,20,20);
        filterBtn.setMargin(new Insets(0,0,0,0));
        addExceptionBtn.setBounds(830,10,100,20);
        addExceptionBtn.setMargin(new Insets(0,0,0,0));
        
        p.add(dateOneChooser);
        p.add(dateChooserLblOne);
        p.add(dateTwoChooser);
        p.add(dateChooserLblTwo);
        p.add(filterBtn);
        p.add(addExceptionBtn);
        
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
        p.add(nameLbl);
        p.add(nameTxt);
        p.add(showRecordsBtn);
        p.add(hideRecordsBtn);
        adminAccess();
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
        hideRecordsBtn.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setEventListeners();
        p.requestFocus();
        
        scr = new JScrollPane(tbl);
        scr.setBounds(430,35,500,425);
        tbl.setEnabled(false);
        p.add(scr);

    }
    
    public void insertRecord(String code){
        String username = nameTxt.getText();
        String workflow = workflowCbo.getItemAt(workflowCbo.getSelectedIndex()).toString();
        String workCode = code;
        String result;
        System.out.println("Test");
        result=tick.insertInto(username, workCode, workflow);
        if(!result.equals("Success")){
            JOptionPane.showMessageDialog(null,"There was an error saving the record");
            //Implement backup logic
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
    public void loadRecords(JTable tbl, String from, String to){
        
        String username = nameTxt.getText();
        String firstDate = from;
        String lastDate = to;
        String date, time, dateFilter;
        JTable recordTbl = tbl;
        DefaultTableModel recordMdl = new DefaultTableModel();
        ArrayList<ArrayList> result;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        recordMdl.addColumn("Date");
        recordMdl.addColumn("Time");
        recordMdl.addColumn("Work Code");
        recordMdl.addColumn("Workflow");
        
        if(from.equals("") || to.equals("")){
            dateFilter="";
        } else {
            dateFilter = "AND ts >='"+firstDate+"' "
                    + "AND ts <= '"+lastDate+"'";
        }
        System.out.println("SELECT ts, workcode, workflow FROM records WHERE username ='"+username+"' "+dateFilter+" ORDER BY ts DESC;");
        result=tick.select("SELECT ts, workcode, workflow FROM records WHERE username ='"+username+"' "+dateFilter+" ORDER BY ts DESC;");
        for(int i=0; i < result.size();i++){
            ArrayList<String> row = result.get(i);
            date = result.get(i).toString().split(" ")[0].substring(1,11);
            time = result.get(i).toString().split(" ")[1].substring(0,8);
            recordMdl.addRow(populate(date,time,row.get(1),row.get(2)));
            System.out.println(populate(date,time,row.get(1),row.get(2)));
        }
        recordTbl.setModel(recordMdl);
        recordTbl.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        recordTbl.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        recordTbl.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        recordTbl.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        recordTbl.getColumnModel().getColumn(0).setPreferredWidth(100);
        recordTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        recordTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        recordTbl.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        recordTbl.setModel(recordMdl);
        
    }
    
    public String[] populate(String date, String time, String workCode,  String workflow){
        String[] rowData = {date, time, workCode, workflow};
        return rowData;
    }
    
    public void adminAccess(){
       
        String username = System.getProperty("user.name");
        //Implement Query for access
        if(username.equals("sdworschak") || username.equals("Stefan")){
            unhideAdminComponents();
        } else {
            hideAdminComponents();
        }
        
        
    }
    public void unhideAdminComponents(){
        nameTxt.setEnabled(true);
        monitorBtn.setVisible(true);
        adminBtn.setVisible(true);
    }
    public void hideAdminComponents(){
        nameTxt.setEnabled(false);
        monitorBtn.setVisible(false);
        adminBtn.setVisible(false);
    }
}
