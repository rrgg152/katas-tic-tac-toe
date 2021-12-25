package com.example.tictactoe;

import com.example.tictactoe.endings.APlayerWonTheGame;
import com.example.tictactoe.endings.GameEndWithADraw;
import com.example.tictactoe.endings.PositionPlaceOccupied;
import com.example.tictactoe.game.Game;
import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.tictactoe.game.Game.start;
import static com.example.tictactoe.game.Player.X;
import static com.example.tictactoe.game.Position.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TicTacToeSpecs {

    @Test
    public void PlayerXStartTheGame() {
        Game game = start();
        assertThat(game.turnOfPlayer()).isEqualTo(X);
    }
    @Test
    public void XAndOPlaysAlternative()  {
        Game game  = start();
        assertThat(game.turnOfPlayer()).isEqualTo(X);
        game.play(A1);
        assertThat(game.turnOfPlayer()).isEqualTo(Player.O);
    }

    @Test
    public void cannot_play_twice_same_position()  {
        Game game = start();
        Position position = A1;
        game.play(position);
        assertThrows(PositionPlaceOccupied.class, () -> game.play(position));
    }

    @ParameterizedTest
    @MethodSource("com.example.tictactoe.PlaysMother#randomPlayerEndsWithTicTacToe")
    public void when_a_player_makes_tic_tac_toe_wins(List<Position> rounds, Position lastPosition, Player winner)  {
        Game game = start();
        rounds.forEach(game::play);
        assertThat(game.turnOfPlayer()).isEqualTo(winner);
        assertThrows(APlayerWonTheGame.class, () -> game.play(lastPosition));
    }

    @ParameterizedTest
    @MethodSource("com.example.tictactoe.PlaysMother#randomPlaysEndingWithDraw")
    public void when_positions_are_full_an_exception_is_expected(List<Position> rounds, Position lastPosition)  {
        Game game = start();
        rounds.forEach(game::play);
        assertThrows(GameEndWithADraw.class, () -> game.play(lastPosition));
    }

}
