package com.xogame;

public class Gamefield {

    private static final int SIZE_FIELD = 3;

    private static final char DEFAULT_CHAR = ' ';

    private char[][] field = new char[SIZE_FIELD][SIZE_FIELD];

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

    private boolean checkLine(int x, char v) {
        boolean ans = false;
        String str = "";
        str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        ans = stringer(x).equals(str);
        return ans;
        }
    private boolean checkColumn(int y, char v) {
        boolean ans = false;
        String str = "";
        str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        ans = columner(y).equals(str);
        return ans;
    }
    private boolean checkDiag(int z, char v) {
        boolean ans = false;
        String str = "";
        str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        ans = diager(z).equals(str);
        return ans;
    }

    private String stringer(int x) {
        String string = "";
        for (int i = 0; i < SIZE_FIELD; i++) {
            string = string + field[x][i];
        }
        return string;
    }
    private String columner(int y) {
         String column = "";
         for (int i = 0; i < SIZE_FIELD; i++) {
             column = column + field[i][y];
         }
         return column;
     }
    private String diager(int z) {
        String diag = "";
        if (z == 1) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                diag = diag + field[SIZE_FIELD - 1 - i][i];
            }
        }
        else if (z == 2) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                diag = diag + field[i][i];
            }
        }
        return diag;
    }
}

