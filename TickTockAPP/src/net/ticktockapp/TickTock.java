/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Stefan
 */
public class TickTock {
   private String directory = System.getProperty("user.dir");
   private String url = "jdbc:sqlite:"+directory+"/database.db";
   
   private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
   public TickTock(){
        
   }
   public String createTable(String CreateTblStatement) {
        // SQLite connection string
        String sql = CreateTblStatement; 
        String result = "";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            result = "Table(s) created successfully.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = e.getMessage();
        }
        return result;
    }
   public String insert(String insertStatement){
       
       String sql = insertStatement;
       String result = "";
    
       try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            result = "Insert(s) successful.";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = e.getMessage();
        }
       return result;
   }
   
   public String insertInto(String username, String workcode, String workflow){
       
       String sql = "INSERT INTO records (ts, username, workcode, workflow) VALUES (STRFTIME(\"%Y-%m-%d %H:%M:%f\", 'NOW'),?,?,?);";
       String result;
       //Calendar calendar = Calendar.getInstance();
       //Timestamp jTs = new Timestamp(calendar.getTime().getTime());
       //System.out.println(jTs);    
       try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //pstmt.setTimestamp(1, jTs);
            pstmt.setString(1, username);
            pstmt.setString(2, workcode);
            pstmt.setString(3, workflow);
            //System.out.println(sql);
            pstmt.executeUpdate();
            result = "Success";
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
            result = e.getMessage();
        }
       return result;
   }
   
   public ArrayList <ArrayList> select(String selectStatement){
   
       String sql = selectStatement;
       ArrayList <ArrayList> result = new ArrayList<>();
        
        try (Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            int columnCount = rs.getMetaData().getColumnCount();
            // loop through the result set
            while (rs.next()) {
                
                ArrayList<String> row = new ArrayList<>();
                for (int i=0; i <columnCount ; i++) {
                   row.add(rs.getString(i + 1));
                   //System.out.println(rs.getString(i+1));
                }
                result.add(row); 
            }
            
        } catch (SQLException e) {
            ArrayList<String> row = new ArrayList<>();
            row.add(e.getMessage());
            result.add(row);
            System.out.println(e.getMessage());
        }
        
        return result;
       
   }
    
   public String testConnection(){
       
       String result = "";
       try(Connection conn = this.connect()){
           
           result = "Connection to Database established successfully.";
       
       } catch(SQLException e){
           
           result = e.getMessage();
       
       }
       return result;
   }
}
