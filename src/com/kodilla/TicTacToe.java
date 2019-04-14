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

        Board board = new Board();
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
    }
}
