package com.github.aleksanderkot00.tictactoe.io.dto;

import com.github.aleksanderkot00.tictactoe.state.Figure;

public class GameStateDto {

    private PlayerDto playerOne;
    private PlayerDto playerTwo;
    private int numberOfDraws;
    private int roundsToWin;
    private Figure[] roundState;

    public GameStateDto(PlayerDto playerOne, PlayerDto playerTwo, int numberOfDraws,
                        int roundsToWin, Figure[] roundState) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.numberOfDraws = numberOfDraws;
        this.roundsToWin = roundsToWin;
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

    public Figure[] getRoundState() {
        return roundState;
    }
}
