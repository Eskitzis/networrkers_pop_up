package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    int timer;
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Image");
        jFrame.setLayout(new FlowLayout());
        jFrame.setUndecorated(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
         int xsize = (int)toolkit.getScreenSize().getWidth();
         int ysize = (int)toolkit.getScreenSize().getHeight();
        jFrame.setSize(xsize,ysize);
        jFrame.add(new JLabel(new ImageIcon("image.png")));

        jFrame.setVisible(true);

        int i = 15;
        Main C = new Main();
        C.counter(i);

        //CLose App After delay Time of Seconds
        int delay = 15000;

        javax.swing.Timer timer = new javax.swing.Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
            }
        });
        timer.start();
        //End Close App



    }
    public void counter(int i){
            //JFrame For Countdown
            JFrame second = new JFrame();
            JLabel jLabel = new JLabel("Countdown");
            jLabel.setFont(new Font("Verdana",Font.PLAIN,60));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            jLabel.setForeground(Color.GREEN);
            second.setAlwaysOnTop(true);
            second.setUndecorated(true);
            second.setAlwaysOnTop(true);
            second.setResizable(false);
            second.pack();
            second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            int xsize = (int)toolkit.getScreenSize().getWidth();
            int ysize = (int)toolkit.getScreenSize().getHeight();
            second.setSize(xsize,ysize);
            second.setBackground(new Color(0f,0f,0f,0f));
            second.setVisible(true);
            //End JFrame
        timer = i;
        Timer TimerA = new Timer();
        TimerTask TaskA = new TimerTask() {
            @Override
            public void run() {
                if (timer >=0){
                    //System.out.println(""+timer);
                    //second.add(new JLabel(String.valueOf(timer)));
                    jLabel.setText(String.valueOf(timer));
                    second.add(jLabel);
                    timer--;
                }
                if (timer== -1){
                    //System.out.println("Closing");
                    second.setVisible(false);
                    TimerA.cancel();
                }
            }
        };
        TimerA.schedule(TaskA,0,1000);
    }
}