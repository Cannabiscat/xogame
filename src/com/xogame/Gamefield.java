package com.xogame;

public class Gamefield {

    public static final int SIZE_FIELD = 3;

    public static final char DEFAULT_CHAR = ' ';

    public char[][] field = new char[SIZE_FIELD][SIZE_FIELD];

    public void showField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            showLine(i);
            System.out.println();
        }
        System.out.println();
    }

    private void showLine(int x) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            showCell(x, i);
        }
    }
    private void showCell(int x, int y) {
         System.out.print("[" + field[x][y] + "]");
     }

    private void eraseLine (int lineNum) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            field[i][lineNum] = DEFAULT_CHAR;
        }
    }
    public void eraseField () {
        for (int i = 0; i < SIZE_FIELD; i++) {
            eraseLine(i);
        }
    }

    public void setX(int x, int y) {
        if (checkState(x, y)) {
            field[x][y] = 'x';
        }
    }
    public void setO(int x, int y) {
        if (checkState(x, y)) {
            field[x][y] = 'O';
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

