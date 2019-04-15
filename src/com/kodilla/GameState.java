package com.kodilla;

import java.util.Arrays;

public class GameState {
    
    private BoardFieldState[][] boardFields = new BoardFieldState[3][3];

    public boolean hasFigureWon(BoardFieldState boardFieldState) {
        return Arrays.stream(boardFields).
                filter(row -> Arrays.stream(row).filter(field -> field.equals(boardFieldState)).
                        count() == 3L).count() == 1L ||
                Arrays.stream(getTransposedBoardFields()).
                        filter(row -> Arrays.stream(row).filter(field -> field.equals(boardFieldState)).
                                count() == 3L).count() == 1L ||
                Arrays.stream(getDiagonalBoardFields()).filter(field -> field.equals(boardFieldState)).count() == 3L ||
                Arrays.stream(getAntidiagonalBoardFields()).filter(field -> field.equals(boardFieldState)).count() == 3L;
    }

    public boolean isDraw() {
        return getNumberOfMoves() == 9L && !hasFigureWon(BoardFieldState.O) && !hasFigureWon(BoardFieldState.X);
    }

    public boolean isOver() {
        return isDraw() || hasFigureWon(BoardFieldState.O) || hasFigureWon(BoardFieldState.X);
    }

    public BoardFieldState[][] getBoardFields() {
        return boardFields;
    }

    public int getNumberOfMoves() {
        return (int) Arrays.stream(boardFields).
                flatMap(row -> Arrays.stream(row)).
                filter(field -> !field.equals(BoardFieldState.EMPTY)).
                count();
    }

    public BoardFieldState[][] getTransposedBoardFields() {
        BoardFieldState[][] transposedBoardFields = new BoardFieldState[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposedBoardFields[i][j] = boardFields[j][i];
            }
        }
        return transposedBoardFields;
    }

    public BoardFieldState[] getDiagonalBoardFields() {
        BoardFieldState[] diagonalBoardFields = new BoardFieldState[3];
        for (int i = 0; i < 3; i++) {
            diagonalBoardFields[i] = boardFields[i][i];
        }
        return diagonalBoardFields;
    }

    public BoardFieldState[] getAntidiagonalBoardFields() {
        BoardFieldState[] diagonalBoardFields = new BoardFieldState[3];
        for (int i = 0; i < 3; i++) {
            diagonalBoardFields[i] = boardFields[i][2 - i];
        }
        return diagonalBoardFields;
    }

    public void restartGame() {
        Arrays.stream(boardFields).forEach(a -> Arrays.fill(a, BoardFieldState.EMPTY));
    }
}
