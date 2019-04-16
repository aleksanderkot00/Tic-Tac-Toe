package com.kodilla;

public class GameStateVerifier {
    public static boolean isRoundOver(GameState gameState) {
        boolean isRoundOver = true;
        if (gameState.getRoundState().hasFigureWon(BoardFieldState.O)) {
            AlertBox.display("End of round", gameState.getPlayerOneName() + " won this round!");
        } else if (gameState.getRoundState().hasFigureWon(BoardFieldState.X)) {
            AlertBox.display("End of round", gameState.getPlayerTwoName() + " won this round!");
        } else if (gameState.getRoundState().isDraw()) {
            AlertBox.display("End of round", "Draw!");
        } else {
            isRoundOver = false;
        }
        return isRoundOver;
    }
}
