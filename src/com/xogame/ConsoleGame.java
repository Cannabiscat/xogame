package com.xogame;

import java.util.Scanner;

public class ConsoleGame implements Engine {

    Check check = new Check();
    GlobalVars var = new GlobalVars();
    Thread thread  = new Thread(this);

    private static Value player = Value.o;

    int counter = 0;

    public void run(){
        setSizeField();
        field.initField();
        showField();
        while (!check.win(player) && counter < field.sizeField * field.sizeField) {
            player = Value.changePlayer(player);
            playersMove(player);
            showField();
            if (check.win(player)) messageWin(player);
            counter++;
        }
        if ((counter == (field.sizeField * field.sizeField)) && !check.win(player)) messageDraw();

        var.exit = true;

    }

    ConsoleGame() {
        thread.start();
    }
    public void setSizeField() {
        boolean fault = true;
        while (fault) {
            System.out.print("Введите размерность игрового поля: ");
            Scanner scanner = new Scanner(System.in);
            try {
                this.field.sizeField = scanner.nextInt();
                fault = false;
            }catch(Exception er){
                System.out.println("Неверный ввод, попробуйте снова!!");
            }
        }
    }
    public void showField() {
        for (int i = 0; i < field.sizeField; i++) {
            System.out.print("  " + (i + 1) );
        }
        System.out.println();
        for (int i = 0; i < field.sizeField; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < field.sizeField; j++) {
                switch(field.f1.get(j).get(i)) {
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
    public void playersMove(Value player) {
        boolean fault = true;
        while (fault) {
            Scanner in = new Scanner(System.in);
            System.out.println(player + ": Введите число от 1 до " + field.sizeField);
            try {
                int x = in.nextInt()-1;
                int y = in.nextInt()-1;
                if (field.isCellEmpty(x, y)) {
                    field.setFieldCell(player, x, y);
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
