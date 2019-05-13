package com.github.aleksanderkot00.tictactoe.state;

import java.util.Arrays;

public class RoundState {

    private Figure[][] boardFields = new Figure[3][3];

    public RoundState() {
        Arrays.stream(boardFields).forEach(a -> Arrays.fill(a, Figure.EMPTY));
    }

    public RoundState(Figure[] board) {
        for (int i = 0; i < board.length; i++) {
            boardFields[i % 3][i / 3] = board[i];
        }
    }

    public boolean hasFigureWon(Figure figure) {
        return Arrays.stream(boardFields).
                filter(row -> Arrays.stream(row).filter(field -> field.equals(figure)).
                        count() == 3L).count() == 1L ||
                Arrays.stream(getTransposedBoardFields()).
                        filter(row -> Arrays.stream(row).filter(field -> field.equals(figure)).
                                count() == 3L).count() == 1L ||
                Arrays.stream(getDiagonalBoardFields()).filter(field -> field.equals(figure)).count() == 3L ||
                Arrays.stream(getAntidiagonalBoardFields()).filter(field -> field.equals(figure)).count() == 3L;
    }

    public boolean isDraw() {
        return getNumberOfMoves() == 9 && !hasFigureWon(Figure.O) && !hasFigureWon(Figure.X);
    }

    public boolean isOver() {
        return isDraw() || hasFigureWon(Figure.O) || hasFigureWon(Figure.X);
    }

    public Figure[][] getBoardFields() {
        return boardFields;
    }

    public int getNumberOfMoves() {
        return (int) Arrays.stream(boardFields).
                flatMap(row -> Arrays.stream(row)).
                filter(field -> !field.equals(Figure.EMPTY)).
                count();
    }

    private Figure[][] getTransposedBoardFields() {
        Figure[][] transposedBoardFields = new Figure[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposedBoardFields[i][j] = boardFields[j][i];
            }
        }
        return transposedBoardFields;
    }

    private Figure[] getDiagonalBoardFields() {
        Figure[] diagonalBoardFields = new Figure[3];
        for (int i = 0; i < 3; i++) {
            diagonalBoardFields[i] = boardFields[i][i];
        }
        return diagonalBoardFields;
    }

    private Figure[] getAntidiagonalBoardFields() {
        Figure[] diagonalBoardFields = new Figure[3];
        for (int i = 0; i < 3; i++) {
            diagonalBoardFields[i] = boardFields[i][2 - i];
        }
        return diagonalBoardFields;
    }

    public void newRound() {
        Arrays.stream(boardFields).forEach(a -> Arrays.fill(a, Figure.EMPTY));
    }
}
