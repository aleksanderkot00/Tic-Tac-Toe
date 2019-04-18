 package com.tictactoe.view;

import com.tictactoe.state.ComputerMoveGenerator;
import com.tictactoe.state.Figure;
import com.tictactoe.state.GameState;
import com.tictactoe.window.NewGameWindow;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

 public class Board extends GridPane {

    private GameState gameState;
    private ComputerMoveGenerator moveGenerator = new ComputerMoveGenerator();

    public Board(GameState gameState) {
        this.gameState = gameState;
        createBoard();
    }

    public void createBoard() {
        while(getChildren().size() > 0){
            getChildren().remove(0);
        }
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
                        gameState.getRoundState().newRound();
                        if (gameState.isGameOver()) {
                            gameState = NewGameWindow.display();
                        }
                        createBoard();
                    }
                });
            }
        }
        if (gameState.isPlayerTwoComputer() && gameState.getPlayerTwo().getFigure().equals(Figure.O)) {
            addGeneratedFigure(Figure.O);
        }
        add(displayResult(), 3,0,1,2);
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

    public VBox displayResult() {

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