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
    private ComputerMoveGenerator moveGenerator = new ComputerMoveGenerator();

    public Board(GameState gameState) {
        this.gameState = gameState;
        createNewBoard();
    }

    public void createNewBoard() {
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
                field.setOnMouseClicked(e -> {
                    if (gameState.getRoundState().getBoardFields()[colf][rowf].equals(Figure.EMPTY)) {
                        if (gameState.getRoundState().getNumberOfMoves() % 2 == 0) {
                            add(new ImageView(new Image("file:resources/O.png")), colf, rowf);
                            gameState.getRoundState().getBoardFields()[colf][rowf] = Figure.O;
                        } else {
                            add(new ImageView(new Image("file:resources/X.png")), colf, rowf);
                            gameState.getRoundState().getBoardFields()[colf][rowf] = Figure.X;
                        }
                        if (gameState.isPlayerTwoComputer() && !gameState.getRoundState().isOver()) {
                            addGeneratedFigure(gameState.getPlayerTwo().getFigure());
                        }
                    }
                    refreshBoard();
                    if (gameState.isRoundOver()) {
                        if (gameState.isGameOver()) {
                            gameState = TwoPlayersNewGameWindow.display();
                        }
                        createNewBoard();
                    }
                });
            }
        }
        if (gameState.isPlayerTwoComputer() && gameState.getPlayerTwo().getFigure().equals(Figure.O)) {
            addGeneratedFigure(Figure.O);
        }
        refreshBoard();
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            setHalignment(getChildren().get(i), HPos.CENTER);
            setValignment(getChildren().get(i), VPos.CENTER);
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private void addGeneratedFigure(Figure figure) {
        int computerMove = moveGenerator.GenerateMove(gameState.getRoundState());
        int generatedRow = computerMove / 3;
        int generatedCol = computerMove % 3;
        if (figure.equals(Figure.O)) {
            add(new ImageView(new Image("file:resources/O.png")), generatedCol, generatedRow);
            gameState.getRoundState().getBoardFields()[generatedCol][generatedRow] = Figure.O;
        } else {
            add(new ImageView(new Image("file:resources/X.png")), generatedCol, generatedRow);
            gameState.getRoundState().getBoardFields()[generatedCol][generatedRow] = Figure.X;
        }
    }
}