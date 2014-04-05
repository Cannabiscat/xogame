package com.xogame;

import java.util.Scanner;




public class Main {

    private static final char X = 'X';
    private static final char O = 'O';

    public static Gamefield f1 = new Gamefield();

    public static void main(String[] args) {

        char pl = O;
        f1.eraseField();
        f1.showField();
        while(!CheckWin.check(pl)) {
            pl = changePlayer(pl);
            playerMove(pl);
        }
        System.out.println(pl + " Вы выиграли!!");

    }

    private static void playerMove(char pl) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ваш ход Х и Y, " + pl + " :");
        int x = in.nextInt();
        int y = in.nextInt();
        f1.set(pl, x-1, y-1);
        f1.showField();
    }

    private static char changePlayer(char player) {
        if (player == O) player = X; else player = O;
        return player;
    }

}
