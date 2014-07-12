package com.xogame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Security;


public class GraphicGame extends JFrame implements Engine, Runnable {

    GlobalVars var = new GlobalVars();
    
    static ButtonArray array;

    Thread thread = new Thread(this);

    GraphicGame() {
        thread.start();
    }

    public void run() {
        setSizeField();
        array = new ButtonArray(field.sizeField);
        setBounds(500, 300, 500, 500);
        this.setLayout(new GridLayout(field.sizeField, field.sizeField, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.initField();
        Check check = new Check();
        for (int i = 0; i < field.sizeField; i++) {
            for (int j = 0; j < field.sizeField; j++) {
                this.add(array.getButton(i, j));
                array.getButton(i,j).addActionListener(new ButActListener());
            }
        }
        setVisible(true);
    }




    public void setSizeField() {
        Engine.field.sizeField = 3;
    }


}