/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticktockapp;

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
        gui.setState(JFrame.NORMAL);
       // gui.setSize(200,200);
       // gui.setVisible(true);   

    }
    
}
