/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stefan
 */
public class TickTockMonitorGUI extends JFrame {
    
    //private String directory = System.getProperty("user.dir");
    //private String url = "jdbc:sqlite:"+directory+"/database.db";
    private TickTock tick;
    
    private JLabel jLabel1, jLabel4, jLabel3;
    private JTable jTbl;
    private JScrollPane scr;
    private JPanel p;
    private DefaultTableCellRenderer centerRenderer;
    private Timer timer;
    
    //String[] cols = {"Col 1", "Col2"};
    //String[][] data = {{"Hello", "World"},{"Hello", "World"}};
    DefaultTableModel model = new DefaultTableModel();
    
    
    public TickTockMonitorGUI (){
        
        initComponents();
    
    }
    
    public void initComponents(){
        
        tick = new TickTock();
        tick.setUrl();
        setSize(750,500);
        setLocation(10,10);
        
        p = new JPanel();
        p.setLayout(null);
        add(p);
        
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTbl = new JTable();
        createTblModel(jTbl, model);
        
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
        ArrayList <ArrayList> records;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss.S");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String date, time, dateFormat, timeFormat, durationFormat;
        Date now, second, third;
        
        Long duration;
        
        mdl.addColumn("Date");
        mdl.addColumn("Name");
        mdl.addColumn("Last Changed");
        mdl.addColumn("Work Code");
        mdl.addColumn("Duration");
        mdl.addColumn("Workflow");
        
        records = tick.select("SELECT r1.username, r1.workcode, r1.workflow, r1.ts FROM records AS r1 " 
                            +"INNER JOIN (SELECT  username, MAX(ts) AS ts FROM records GROUP BY username) r2 " 
                            +"ON r1.username = r2.username AND r1.ts = r2.ts WHERE r1.workcode != 'Logout' ORDER BY r1.ts DESC;");
        
        for(int i = 0; i < records.size(); i++){
            ArrayList <String> row = (ArrayList<String>) records.get(i);
            time = row.get(3).split(" ")[1];
            date = row.get(3).split(" ")[0];
           
            
            //System.out.println("1:"+time);
            
            try{
                
                now = new Date();
                duration = now.getTime()-(sf.parse(row.get(3)).getTime());
                System.out.println(duration);
                durationFormat = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration),
                                TimeUnit.MILLISECONDS.toMinutes(duration) % TimeUnit.HOURS.toMinutes(1),
                                TimeUnit.MILLISECONDS.toSeconds(duration) % TimeUnit.MINUTES.toSeconds(1));
               //durationFormat = st.format(duration);
                
                dateFormat = sd.format(sd.parse(date));
                timeFormat = st.format(st.parse(time));
                //System.out.println("2:"+sf.format(now));
                //System.out.println("3:"+sf.format(sd.parse(date)+" "+st.parse(time)));
                //System.out.println("3: "+sf.format(sd.parse(date)+" "+st.parse(time)));
                //System.out.println("3:"+dateFormat+" "+timeFormat);
                mdl.addRow(populate(date,row.get(0),time,row.get(1),durationFormat,row.get(2)));
            } catch(ParseException e){
                //System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, populate("-",row.get(0),"-",row.get(1),"0",row.get(2)));
                mdl.addRow(populate("-",row.get(0),"-",row.get(1),"0",row.get(2)));
            }
            
        }
        
        
        
        tbl.setModel(mdl);
        
        jTbl.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        jTbl.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        
        startCounter();
        
    }
    public String[] populate(String date, String name, String timeChanged, String workCode, String duration, String workflow){
        String[] rowData = {date, name, timeChanged, workCode, ""+duration, workflow};
        return rowData;
    }
    
    public void startCounter(){
        int speed = 10000;
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createTblModel(jTbl, new DefaultTableModel());
                //System.out.println("now");
            }
        };
        
        try {
            timer.stop();
        } catch(Exception e) {
            System.out.println("Calculation Error: "+e.getMessage());
        }
        timer = new Timer(speed, taskPerformer);
        timer.start();        
    }
    
}
