package com.xogame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Alex on 06.07.2014.
 */
public class ButtonArray {

    private static ArrayList<ArrayList<Button>> graphic;


    public static ArrayList<ArrayList<Button>> getGraphic() {
        return graphic;
    }

    public ButtonArray(int sizeField) {
        this.graphic = new ArrayList();
        for (int i = 0; i < sizeField; i++) graphic.add(new ArrayList<Button>());
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                graphic.get(j).add(new Button("" + i + j, i, j));
            }
        }
    }

    public JButton getButton(int x, int y) {
        return graphic.get(x).get(y);
    }
}


