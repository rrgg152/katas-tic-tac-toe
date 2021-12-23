package com.example.tictactoe.game;

import com.example.tictactoe.Rounds;
import com.example.tictactoe.endings.APlayerWonTheGame;
import com.example.tictactoe.endings.GameEndWithADraw;
import com.example.tictactoe.endings.PositionPlaceOcuppied;

public class Game {

    private Player turn;
    private final Rounds positions;

    private Game(){
        this.turn = Player.X;
        this.positions = new Rounds();
    }
    public static Game start() {
        return new Game();
    }

    public Player turnOfPlayer() {
        return turn;
    }

    public void play(Position position) throws PositionPlaceOcuppied {
        if (positions.isPositionOcuppied(position)){
            throw new PositionPlaceOcuppied();
        }
        this.positions.playRound(position, turnOfPlayer());
        if (positions.areFull()){
            throw new GameEndWithADraw();
        }
        if (positions.thereIsAWinner().isPresent()){
            throw new APlayerWonTheGame();
        }
        this.turn = oppositePlayer();
    }

    private Player oppositePlayer() {
        if (this.turnOfPlayer() == Player.X) {
            return Player.O;
        }
        return Player.X;
    }

    public Player isWinnedBy() {
        return Player.X;
    }
}
