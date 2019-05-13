package com.github.aleksanderkot00.tictactoe.view;

import com.github.aleksanderkot00.tictactoe.state.Figure;
import com.github.aleksanderkot00.tictactoe.window.NewGameWindow;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends Label {

    public Field(Board board, int col, int row) {
        setAlignment(Pos.CENTER);
        setMinSize(150, 150);
        setMaxSize(150, 150);
        setStyle("-fx-background-color: white;");
        setOnMouseClicked(e -> {
            if (board.getGameState().getRoundState().getBoardFields()[col][row].equals(Figure.EMPTY)) {
                if (board.getGameState().getRoundState().getNumberOfMoves() % 2 == 0) {
                    board.add(new ImageView(new Image("file:src/main/resources/O.png")), col, row);
                    board.getGameState().getRoundState().getBoardFields()[col][row] = Figure.O;
                } else {
                    board.add(new ImageView(new Image("file:src/main/resources/X.png")), col, row);
                    board.getGameState().getRoundState().getBoardFields()[col][row] = Figure.X;
                }
                if (board.getGameState().isPlayerTwoComputer() && !board.getGameState().getRoundState().isOver()) {
                    board.getMoveGenerator().addGeneratedFigure(board);
                }
            }
            board.refreshBoard();
            if (board.getGameState().isRoundOver()) {
                board.getGameState().getRoundState().newRound();
                if (board.getGameState().isGameOver()) {
                    board.setGameState(NewGameWindow.display());
                }
                board.createBoard();
            }
        });
    }
}
