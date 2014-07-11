package com.xogame;

import javax.swing.*;

/**
 * Created by Alex on 11.07.2014.
 */
public class Button extends JButton {

    private int x, y;

    public int geTx() {
        return x;
    }

    public int geTy() {
        return y;
    }

    Button(String text, int x, int y) {
        super(text);
        this.x = x;
        this.y = y;
    }
}
