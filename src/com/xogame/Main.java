package com.xogame;

public class Main {

    public static Engine f2;
    public static Check check;

    public static void main(String[] args) {
        f2 = new GraphicGame();
        check = new Check();
        int counter = 0;
        Value pl = Value.o;
        f2.setSizeField();
        f2.field.initField();
        f2.showField();
        while(!check.win(pl) &&  counter < f2.field.sizeField*f2.field.sizeField) {
            pl = Value.changePlayer(pl);
            f2.playersMove(pl);
            f2.showField();
            if (check.win(pl)) f2.messageWin(pl);
            counter++;
        }
        if ((counter == (f2.field.sizeField * f2.field.sizeField)) && !check.win(pl)) f2.messageDraw();
    }
}

