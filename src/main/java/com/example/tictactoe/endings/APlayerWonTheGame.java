package com.example.tictactoe.endings;

import com.example.tictactoe.game.Player;

public class APlayerWonTheGame extends RuntimeException {

    public APlayerWonTheGame(Player player) {
        super(String.format("The player %s win the game!", player));
    }
}
