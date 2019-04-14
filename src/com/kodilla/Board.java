 package com.kodilla;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;

public class Board extends GridPane {

    private BoardField[][] boardFields = new BoardField[3][3];

    public Board() {
        restartBoard();
    }

    public int getNumberOfMoves() {
        return (int) Arrays.stream(boardFields).
                flatMap(bf -> Arrays.stream(bf)).
                filter(bf -> ! bf.equals(BoardField.EMPTY)).
                count();
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            setHalignment(getChildren().get(i), HPos.CENTER);
            setValignment(getChildren().get(i), VPos.CENTER);
        }
    }

    public void restartBoard() {
        while(getChildren().size() > 0){
            getChildren().remove(0);
        }
        Arrays.stream(boardFields).forEach(a -> Arrays.fill(a, BoardField.EMPTY));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(new Rectangle(160, 160, Color.BLACK), col, row);
                Field field = new Field();
                add(field, col, row);
                field.setOnMouseClicked(d -> {
                    if (getNumberOfMoves() % 2 == 0 &&
                            boardFields[getColumnIndex(field)][getRowIndex(field)].equals(BoardField.EMPTY)) {
                        add(new ImageView(new Image("file:resources/O.png")), getColumnIndex(field), getRowIndex(field));
                        boardFields[getColumnIndex(field)][getRowIndex(field)] = BoardField.O;
                        refreshBoard();
                    } else if (boardFields[getColumnIndex(field)][getRowIndex(field)].equals(BoardField.EMPTY)) {
                        add(new ImageView(new Image("file:resources/X.png")), getColumnIndex(field), getRowIndex(field));
                        boardFields[getColumnIndex(field)][getRowIndex(field)] = BoardField.X;
                        refreshBoard();
                    }
                });
                refreshBoard();
            }
        }
    }
}