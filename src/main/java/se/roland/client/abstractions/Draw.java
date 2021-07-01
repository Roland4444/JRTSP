package se.roland.client.abstractions;

import javax.swing.*;

public abstract class Draw extends Thread{
    public abstract void DrawIt();
    public JPanel Panel;
    public Draw(JPanel draw){
        this.Panel =  draw;
    };
    public void run(){

        while (true){
                DrawIt();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
