package com.kodilla;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Field extends Label {
    public Field() {
        setAlignment(Pos.CENTER);
        setMinSize(150, 150);
        setMaxSize(150, 150);
        setStyle("-fx-background-color: white;");
    }
}
