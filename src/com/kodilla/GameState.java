package com.kodilla;

public class GameState {

    private String playerOneName;
    private String playerTwoName;
    private int playerOneRoundsWon;
    private int playerTwoRoundsWon;
    private int numberOfDraws;
    private RoundState roundState;


    public GameState(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        playerOneRoundsWon = 0;
        playerTwoRoundsWon = 0;
        roundState = new RoundState();
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getPlayerOneRoundsWon() {
        return playerOneRoundsWon;
    }

    public int getPlayerTwoRoundsWon() {
        return playerTwoRoundsWon;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public RoundState getRoundState() {
        return roundState;
    }
}
