package com.xogame;

public class Gamefield {

    public static final int SIZE_FIELD = 3;

    private static final char DEFAULT_CHAR = ' ';

    public static char[][] field = new char[SIZE_FIELD][SIZE_FIELD];

    public void showField() {

        System.out.println();
        System.out.println(" " + " 1  2  3");
        for (int j = 0; j < SIZE_FIELD; j++) {
            System.out.print(j + 1);
            for (int i = 0; i < SIZE_FIELD; i++) {
                System.out.print("[" + field[j][i] + "]");
            }
            System.out.println();
        }
    }


    public void eraseField() {
        for (int j = 0; j < SIZE_FIELD; j++) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                field[i][j] = DEFAULT_CHAR;
            }
        }
    }

    public void set(char pl, int x, int y) {
        if (checkState(x, y)) {
            field[x][y] = pl;
        }
    }

    private boolean checkState(int x, int y) {
        if (field[x][y] == DEFAULT_CHAR) return true;
        else {
            System.out.println("Поле занято");
            return false;
        }
    }
}

