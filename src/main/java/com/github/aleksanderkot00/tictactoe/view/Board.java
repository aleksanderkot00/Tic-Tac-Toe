 package com.github.aleksanderkot00.tictactoe.view;

import com.github.aleksanderkot00.tictactoe.io.GameLoader;
import com.github.aleksanderkot00.tictactoe.io.Helper;
import com.github.aleksanderkot00.tictactoe.state.ComputerMoveGenerator;
import com.github.aleksanderkot00.tictactoe.state.RandomMoveGenerator;
import com.github.aleksanderkot00.tictactoe.state.Figure;
import com.github.aleksanderkot00.tictactoe.state.GameState;
import com.github.aleksanderkot00.tictactoe.io.GameIO;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

 public class Board extends GridPane {

    private GameState gameState;
    private ComputerMoveGenerator moveGenerator = new RandomMoveGenerator();
    private GameIO gameIO = new GameLoader();

    public Board(GameState gameState) {
        this.gameState = gameState;
        createBoard();
    }

    public void createBoard() {
        clean();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(new Rectangle(160, 160, Color.BLACK), col, row);
                add(new Field(this, col, row), col, row);
                if (gameState.getRoundState().getBoardFields()[col][row].equals(Figure.O)) {
                    add(new ImageView(new Image("file:src/main/resources/O.png")), col, row);
                } else if (gameState.getRoundState().getBoardFields()[col][row].equals(Figure.X)) {
                    add(new ImageView(new Image("file:src/main/resources/X.png")), col, row);
                }
            }
        }
        if (gameState.isPlayerTwoComputer() && gameState.getPlayerTwo().getFigure().equals(Figure.O) &&
                getGameState().getRoundState().getNumberOfMoves() == 0) {
            moveGenerator.addGeneratedFigure(this);
        }
        add(ResultDisplay.display(gameState), 3,0,1,2);
        refreshBoard();
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            setHalignment(getChildren().get(i), HPos.CENTER);
            setValignment(getChildren().get(i), VPos.CENTER);
        }
    }

     private void clean() {
         while(getChildren().size() > 0){
             getChildren().remove(0);
         }
     }

     public GameState getGameState() {
         return gameState;
     }

     public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

     public ComputerMoveGenerator getMoveGenerator() {
         return moveGenerator;
     }

     public void save(File file) {
        String s = gameIO.save(gameState);
        Helper.saveStringToFile(s, file);
    }

    public void load(File file) {
        String s = Helper.loadStringFromFile(file);;
        this.gameState = gameIO.load(s);
        createBoard();
    }
}