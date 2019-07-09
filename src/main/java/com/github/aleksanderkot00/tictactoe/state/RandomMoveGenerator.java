package com.github.aleksanderkot00.tictactoe.state;

import com.github.aleksanderkot00.tictactoe.view.Board;
import com.github.aleksanderkot00.tictactoe.view.Field;
import javafx.scene.image.ImageView;

import java.util.Random;

public class RandomMoveGenerator implements ComputerMoveGenerator {

    private int generateMove(RoundState roundState) {
        int emptyFieldsNumber = 9 - roundState.getNumberOfMoves();
        int[] emptyFieldsIndex = new int[emptyFieldsNumber];
        int i = 0;
        for (int col = 0; col < 3; col++ ) {
            for (int row = 0; row < 3; row++ ) {
                if (roundState.getBoardFields()[col][row].equals(Figure.EMPTY)) {
                    emptyFieldsIndex[i] = 3 * row + col;
                    i++;
                }
            }
        }
        Random generator = new Random();
        return emptyFieldsIndex[generator.nextInt(emptyFieldsNumber)];
    }

    public void addGeneratedFigure(Board board) {
        int computerMove = generateMove(board.getGameState().getRoundState());
        int generatedRow = computerMove / 3;
        int generatedCol = computerMove % 3;
        if (board.getGameState().getPlayerTwo().getFigure().equals(Figure.O)) {
            board.add(new ImageView(Field.O_VIEW), generatedCol, generatedRow);
            board.getGameState().getRoundState().getBoardFields()[generatedCol][generatedRow] = Figure.O;
        } else {
            board.add(new ImageView(Field.X_VIEW), generatedCol, generatedRow);
            board.getGameState().getRoundState().getBoardFields()[generatedCol][generatedRow] = Figure.X;
        }
    }
}
