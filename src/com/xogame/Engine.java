package com.xogame;


public interface Engine {

    Field field = new Field();

    void messageWin(Value player);
    void messageDraw();
    void setSizeField();
    void showField();
    void playersMove(Value player);

}
