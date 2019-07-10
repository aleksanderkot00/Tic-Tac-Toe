package com.github.aleksanderkot00.tictactoe;

import com.github.aleksanderkot00.tictactoe.window.NewGameWindow;
import com.github.aleksanderkot00.tictactoe.state.GameState;
import com.github.aleksanderkot00.tictactoe.view.Board;
import com.github.aleksanderkot00.tictactoe.view.Menu;
import com.github.aleksanderkot00.tictactoe.window.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GameState gameState = NewGameWindow.display();

        Board board = new Board(gameState);
        board.setAlignment(Pos.CENTER);

        Menu menu = new Menu(primaryStage);

        menu.addListener((actionType, param) -> {
            switch (actionType) {
                case "NEW":
                    board.setGameState(NewGameWindow.display());
                    board.createBoard();
                    break;
                case "SAVE":
                    board.save((File) param);
                    break;
                case "LOAD":
                    board.load((File) param);
            }

        });

        Scene scene = getScene(board, menu);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:src/main/resources/icon.jpg"));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            boolean answer = ConfirmBox.display("Close the game",
                    "Are you sure you want to end the game?");
            if (answer) {
                primaryStage.close();
            }
        });
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }

    private Scene getScene(Board board, Menu menu) {
        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color: black;");
        border.setCenter(board);
        border.setTop(menu);
        return new Scene(border, 800, 650);
    }
}
