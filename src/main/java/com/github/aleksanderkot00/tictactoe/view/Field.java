package com.github.aleksanderkot00.tictactoe.view;

import com.github.aleksanderkot00.tictactoe.state.Figure;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends Label {

    public static final Image O_VIEW = new Image("file:src/main/resources/O.png");
    public static final Image X_VIEW = new Image("file:src/main/resources/X.png");

    public Field(Board board, int col, int row) {
        setAlignment(Pos.CENTER);
        setMinSize(150, 150);
        setMaxSize(150, 150);
        setStyle("-fx-background-color: white;");
        if (board.getGameState().getPlayerOne().isComputer() || board.getGameState().getPlayerTwo().isComputer()) {
            setOnMouseClicked(e -> {
                if (board.getGameState().getRoundState().getBoardFields()[col][row].equals(Figure.EMPTY)) {
                    if (board.getGameState().getRoundState().getNumberOfMoves() % 2 == 0) {
                        board.add(new ImageView(O_VIEW), col, row);
                        board.getGameState().getRoundState().getBoardFields()[col][row] = Figure.O;
                    } else {
                        board.add(new ImageView(X_VIEW), col, row);
                        board.getGameState().getRoundState().getBoardFields()[col][row] = Figure.X;
                    }
                }
                board.refreshBoard();
                board.checkState();
            });
        }
    }
}
