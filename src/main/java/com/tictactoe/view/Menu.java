package com.tictactoe.view;

import com.tictactoe.window.ConfirmBox;
import com.tictactoe.window.NewGameWindow;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Menu extends HBox {

    public Menu(Board board, Stage primaryStage) {

        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        setStyle("-fx-background-color: orange;");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100, 20);
        newGame.setOnAction(e -> {
            boolean answer = ConfirmBox.display("New game confirmation",
                    "Are you sure you want to play new game?");
            if (answer) {
                board.setGameState(NewGameWindow.display());
                board.createBoard();
            }
        });

        Button saveGame = new Button("Save game");
        saveGame.setPrefSize(100, 20);
        saveGame.setOnAction(e -> {
            File file = createFileChooser().showSaveDialog(primaryStage);
            if (file != null) {
                board.save(file);
            }
        });

        Button loadGame = new Button("Load game");
        loadGame.setPrefSize(100, 20);
        loadGame.setOnAction(e -> {
            File file = createFileChooser().showOpenDialog(primaryStage);
            if (file != null) {
                board.load(file);
            }
        });

        getChildren().addAll(newGame, saveGame, loadGame);
    }

    private FileChooser createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }
}
