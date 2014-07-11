package com.xogame;


public interface Engine extends Runnable {

//    public GlobalVars var = new GlobalVars();
    static EngineField field = new EngineField();
    GlobalVars var = new GlobalVars();

}
