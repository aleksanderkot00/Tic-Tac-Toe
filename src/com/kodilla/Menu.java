package com.kodilla;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Menu extends HBox {

    private Board board;

    public Menu(Board board) {
        this.board = board;

        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        setStyle("-fx-background-color: orange;");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100, 20);
        newGame.setOnAction(e -> {
            board.restartBoard();
        });
        Button saveGame = new Button("Save game");
        saveGame.setPrefSize(100, 20);
        saveGame.setOnAction(e -> {

        });
        Button loadGame = new Button("Load game");
        loadGame.setOnAction(e -> {

        });
        loadGame.setPrefSize(100, 20);
        getChildren().addAll(newGame, saveGame,loadGame);
    }
}
