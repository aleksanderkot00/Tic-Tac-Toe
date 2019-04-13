package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button newGame = new Button("New game");
        newGame.setPrefSize(100, 20);
        Button saveGame = new Button("Save game");
        saveGame.setPrefSize(100, 20);
        hbox.getChildren().addAll(newGame, saveGame);


        Board board = new Board();
        board.setAlignment(Pos.CENTER);
        board.refreshBoard();

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 0, 10, 10));


        BorderPane border = new BorderPane();
        border.setCenter(board);
        border.setTop(hbox);
        border.setLeft(vBox);

        Scene scene = new Scene(border, 800, 600);

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
