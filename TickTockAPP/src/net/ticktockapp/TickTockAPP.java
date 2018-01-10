/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Stefan
 */
public class TickTockAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String username = System.getProperty("user.name");
        
        TickTockGUI gui = new TickTockGUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Aux Codes App - Logged in as "+username);
        gui.setResizable(false);
       // gui.setSize(200,200);
       // gui.setVisible(true);   

    }
    
}
