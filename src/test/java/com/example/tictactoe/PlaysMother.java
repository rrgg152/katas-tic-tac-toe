package com.example.tictactoe;

import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.Position;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.example.tictactoe.game.Position.*;

public class PlaysMother {

    public static Stream<Arguments> randomPlaysEndingWithDraw(){
        return Stream.of(
                Arguments.of(getFullBoardExample(), C3),
                Arguments.of(getFullBoardExample2(), B3)
        );
    }
    public static Stream<Arguments> randomPlayerEndsWithTicTacToe(){
        return Stream.of(
                Arguments.of(PlayerXMakeVerticalTicTacToe(), A3, Player.X),
                Arguments.of(PlayerXMakeHorizontalTicTacToe(), C1, Player.X),
                Arguments.of(PlayerXMakeDiagonalTicTacToe(), C3, Player.X),
                Arguments.of(PlayerOMakeVerticalTicTacToe(), A3, Player.O),
                Arguments.of(PlayerOMakeHorizontalTicTacToe(), C1, Player.O),
                Arguments.of(PlayerOMakeDiagonalTicTacToe(), C3, Player.O)
        );
    }

    private static List<Position> PlayerOMakeDiagonalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(B1);
            rounds.add(A1);
        rounds.add(C1);
            rounds.add(B2);
        rounds.add(A2);
        return rounds;
    }

    private static List<Position> PlayerOMakeHorizontalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(B2);
            rounds.add(A1);
        rounds.add(B3);
            rounds.add(B1);
        rounds.add(A3);
        return rounds;
    }

    private static List<Position> PlayerOMakeVerticalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(B2);
            rounds.add(A1);
        rounds.add(B3);
            rounds.add(A2);
        rounds.add(C3);
        return rounds;
    }

    private static List<Position> PlayerXMakeDiagonalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(A1);
            rounds.add(C1);
        rounds.add(B2);
            rounds.add(B3);
        return rounds;
    }

    private static List<Position> PlayerXMakeHorizontalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(A1);
            rounds.add(B2);
        rounds.add(B1);
            rounds.add(B3);
        return rounds;
    }

    private static List<Position> PlayerXMakeVerticalTicTacToe() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(A1);
            rounds.add(B2);
        rounds.add(A2);
            rounds.add(B3);
        return rounds;
    }

    private static List<Position> getFullBoardExample() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(B2);
            rounds.add(A1);
        rounds.add(B1);
            rounds.add(B3);
        rounds.add(C1);
            rounds.add(A3);
        rounds.add(A2);
            rounds.add(C2);
        return rounds;
    }
    private static List<Position> getFullBoardExample2() {
        List<Position> rounds = new ArrayList<>();
        rounds.add(A1);
            rounds.add(C1);
        rounds.add(B1);
            rounds.add(A2);
        rounds.add(C2);
            rounds.add(B2);
        rounds.add(A3);
            rounds.add(C3);
        return rounds;
    }
}
