package com.xogame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GraphicGame extends JFrame implements Engine, Runnable {

    GlobalVars var = new GlobalVars();

    
    static ButtonArray array;
    public static Value player;

    Thread thread = new Thread(this);

    GraphicGame() {
        thread.start();
        setSizeField();
        array = new ButtonArray(field.sizeField);
        setBounds(500, 300, 500, 500);
        this.setLayout(new GridLayout(field.sizeField, field.sizeField, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.initField();
        for (int i = 0; i < field.sizeField; i++) {
            for (int j = 0; j < field.sizeField; j++) {
                this.add(array.getButton(i, j));
                array.getButton(i,j).addActionListener(new ButActListener());
            }
        }
    }

    public void run() {
        this.setVisible(true);
    }




    public void setSizeField() {
        Engine.field.sizeField = 3;
    }


}