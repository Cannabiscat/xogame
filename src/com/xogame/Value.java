package com.xogame;

/**
 * Created by Alex on 26.06.2014.
 */
enum Value {
    empty, x , o;
    public static Value changePlayer(Value player) {
        Value state = empty;
        switch(player) {
            case x: {state = o; break;}
            case o: {state = x; break;}
        }
        return state;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
