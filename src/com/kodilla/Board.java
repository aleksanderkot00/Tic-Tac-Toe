package com.kodilla;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(new Rectangle(140, 140, Color.BLACK), col, row);
                add(new Rectangle(130, 130, Color.WHITE), col, row);
            }
        }
    }

    public void refreshBoard() {
        for(int i =0; i < getChildren().size(); i++) {
            GridPane.setHalignment(getChildren().get(i), HPos.CENTER);
            GridPane.setValignment(getChildren().get(i), VPos.CENTER);
        }
    }
}