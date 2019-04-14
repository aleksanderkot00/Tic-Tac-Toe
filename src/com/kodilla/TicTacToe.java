package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: orange;");

        Board board = new Board();
        board.setAlignment(Pos.CENTER);

        Button newGame = new Button("New game");
        newGame.setPrefSize(100, 20);
        newGame.setOnAction(e -> {
            board.restartBoard();
        });
        Button saveGame = new Button("Save game");
        saveGame.setPrefSize(100, 20);
        saveGame.setOnAction(e -> {
            board.add(new ImageView(new Image("file:resources/O.png")), 2, 2);
            board.add(new ImageView(new Image("file:resources/X.png")), 1, 2);
            board.add(new Rectangle(150, 150, Color.rgb(200, 0, 0, 0.5)), 2, 2);
            board.refreshBoard();
        });
        Button loadGame = new Button("Load game");
        loadGame.setOnAction(e -> {
            Field field = new Field();
            board.add(field,0,0);
            board.refreshBoard();
            field.setOnMouseClicked(d -> {field.setStyle("-fx-background-color: #ff5555;");});
        });
        loadGame.setPrefSize(100, 20);
        hbox.getChildren().addAll(newGame, saveGame,loadGame);

        BorderPane border = new BorderPane();
        border.setStyle("-fx-background-color: black;");
        border.setCenter(board);
        border.setTop(hbox);

        Scene scene = new Scene(border, 600, 650);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:resources/icon.jpg"));
        primaryStage.show();
    }
}
