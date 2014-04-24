package com.xogame;


enum Value {
    empty, x , o;
    @Override
    public String toString() {
        return super.toString();
    }
}

public class MainGamefield {

    public static final int SIZE_FIELD = 3;
    public static Value[][] field = new Value[SIZE_FIELD][SIZE_FIELD];
    public void initializeField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                set(Value.empty, i, j);
            }
        }
    }

    public boolean isEmpty(int x, int y) {
        return (field[x][y] == Value.empty);
    }

    public void set(Value a, int x, int y) {
         field[x][y] = a;
    }



}

