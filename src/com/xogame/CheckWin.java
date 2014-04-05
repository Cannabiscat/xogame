package com.xogame;



public class CheckWin extends Gamefield {

    private static final int SIZE_FIELD = 3;

    private static final char DEFAULT_CHAR = ' ';

    public static boolean check(char sign) {

        Boolean win = false;
        for (int pointer = 0; pointer < SIZE_FIELD; pointer++) {
            if (checkColumn(pointer, sign)) win = checkColumn(pointer, sign);
            if (checkLine(pointer, sign)) win = checkLine(pointer, sign);
        }
        for (int pointer = 0; pointer < 2; pointer++) {
            if (checkDiag(pointer, sign)) win = checkDiag(pointer, sign);
        }
        return win;
    }

    private static boolean checkLine(int x, char v) {

        String str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        boolean ans = stringer(x).equals(str);
        return ans;
    }
    private static boolean checkColumn(int y, char v) {

        String str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        boolean ans = columner(y).equals(str);
        return ans;
    }
    private static boolean checkDiag(int z, char v) {

        String str = Character.toString(v) + Character.toString(v) + Character.toString(v);
        boolean ans = diager(z).equals(str);
        return ans;
    }

    private static String stringer(int pointer) {
        String string = "";
        for (int i = 0; i < SIZE_FIELD; i++) {
            string = string + field[pointer][i];
        }
        return string;
    }
    private static String columner(int pointer) {
        String column = "";
        for (int i = 0; i < SIZE_FIELD; i++) {
            column = column + field[i][pointer];
        }
        return column;
    }
    private static String diager(int pointer) {
        String diag = "";
        if (pointer == 0) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                diag = diag + field[SIZE_FIELD - 1 - i][i];
            }
        }
        else if (pointer == 1) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                diag = diag + field[i][i];
            }
        }
        return diag;
    }


}
