/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_gui;

import java.awt.Dimension;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author nasrallah
 */
 class Still_clock extends JPanel {

    private int houre = 0, minute = 0, second = 0;

    public Still_clock() {
        
        setCurrentTime();
    }

    public Still_clock(int H, int M, int S) {
        houre = H;
        minute = M;
        second = S;
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        houre = (calendar.get(Calendar.HOUR_OF_DAY) > 12) ? calendar.get(Calendar.HOUR_OF_DAY) - 12 : calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);

    }

    public int getHoure() {
        return houre;
    }

    public void setHoure(int houre) {
        this.houre = houre;
        repaint();
    }

    public void setMinute(int minute) {
        this.minute = minute;
        repaint();
    }

    public void setSecond(int second) {
        this.second = second;
        repaint();
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //init clock param
        int clockRadius = (int) (Math.min(getWidth(), getHeight() * .45));
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        //draw circle
        g.setColor(Color.BLACK);
                 g.setFont(new Font("", 55,30));

        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter -18, yCenter - clockRadius + 30);
         g.setColor(Color.RED);
         g.setFont(new Font("", 55,25));
        g.drawString("Nasrallah Adel", xCenter-90, yCenter+50);
         g.setColor(Color.BLACK);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 20, yCenter+3);
        g.drawString("6", xCenter - 6, yCenter + clockRadius - 3);
        //draw second hand
        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));

        g.setColor(Color.BLUE);
        
        g.drawLine(xCenter, yCenter, xSecond, ySecond);
        //draw minute
        int mLength = (int) (clockRadius * 0.55);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.drawLine(xCenter, yCenter, xMinute, yMinute);
       

//draw hour
        int hLength = (int) (clockRadius * 0.45);
        int xHour = (int) (xCenter + hLength * Math.sin((houre % 12.0 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((houre % 12.0 + minute / 60.0) * (2 * Math.PI / 12)));

        g.setColor(Color.GREEN);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public Dimension getpresize() {
        return new Dimension(200, 200);

    }

}
