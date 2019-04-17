package com.kodilla;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TwoPlayersNewGameWindow {
    public static GameState display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Game");
        window.setMinWidth(820);
        window.setMinHeight(250);
        window.setMaxWidth(820);
        window.setMaxHeight(250);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label player1NameLabel = new Label("Player one name: ");
        GridPane.setConstraints(player1NameLabel,0,0);

        Label player1FiguresLabel = new Label("Player one initial  figures: ");
        GridPane.setConstraints(player1FiguresLabel,0,1);

        TextField player1NameField = new TextField("name one");
        GridPane.setConstraints(player1NameField, 1,0);

        ChoiceBox<String> figureBox1 = new ChoiceBox<>();
        figureBox1.getItems().addAll("O", "X");
        figureBox1.setValue("O");
        GridPane.setConstraints(figureBox1, 1,1);

        Label player2NameLabel = new Label("Player two name: ");
        GridPane.setConstraints(player2NameLabel,3,0);

        Label player2FiguresLabel = new Label("Player two figures: ");
        GridPane.setConstraints(player2FiguresLabel,3,1);

        TextField player2NameField = new TextField("name two");
        GridPane.setConstraints(player2NameField, 4,0);

        ChoiceBox<String> figureBox2 = new ChoiceBox<>();
        figureBox2.getItems().addAll("O", "X");
        figureBox2.setValue("X");
        GridPane.setConstraints(figureBox2, 4,1);

        figureBox1.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            if (newValue.equals("X")) {
                figureBox2.setValue("O");
            } else if (newValue.equals("O")) {
                figureBox2.setValue("X");
            }
        });

        figureBox2.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            if (newValue.equals("O")) {
                figureBox1.setValue("X");
            } else if (newValue.equals("X")) {
            figureBox1.setValue("O");
        }
        });

        Label roundsLabel = new Label("Number of rounds to win the game: ");
        GridPane.setConstraints(roundsLabel,1,4,2,1);

        ChoiceBox<Integer> roundsBox = new ChoiceBox<>();
        roundsBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        roundsBox.setValue(3);
        GridPane.setConstraints(roundsBox, 3,4);

        Button playButton = new Button("Play game");
        GridPane.setConstraints(playButton, 2, 5,2,2);
        playButton.setOnAction(e -> window.close());

        Button playWithComputer = new Button("Play with computer");
        GridPane.setConstraints(playWithComputer, 4, 4,2,2);
        playWithComputer.setOnAction(e -> {
            window.close();
            OnePlayerNewGameWindow.display();
        });

        gridPane.getChildren().addAll(player1NameLabel, player1NameField, player1FiguresLabel, figureBox1,
                player2NameLabel, player2NameField, player2FiguresLabel, figureBox2,
                roundsLabel, roundsBox, playButton,playWithComputer);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.getIcons().add(new Image("file:resources/icon.jpg"));
        window.showAndWait();

        Player player1 = new Player(player1NameField.getText(), Figure.O);
        Player player2 = new Player(player2NameField.getText(), Figure.X);
        if (figureBox1.getValue().equals(Figure.X)) {
            player1 = new Player(player1NameField.getText(), Figure.X);
            player2 = new Player(player2NameField.getText(), Figure.O);
        }
        return new GameState(player1, player2, roundsBox.getValue());
    }
}
