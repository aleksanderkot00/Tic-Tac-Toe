package com.github.aleksanderkot00.tictactoe.io.dto;

import com.github.aleksanderkot00.tictactoe.state.Figure;

public class PlayerDto {
    private String name;
    private int roundsWon;
    private Figure figure;
    private boolean computer;

    public PlayerDto(String name, int roundsWon, Figure figure, boolean computer) {
        this.name = name;
        this.roundsWon = roundsWon;
        this.figure = figure;
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public Figure getFigure() {
        return figure;
    }

    public boolean isComputer() {
        return computer;
    }
}
