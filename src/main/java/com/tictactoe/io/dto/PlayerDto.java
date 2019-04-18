package com.tictactoe.io.dto;

import com.tictactoe.state.Figure;

public class PlayerDto {
    private String name;
    private int roundsWon;
    private Figure figure;

    public PlayerDto(String name, int roundsWon, Figure figure) {
        this.name = name;
        this.roundsWon = roundsWon;
        this.figure = figure;
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
}
