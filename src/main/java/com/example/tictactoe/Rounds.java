package com.example.tictactoe;

import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.Position;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Rounds {
    public static final int BOARD_SIZE = 3;
    private final Map<Position, Player> rounds;


    public Rounds() {
        this.rounds = new HashMap<>();
    }

    public Map<Position, Player> rounds() {
        return rounds;
    }

    public void playRound(Position position, Player player) {
        rounds.put(position, player);
    }

    public boolean isPositionOcuppied(Position position) {
        return this.rounds.containsKey(position);
    }

    public boolean areFull() {
        List<Position> allPositions = Arrays.stream(Position.values()).collect(Collectors.toList());
        List<Position> ocuppiedPositions = new ArrayList<>(this.rounds.keySet());
        return new HashSet<>(allPositions).equals(new HashSet<>(ocuppiedPositions));
    }

    public Optional<Player> thereIsAWinner() {
        boolean playerXwins= hasVerticalTicTacToe(Player.X) || hasHorizontalTicTacToe(Player.X) || hasDiagonalTicTacToe(Player.X);
        if (playerXwins){
            return Optional.of(Player.X);
        }
        boolean playerOwins= hasVerticalTicTacToe(Player.O) || hasHorizontalTicTacToe(Player.O) || hasDiagonalTicTacToe(Player.O);
        if (playerOwins){
            return Optional.of(Player.O);
        }
        return Optional.empty();
    }

    private boolean hasVerticalTicTacToe(Player player) {
        List<Position> playerPositions = playerPositions(player);
        return filterByChar(playerPositions, 'A') || filterByChar(playerPositions, 'B') || filterByChar(playerPositions, 'C');
    }
    private boolean hasHorizontalTicTacToe(Player player){
        List<Position> playerPositions = playerPositions(player);
        return filterByChar(playerPositions, '1') || filterByChar(playerPositions, '2') || filterByChar(playerPositions, '3');
    }
    private boolean hasDiagonalTicTacToe(Player player){
        List<Position> playerPositions = playerPositions(player);
        return isFromLeftToRightDiagonalTicTacToe(playerPositions) || isFromRightToLeftDiagonalTicTacToe(playerPositions);
    }

    private boolean isFromRightToLeftDiagonalTicTacToe(List<Position> playerPositions) {
        return filterByPosition(playerPositions, Position.C3) && filterByPosition(playerPositions, Position.B2) && filterByPosition(playerPositions, Position.A1);
    }

    private boolean isFromLeftToRightDiagonalTicTacToe(List<Position> playerPositions) {
        return filterByPosition(playerPositions, Position.C1) && filterByPosition(playerPositions, Position.B2) && filterByPosition(playerPositions, Position.A3);
    }


    private List<Position> playerPositions(Player player) {
        return new ArrayList<>(filterByValue(this.rounds, value -> value == player).keySet());
    }

    static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean filterByChar(List<Position> positions, char letter) {
        return positions.stream()
                .filter(position -> position.letter() == letter)
                .count() == BOARD_SIZE;
    }
    private boolean filterByPosition(List<Position> positions, Position position) {
        return positions.stream()
                .filter(pos -> pos.equals(position))
                .count() == 1;
    }
}
