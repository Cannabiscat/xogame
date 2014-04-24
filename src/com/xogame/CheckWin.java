package com.xogame;



public class CheckWin extends MainGamefield {

    public static boolean check(Value sign) {

        Boolean win = false;
        if (sign != Value.empty) {
            for (int pointer = 0; pointer < SIZE_FIELD; pointer++) {
                if (checkColumn(pointer, sign)) win = checkColumn(pointer, sign);
                if (checkLine(pointer, sign)) win = checkLine(pointer, sign);
            }
            for (int pointer = 0; pointer < 2; pointer++) {
                if (checkDiag(pointer, sign)) win = checkDiag(pointer, sign);
            }
        }
        return win;
    }


    private static boolean checkLine(int x, Value v) {
        return stringer(x).equals(v.toString() + v.toString() + v.toString());
    }

    private static boolean checkColumn(int y, Value v) {
        return columner(y).equals(v.toString() + v.toString() + v.toString());
    }

    private static boolean checkDiag(int z, Value v) {
        return diager(z).equals(v.toString() + v.toString() + v.toString());
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
        switch (pointer) {
            case 0: {
                for (int i = 0; i < SIZE_FIELD; i++) {
                    diag = diag + field[SIZE_FIELD - 1 - i][i];
                }
                break;
            }
            case 1: {
                for (int i = 0; i < SIZE_FIELD; i++) {
                    diag = diag + field[i][i];
                }
                break;
            }
        }
        return diag;
    }
}
