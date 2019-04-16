package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Player player1 = new Player("Player1",Figure.O);
        Player player2 = new Player("Player2",Figure.X);

        Board board = new Board(new GameState(player1, player2, 1));
        board.setAlignment(Pos.CENTER);
        Menu menu = new Menu(board);

        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color: black;");
        border.setCenter(board);
        border.setTop(menu);

        Scene scene = new Scene(border, 600, 650);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:resources/icon.jpg"));
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }
}
