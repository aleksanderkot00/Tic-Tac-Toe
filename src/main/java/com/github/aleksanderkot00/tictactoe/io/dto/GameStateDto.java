package com.github.aleksanderkot00.tictactoe.io.dto;

import com.github.aleksanderkot00.tictactoe.state.Figure;

public class GameStateDto {

    private PlayerDto playerOne;
    private PlayerDto playerTwo;
    private int numberOfDraws;
    private int roundsToWin;
    private boolean isPlayerTwoComputer;
    private Figure[] roundState;

    public GameStateDto(PlayerDto playerOne, PlayerDto playerTwo, int numberOfDraws,
                        int roundsToWin, boolean isPlayerTwoComputer, Figure[] roundState) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.numberOfDraws = numberOfDraws;
        this.roundsToWin = roundsToWin;
        this.isPlayerTwoComputer = isPlayerTwoComputer;
        this.roundState = roundState;
    }

    public PlayerDto getPlayerOne() {
        return playerOne;
    }

    public PlayerDto getPlayerTwo() {
        return playerTwo;
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
