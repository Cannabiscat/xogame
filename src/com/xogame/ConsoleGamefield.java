package com.xogame;


import java.util.Scanner;

public class ConsoleGamefield implements GameInterface {

    @Override
    public void setSizeField(int size) {
        System.out.println("Введите размер поля");
        int SIZE_FIELD = size;
    }

    private static final char DEFAULT_CHAR = ' ';
    public static char[][] consoleField = new char[SIZE_FIELD][SIZE_FIELD];
    private static final int MAX_COUNTER = SIZE_FIELD*SIZE_FIELD;


    @Override
    public void showField() {
        System.out.println();
        System.out.println("  1  2  3");
        for (int j = 0; j < SIZE_FIELD; j++) {
            System.out.print(j + 1);
            for (int i = 0; i < SIZE_FIELD; i++) {
                System.out.print("[" + consoleField[j][i] + "]");
            }
            System.out.println();
        }
    }

    @Override
    public void eraseField() {
        initializeField();
        for (int j = 0; j < SIZE_FIELD; j++) {
            for (int i = 0; i < SIZE_FIELD; i++) {
                consoleField[i][j] = DEFAULT_CHAR;
            }
        }
    }

    @Override
    public void playersMove(Value player) {
        boolean success = false;
        while (!success) {
            Scanner in = new Scanner(System.in);
            System.out.println(player + ": Введите число от 1 до " + SIZE_FIELD);
            try {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if (isEmpty(x, y)) {
                    set(player, x, y);
                    switch (player) {
                        case x : consoleField[x][y] = 'X'; break;
                        case o : consoleField[x][y] = 'O'; break;
                    }
                    success = true;
                } else System.out.println("Неверный ввод, попробуйте ещё раз, " + player + "!!");
            } catch (Exception e) {
                System.out.println("Неверный ввод, попробуйте ещё раз, " + player + "!!");
            }
        }
    }

    @Override
    public void messageWin(Value player) {
        System.out.println( player + ", Вы выиграли!!");
    }

    @Override
    public void messageDraw() {
        System.out.println("Ничья!!");
    }
}
