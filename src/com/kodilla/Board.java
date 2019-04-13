package com.kodilla;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends GridPane {

    public Board() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                add(new Rectangle(140, 140, Color.valueOf("#336699")), col, row);
                if (col > 0 && col < 4 && row > 0 && row < 4) {
                    add(new Rectangle(130, 130, Color.WHITE), col, row);
                }
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