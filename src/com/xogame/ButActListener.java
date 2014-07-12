package com.xogame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 11.07.2014.
 */
public class ButActListener implements ActionListener {

    GlobalVars var = new GlobalVars();

    @Override
    public void actionPerformed(ActionEvent event) {

        synchronized (var.monitor) {
            var.monitor.notify();
        }
        int x = ((Button)event.getSource()).geTx();
        int y = ((Button)event.getSource()).geTy();
        if (!var.exit) {
            if (Engine.field.isCellEmpty(x,y)) {
                var.counter++;
                var.player = Value.changePlayer(var.player);
                Engine.field.setFieldCell(var.player,x,y);
                switch (var.player) {
                    case x:((Button) event.getSource()).setText("X");break;
                    case o:((Button) event.getSource()).setText("O");break;
                }
            }
            else JOptionPane.showMessageDialog(null, "Клетка занята!!");
        }
        if(var.win) JOptionPane.showMessageDialog(null , "" + var.player + " выиграл!!");
    }
}
