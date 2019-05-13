package com.github.aleksanderkot00.tictactoe.view;

import com.github.aleksanderkot00.tictactoe.state.GameState;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ResultDisplay {
    public static VBox display(GameState gameState) {

        VBox resultDisplay = new VBox();
        resultDisplay.setAlignment(Pos.CENTER);

        Label score = new Label();
        score.setText("Score:");
        score.setTextFill(Color.RED);
        score.setFont(Font.font("Cambria", 40));

        Label rounds = new Label();
        rounds.setText("Round: " + (
                gameState.getPlayerOne().getRoundsWon() +
                        gameState.getPlayerTwo().getRoundsWon() +
                        gameState.getNumberOfDraws()
        ));
        rounds.setTextFill(Color.RED);
        rounds.setFont(Font.font("Cambria", 20));

        Label player1Rounds = new Label();
        player1Rounds.setText(gameState.getPlayerOne().getName() + " won rounds: " +
                gameState.getPlayerOne().getRoundsWon());
        player1Rounds.setTextFill(Color.RED);
        player1Rounds.setFont(Font.font("Cambria", 20));

        Label player2Rounds = new Label();
        player2Rounds.setText(gameState.getPlayerTwo().getName() + " won rounds: " +
                gameState.getPlayerTwo().getRoundsWon());
        player2Rounds.setTextFill(Color.RED);
        player2Rounds.setFont(Font.font("Cambria", 20));

        Label roundsToWin = new Label();
        roundsToWin.setText("Rounds needed to win: " + gameState.getRoundsToWin());
        roundsToWin.setTextFill(Color.RED);
        roundsToWin.setFont(Font.font("Cambria", 20));

        resultDisplay.getChildren().addAll(score, rounds, player1Rounds, player2Rounds, roundsToWin);
        return resultDisplay;
    }
}
