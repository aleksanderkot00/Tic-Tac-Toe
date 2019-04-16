 package com.kodilla;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {

    private GameState gameState;

    public Board(GameState gameState) {
        this.gameState = gameState;
        createBoard();
    }

    public void createBoard() {
        while(getChildren().size() > 0){
            getChildren().remove(0);
        }
        gameState.getRoundState().newRound();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(new Rectangle(160, 160, Color.BLACK), col, row);
                final int colf = col;
                final int rowf = row;
                Field field = new Field();
                add(field, col, row);
                field.setOnMouseClicked(d -> {
                    if (gameState.getRoundState().getBoardFields()[colf][rowf].equals(BoardFieldState.EMPTY)) {
                        if (gameState.getRoundState().getNumberOfMoves() % 2 == 0) {
                            add(new ImageView(new Image("file:resources/O.png")), colf, rowf);
                            gameState.getRoundState().getBoardFields()[colf][rowf] = BoardFieldState.O;
                        } else {
                            add(new ImageView(new Image("file:resources/X.png")), colf, rowf);
                            gameState.getRoundState().getBoardFields()[colf][rowf] = BoardFieldState.X;
                        }
                    }
                    refreshBoard();
                    if (GameStateVerifier.isRoundOver(gameState)) {
                        createBoard();
                    }
                });
                refreshBoard();
            }
        }
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            setHalignment(getChildren().get(i), HPos.CENTER);
            setValignment(getChildren().get(i), VPos.CENTER);
        }
    }
}