package com.example.tictactoe.endings;

public class GameEndWithADraw extends RuntimeException {
    public GameEndWithADraw(){
        super("All positions are occupied, the game ends with a draw");

    }
}
