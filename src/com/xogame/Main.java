package com.xogame;

public class Main {

    public static GameFieldMain f2 = new ConsoleGamefield();

    public static void main(String[] args) {
        int counter = 0;
        Value pl = Value.o;
        f2.setSizeField();
        f2.initField();
        f2.showField();

        while(!f2.check(pl) &&  counter < f2.sizeField*f2.sizeField) {
            pl = Value.changePlayer(pl);
            f2.playersMove(pl);
            f2.showField();
            if (f2.check(pl)) f2.messageWin(pl);
            counter++;
        }
        if ((counter == (f2.sizeField * f2.sizeField)) && !f2.check(pl)) f2.messageDraw();
//    }



    }
}

