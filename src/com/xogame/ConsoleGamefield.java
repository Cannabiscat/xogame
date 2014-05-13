package com.xogame;


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGamefield extends GameFieldMain {


    public void setSizeField() {
        boolean fault = true;
        while (fault) {
            System.out.print("Введите размерность игрового поля: ");
            Scanner scanner = new Scanner(System.in);
            try {
                this.sizeField = scanner.nextInt();
                fault = false;
            }catch(Exception er){
                System.out.println("Неверный ввод, попробуйте снова!!");
            }
        }
    }

    @Override
    public void showField() {
        for (int i = 0; i < sizeField; i++) {
            System.out.print("  " + (i + 1) );
        }
        System.out.println();
        for (int i = 0; i < sizeField; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < sizeField; j++) {
                switch(field.get(j).get(i)) {
                    case empty: {
                        System.out.print("[ ]"); break;
                    }
                    case x:{
                        System.out.print("[X]"); break;
                    }
                    case o: {
                        System.out.print("[O]"); break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void playersMove(Value player) {
        boolean fault = true;
        while (fault) {
            Scanner in = new Scanner(System.in);
            System.out.println(player + ": Введите число от 1 до " + sizeField);
            try {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if (isCellEmpty(x, y)) {
                    setFieldCell(player, x, y);
                    fault = false;
                } else System.out.println("Поле занято, попробуйте ещё раз, " + player + "!!");
            } catch (Exception e) {
                System.out.println("Неверный ввод, попробуйте ещё раз, " + player + "!!");
            }
        }
    }


    public void messageWin(Value player) {
        System.out.println( player + ", Вы выиграли!!");
    }


    public void messageDraw() {
        System.out.println("Ничья!!");
    }
}
