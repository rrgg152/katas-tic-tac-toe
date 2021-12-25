package com.example.tictactoe.game;

import com.example.tictactoe.Rounds;
import com.example.tictactoe.endings.APlayerWonTheGame;
import com.example.tictactoe.endings.GameEndWithADraw;
import com.example.tictactoe.endings.PositionPlaceOccupied;

public class Game {

    private Player turn;
    private final Rounds rounds;

    private Game(){
        this.turn = Player.X;
        this.rounds = new Rounds();
    }
    public static Game start() {
        return new Game();
    }

    public Player turnOfPlayer() {
        return turn;
    }

    public void play(Position position) throws PositionPlaceOccupied {
        if (rounds.isPositionOcuppied(position)){
            throw new PositionPlaceOccupied(position);
        }
        this.rounds.playRound(position, turnOfPlayer());
        if (rounds.areFull()){
            throw new GameEndWithADraw();
        }
        if (rounds.thereIsAWinner().isPresent()){
            throw new APlayerWonTheGame(rounds.thereIsAWinner().get());
        }
        this.turn = oppositePlayer();
    }

    private Player oppositePlayer() {
        if (this.turnOfPlayer() == Player.X) {
            return Player.O;
        }
        return Player.X;
    }

}
