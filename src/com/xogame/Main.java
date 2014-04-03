package com.xogame;

import java.io.Console;



public class Main {

    public static Gamefield f1 = new Gamefield();

    public static void main(String[] args) {

        f1.eraseField();
        f1.showField();
        playermove('X', 0, 1);
        f1.showField();
        playermove('X', 1, 1);
        f1.showField();
        playermove('O', 1, 1);
        f1.showField();




    }

    public static void playermove(char pl, int x, int y) {

        switch(pl) {
            case 'X' : { f1.set(pl, x, y); break;}
            case 'O' : { f1.set(pl, x, y); break;}
        }

    }
}
