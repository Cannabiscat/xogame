package com.xogame;

public class Main {

    public static GameInterface f2 = new ConsoleGamefield();

    public static void main(String[] args) {
        int counter = 0;
        Value pl = Value.o;
        f2.setSizeField(f2.SIZE_FIELD);
        f2.eraseField();
        f2.showField();

        while(!CheckWin.check(pl) &&  counter < f2.SIZE_FIELD*f2.SIZE_FIELD) {
            pl = changePlayer(pl);
            f2.playersMove(pl);
            f2.showField();
            if (CheckWin.check(pl)) f2.messageWin(pl);
            counter++;
        }
        if ((counter == (f2.SIZE_FIELD * f2.SIZE_FIELD)) && !CheckWin.check(pl)) f2.messageDraw();
    }



    private static Value changePlayer(Value player) {
        if (player == Value.o) player = Value.x; else player = Value.o;
        return player;
    }
}

