package com.tictactoe.state;

import java.util.Random;

public class ComputerMoveGenerator {

    public int GenerateMove(RoundState roundState) {
        int emptyFieldsNumber = 9 - roundState.getNumberOfMoves();
        if (emptyFieldsNumber == 0) {
            return -1;
        }
        int[] emptyFieldsIndex = new int[emptyFieldsNumber];
        int i = 0;
        for (int col = 0; col < 3; col++ ) {
            for (int row = 0; row < 3; row++ ) {
                if (roundState.getBoardFields()[row][col].equals(Figure.EMPTY)) {
                    emptyFieldsIndex[i] = 3 * col + row;
                    i++;
                }
            }
        }
        Random generator = new Random();
        return emptyFieldsIndex[generator.nextInt(emptyFieldsNumber)];
    }
}
