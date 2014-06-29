package com.xogame;

/**
 * Created by Alex on 26.06.2014.
 */
public class Check {

    public boolean win(Value sign) {
        Boolean win = false;
        if (sign != Value.empty) {
            for (int pointer = 0; pointer < Field.sizeField; pointer++) {
                if (checkColumn(pointer, sign)) win = checkColumn(pointer, sign);
                if (checkLine(pointer, sign)) win = checkLine(pointer, sign);
            }
            for (int pointer = 0; pointer < 2; pointer++) {
                if (checkDiag(pointer, sign)) win = checkDiag(pointer, sign);
            }
        }
        return win;
    }

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
        for (int i = 0; i < Field.sizeField; i++) {
            string = string + Field.f1.get(pointer).get(i);
        }
        return string;
    }

    private String columner(int pointer) {
        String column = "";
        for (int i = 0; i < Field.sizeField; i++) {
            column = column + Field.f1.get(i).get(pointer);
        }
        return column;
    }

    private String diager(int pointer) {
        String diag = "";
        switch (pointer) {
            case 0: {
                for (int i = 0; i < Field.sizeField; i++) {
                    diag = diag + Field.f1.get(Field.sizeField - 1 - i).get(i);
                }
                break;
            }
            case 1: {
                for (int i = 0; i < Field.sizeField; i++) {
                    diag = diag + Field.f1.get(i).get(i);
                }
                break;
            }
        }
        return diag;
    }

}
