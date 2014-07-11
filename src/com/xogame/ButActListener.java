package com.xogame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 11.07.2014.
 */
public class ButActListener implements ActionListener {

    GlobalVars var = new GlobalVars();

    @Override
    public void actionPerformed(ActionEvent event) {
        int x = ((Button)event.getSource()).geTx();
        int y = ((Button)event.getSource()).geTy();
        if (Engine.field.isCellEmpty(x,y)) {
            Engine.field.setFieldCell(var.player,x,y);
            switch (var.player) {
                case x:
                {
                    ((Button) event.getSource()).setText("X");
                    var.player = Value.changePlayer(var.player);
                    break;
                }
                case o:
                {
                    ((Button) event.getSource()).setText("O");
                    var.player = Value.changePlayer(var.player);
                    break;
                }
            }

            synchronized (var.monitor) {
                    var.monitor.notify();
            }

        }
    }
}
