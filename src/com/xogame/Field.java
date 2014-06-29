package com.xogame;

import java.util.ArrayList;

/**
 * Created by Alex on 28.06.2014.
 */
public class Field {

    public static ArrayList<ArrayList<Value>> f1;
    public static int sizeField;

    public Field() {
        f1 =  new ArrayList<>();
    }
    public void setFieldCell(Value value, int x, int y) {
        f1.get(x).set(y, value);
    }
    public void initField() {
        for (int i = 0; i < sizeField; i++) f1.add(new ArrayList<Value>());
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                f1.get(j).add(Value.empty);
            }
        }
    }
    public boolean isCellEmpty(int x, int y) {
        return f1.get(x).get(y) == Value.empty;
    }

}
