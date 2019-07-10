package com.github.aleksanderkot00.tictactoe.state;

public class Player {
    private String name;
    private int roundsWon;
    private Figure figure;
    private boolean computer;

    public Player(String name, int roundsWon, Figure figure, boolean computer) {
        this.name = name;
        this.roundsWon = roundsWon;
        this.figure = figure;
        this.computer = computer;
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

    public boolean isComputer() {
        return computer;
    }
}
