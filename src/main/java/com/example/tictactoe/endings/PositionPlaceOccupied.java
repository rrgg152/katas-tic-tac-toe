package com.example.tictactoe.endings;

import com.example.tictactoe.game.Position;

public class PositionPlaceOccupied extends RuntimeException {
    public PositionPlaceOccupied(Position position) {
        super(String.format("The position %s is occupied!", position));
    }
}
