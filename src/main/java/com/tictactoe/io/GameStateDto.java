package com.tictactoe.io;

import com.tictactoe.state.Figure;

public class GameStateDto {

    private String playerOneName;
    private int playerOneRoundsWon;
    private Figure playerOneFigure;
    private String playerTwoName;
    private int playerTwoRoundsWon;
    private Figure playerTwoFigure;
    private int numberOfDraws;
    private int roundsToWin;
    private boolean isPlayerTwoComputer;
    private Figure[] roundState;

    public GameStateDto(String playerOneName, int playerOneRoundsWon, Figure playerOneFigure,
                        String playerTwoName, int playerTwoRoundsWon, Figure playerTwoFigure,
                        int numberOfDraws, int roundsToWin, boolean isPlayerTwoComputer,
                        Figure[] roundState) {
        this.playerOneName = playerOneName;
        this.playerOneRoundsWon = playerOneRoundsWon;
        this.playerOneFigure = playerOneFigure;
        this.playerTwoName = playerTwoName;
        this.playerTwoRoundsWon = playerTwoRoundsWon;
        this.playerTwoFigure = playerTwoFigure;
        this.numberOfDraws = numberOfDraws;
        this.roundsToWin = roundsToWin;
        this.isPlayerTwoComputer = isPlayerTwoComputer;
        this.roundState = roundState;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public int getPlayerOneRoundsWon() {
        return playerOneRoundsWon;
    }

    public Figure getPlayerOneFigure() {
        return playerOneFigure;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getPlayerTwoRoundsWon() {
        return playerTwoRoundsWon;
    }

    public Figure getPlayerTwoFigure() {
        return playerTwoFigure;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getRoundsToWin() {
        return roundsToWin;
    }

    public boolean isPlayerTwoComputer() {
        return isPlayerTwoComputer;
    }

    public Figure[] getRoundState() {
        return roundState;
    }
}
