package com.xogame;

import java.util.ArrayList;

enum Value {
    empty, x , o;
    @Override
    public String toString() {
        return super.toString();
    }

    public static Value changePlayer(Value player) {
        Value state = empty;
        switch(player) {
            case x: {state = o; break;}
            case o: {state = x; break;}
        }
        return state;
    }
}

public class GameFieldMain {

    public static ArrayList<ArrayList<Value>> field = new ArrayList<>();
    public int sizeField;


    public void initField() {
        for (int i = 0; i < sizeField; i++) field.add(new ArrayList<Value>());
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                field.get(j).add(Value.empty);
            }
        }
    }

    public void setFieldCell(Value value, int x, int y) {
        field.get(x).set(y, value);
    }


    public void setSizeField() {

    }

    public boolean isCellEmpty(int x, int y) {
        return field.get(x).get(y) == Value.empty;
    }




    public void messageWin(Value player) {

    }


    public void messageDraw() {

    }

    public boolean check(Value sign) {
        Boolean win = false;
        if (sign != Value.empty) {
            for (int pointer = 0; pointer < sizeField; pointer++) {
                if (checkColumn(pointer, sign)) win = checkColumn(pointer, sign);
                if (checkLine(pointer, sign)) win = checkLine(pointer, sign);
            }
            for (int pointer = 0; pointer < 2; pointer++) {
                if (checkDiag(pointer, sign)) win = checkDiag(pointer, sign);
            }
        }
        return win;
    }

    public void showField() {}
    public void playersMove(Value player) {}


    private boolean checkLine(int x, Value v) {
        return stringer(x).equals(v.toString() + v.toString() + v.toString());
    }

    private boolean checkColumn(int y, Value v) {
        return columner(y).equals(v.toString() + v.toString() + v.toString());
    }

    private boolean checkDiag(int z, Value v) {
        return diager(z).equals(v.toString() + v.toString() + v.toString());
    }

    private String stringer(int pointer) {
        String string = "";
        for (int i = 0; i < sizeField; i++) {
            string = string + field.get(pointer).get(i);
        }
        return string;
    }

    private String columner(int pointer) {
        String column = "";
        for (int i = 0; i < sizeField; i++) {
            column = column + field.get(i).get(pointer);
        }
        return column;
    }

    private String diager(int pointer) {
        String diag = "";
        switch (pointer) {
            case 0: {
                for (int i = 0; i < sizeField; i++) {
                    diag = diag + field.get(sizeField - 1 - i).get(i);
                }
                break;
            }
            case 1: {
                for (int i = 0; i < sizeField; i++) {
                    diag = diag + field.get(i).get(i);
                }
                break;
            }
        }
        return diag;
    }
}
