/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_gui;

import javax.swing.*;    
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nasrallah
 */
public class Main extends JFrame {

   static  Still_clock clock = new Still_clock();
static MessagePanel messagePanel;
    public Main() {

        //display clock
        messagePanel = new MessagePanel(clock.getHoure() + ":" + clock.getMinute() + ":" + clock.getSecond());
        messagePanel.setCentered(true);
       
        messagePanel.setFont(new Font("courie", Font.BOLD, 20));
        
        add(clock);
        add(messagePanel, BorderLayout.SOUTH);
       
    }


    public static void main(String[] args) {
        Main D_clock = new Main();
        D_clock.setTitle("Big Bin ");
        D_clock.setDefaultCloseOperation(D_clock.EXIT_ON_CLOSE);
        D_clock.setSize(300, 350);
        D_clock.setBackground(Color.BLACK);
        D_clock.setVisible(true);
        while(true){
         clock.setCurrentTime();
         messagePanel.setMessage(clock.getHoure() + ":" + clock.getMinute() + ":" + clock.getSecond());
            

           clock.repaint();
        messagePanel.repaint();
        }
    }
}
