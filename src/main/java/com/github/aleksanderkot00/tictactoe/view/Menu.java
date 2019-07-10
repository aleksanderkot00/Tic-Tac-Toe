package com.github.aleksanderkot00.tictactoe.view;

import com.github.aleksanderkot00.tictactoe.window.ConfirmBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Menu extends HBox {

    public interface MenuListener {
        void onManuAction(String actionType, Object param);
    }

    private List<MenuListener> listeners = new ArrayList<>();

    public Menu(Stage primaryStage) {

        setPadding(new Insets(15, 12, 15, 12));
        setSpacing(10);
        setStyle("-fx-background-color: orange;");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100, 20);

        newGame.setOnAction(e -> {
            boolean answer = ConfirmBox.display("New game confirmation",
                    "Are you sure you want to play new game?");
            if (answer) {
                listeners.forEach(c -> {
                    c.onManuAction("NEW", null);
                });
            }
        });

        Button saveGame = new Button("Save game");
        saveGame.setPrefSize(100, 20);

        saveGame.setOnAction(e -> {
            File file = createFileChooser().showSaveDialog(primaryStage);
            if (file != null) {
                listeners.forEach(l -> {
                    l.onManuAction("SAVE", file);
                });
            }
        });

        Button loadGame = new Button("Load game");
        loadGame.setPrefSize(100, 20);
        loadGame.setOnAction(e -> {
            File file = createFileChooser().showOpenDialog(primaryStage);
            if (file != null) {
                listeners.forEach(l -> {
                    l.onManuAction("LOAD", file);
                });
            }
        });

        getChildren().addAll(newGame, saveGame, loadGame);
    }

    public void addListener(MenuListener menuListener) {
        this.listeners.add(menuListener);
    }

    private FileChooser createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }
}
