/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Stefan
 */
public class TickTock {
   private String directory = System.getProperty("user.dir");
   private String url = "jdbc:sqlite:"+directory+"/database.db";
   public TickTock(){
       System.out.println(directory);
   }
    
   public void createTable(String CreateTblStatement) {
        // SQLite connection string
        String sql = CreateTblStatement;
        
        // SQL statement for creating a new table
       /* String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";*/
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   
   public void insert(String insertStatement){
   
   }
    
}
