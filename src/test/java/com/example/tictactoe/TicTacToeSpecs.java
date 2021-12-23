package com.example.tictactoe;

import com.example.tictactoe.endings.APlayerWonTheGame;
import com.example.tictactoe.endings.GameEndWithADraw;
import com.example.tictactoe.endings.PositionPlaceOcuppied;
import com.example.tictactoe.game.Game;
import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
        assertThrows(PositionPlaceOcuppied.class, () -> {
            game.play(position);
        });
    }
    @Test
    public void when_a_player_makes_tic_tac_toe_wins()  {
        Game game = start();
        game.play(A1);
            game.play(B2);
        game.play(A2);
            game.play(B3);
        assertThrows(APlayerWonTheGame.class, () -> {
            game.play(A3);
        });
    }
    @Test
    public void when_player_O_makes_tic_tac_toe_wins()  {
        Game game = start();
        game.play(A1);
            game.play(B2);
        game.play(B1);
            game.play(C1);
        game.play(A2);
        assertThrows(APlayerWonTheGame.class, () -> {
            game.play(A3);
        });
    }

    @Test
    public void when_positions_are_full_an_exception_is_expected()  {
        Game game = start();
        game.play(B2);
            game.play(A1);
        game.play(B1);
            game.play(B3);
        game.play(C1);
            game.play(A3);
        game.play(A2);
            game.play(C2);

        assertThrows(GameEndWithADraw.class, () -> {
            game.play(C3);
        });
    }
}
