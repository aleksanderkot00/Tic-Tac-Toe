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

    public Board() {
        gameState = new GameState();
        restartBoard();
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            setHalignment(getChildren().get(i), HPos.CENTER);
            setValignment(getChildren().get(i), VPos.CENTER);
        }
    }

    public void restartBoard() {
        while(getChildren().size() > 0){
            getChildren().remove(0);
        }
        gameState.restartGame();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(new Rectangle(160, 160, Color.BLACK), col, row);
                final int colf = col;
                final int rowf = row;
                Field field = new Field();
                add(field, col, row);
                field.setOnMouseClicked(d -> {
                    if (!gameState.isOver() &&
                            gameState.getBoardFields()[colf][rowf].equals(BoardFieldState.EMPTY)) {
                        if (gameState.getNumberOfMoves() % 2 == 0) {
                            add(new ImageView(new Image("file:resources/O.png")), colf, rowf);
                            gameState.getBoardFields()[colf][rowf] = BoardFieldState.O;
                            refreshBoard();
                            System.out.println(gameState.getNumberOfMoves());
                            System.out.println(gameState.isDraw());
                            System.out.println(gameState.hasFigureWon(BoardFieldState.O));
                            System.out.println(gameState.hasFigureWon(BoardFieldState.X));
                        } else {
                            add(new ImageView(new Image("file:resources/X.png")), colf, rowf);
                            gameState.getBoardFields()[colf][rowf] = BoardFieldState.X;
                            refreshBoard();
                            System.out.println(gameState.getNumberOfMoves());
                            System.out.println(gameState.isDraw());
                            System.out.println(gameState.hasFigureWon(BoardFieldState.O));
                            System.out.println(gameState.hasFigureWon(BoardFieldState.X));
                        }
                    }
                });
                refreshBoard();
            }
        }
    }
}