package com.xogame;

/**
 * Created by Alex on 24.04.2014.
 */
public interface GameInterface {

    public void setSizeField(int size);
    public void showField();
    public void eraseField();
    public void playersMove(Value player);
    public void messageWin(Value player);
    public void messageDraw();

}
