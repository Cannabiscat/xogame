package com.xogame;

public class Main {

    public static final int SIZE = 3;
    public static GameInterface f2 = new ConsoleGamefield();

    public static void main(String[] args) {
        int counter = 0;
        Value pl = Value.o;
        f2.setSizeField(SIZE);
        f2.eraseField();
        f2.showField();
        while(!CheckWin.check(pl) &&  counter < SIZE*SIZE) {
            pl = changePlayer(pl);
            f2.playersMove(pl);
            f2.showField();
            if (CheckWin.check(pl)) f2.messageWin(pl);
            counter++;
        }
        if (counter == SIZE*SIZE && !CheckWin.check(pl)) f2.messageDraw();
    }



    private static Value changePlayer(Value player) {
        if (player == Value.o) player = Value.x; else player = Value.o;
        return player;
    }
}

