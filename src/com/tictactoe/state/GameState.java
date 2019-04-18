 package com.tictactoe.state;

 import com.tictactoe.window.AlertBox;

 public class GameState {

    private Player playerOne;
    private Player playerTwo;
    private int roundsToWin;
    private RoundState roundState;
    private boolean isPlayerTwoComputer;

    public GameState(Player playerOne, Player playerTwo, int roundsToWin, boolean isPlayerTwoComputer) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.roundsToWin = roundsToWin;
        this.isPlayerTwoComputer = isPlayerTwoComputer;
        roundState = new RoundState();
    }

    public void drawRound() {
        changeOfFigures();
    }

    public void playerOneWonRound() {
        playerOne.win();
        changeOfFigures();
    }

    public void playerTwoWonRound() {
        playerTwo.win();
        changeOfFigures();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void changeOfFigures() {
        playerOne.figureChange();
        playerTwo.figureChange();
    }

    public RoundState getRoundState() {
        return roundState;
    }

    public boolean isRoundOver() {
        boolean isRoundOver = true;
        if (roundState.hasFigureWon(getPlayerOne().getFigure())) {
            AlertBox.display("End of the round", getPlayerOne().getName() + " won this round!");
            playerOneWonRound();
        } else if (getRoundState().hasFigureWon(getPlayerTwo().getFigure())) {
            AlertBox.display("End of the round", getPlayerTwo().getName() + " won this round!");
            playerTwoWonRound();
        } else if (getRoundState().isDraw()) {
            AlertBox.display("End of the round", "Draw!");
            drawRound();
        } else {
            isRoundOver = false;
        }
        return isRoundOver;
    }

    public boolean isGameOver() {
        if (playerOne.getRoundsWon()  < roundsToWin && playerTwo.getRoundsWon()  < roundsToWin) {
            return false;
        }
        String winnerName;
        if (playerOne.getRoundsWon() > playerTwo.getRoundsWon()) {
            winnerName = playerOne.getName();
        } else {
            winnerName = playerTwo.getName();
        }
        AlertBox.display("End of game", winnerName + " won this game!");
        return true;
    }

     public int getRoundsToWin() {
         return roundsToWin;
     }

     public boolean isPlayerTwoComputer() {
        return isPlayerTwoComputer;
    }
}
