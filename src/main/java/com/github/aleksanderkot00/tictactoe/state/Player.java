package com.github.aleksanderkot00.tictactoe.state;

public class Player {
    private String name;
    private int roundsWon;
    private Figure figure;

    public Player(String name, Figure figure) {
        this.name = name;
        roundsWon = 0;
        this.figure = figure;
    }

    public Player(String name, int roundsWon, Figure figure) {
        this.name = name;
        this.roundsWon = roundsWon;
        this.figure = figure;
    }

    public void figureChange() {
        if (figure.equals(Figure.X)) {
            figure = Figure.O;
        } else if (figure.equals(Figure.O)) {
            figure = Figure.X;
        }
    }

    public void win() {
        roundsWon++;
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
