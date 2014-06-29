package com.xogame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicGame extends JFrame implements Engine {

    private ArrayList<JButton> graphic;

//    private JButton butE = new JButton("");
//    private JButton butX = new JButton("X");
//    private JButton butO = new JButton("O");
//    private static final GridLayout gameLayout = new GridLayout(Engine.field.sizeField, Engine.field.sizeField);


    public GraphicGame() {
        setSizeField();
        setBounds(500, 500, 500, 500);
        this.setLayout(new GridLayout(field.sizeField, field.sizeField, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        field.initField();
        for (int i = 0; i < field.sizeField; i++) {
            for (int j = 0; j < field.sizeField; j++) {
                switch(field.f1.get(j).get(i)) {
                    case empty: {
                        add(new JButton("")); break;
                    }
                    case x:{
                        add(new JButton("X")); break;
                    }
                    case o: {
                        add(new JButton("O")); break;
                    }
                }
            }
        }
//        add(new JButton("")); add(new JButton("O"));add(new JButton("X"));
//        add(new JButton("")); add(new JButton("O"));add(new JButton("X"));
//        add(new JButton("")); add(new JButton("O"));add(new JButton("X"));
        setVisible(true);
    }

    @Override
    public void messageWin(Value player) {

    }

    @Override
    public void messageDraw() {

    }

    @Override
    public void setSizeField() {
        Engine.field.sizeField = 8;
    }

    @Override
    public void showField() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                switch(field.f1.get(j).get(i)) {
//                    case empty: {
//                        add(new JButton("X")); break;
//                    }
//                    case x:{
//                        add(new JButton("X")); break;
//                    }
//                    case o: {
//                        add(new JButton("O")); break;
//                    }
//                }
//            }
//        }
    }

    @Override
    public void playersMove(Value player) {

    }
}
