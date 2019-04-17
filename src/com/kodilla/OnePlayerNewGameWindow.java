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

public class OnePlayerNewGameWindow {
    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Game");
        window.setMinWidth(520);
        window.setMinHeight(300);
        window.setMaxWidth(520);
        window.setMaxHeight(300);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label playerNameLabel = new Label("Player name: ");
        GridPane.setConstraints(playerNameLabel,0,0);

        Label playerFiguresLabel = new Label("Player initial figures: ");
        GridPane.setConstraints(playerFiguresLabel,0,1);

        Label computerLevelLabel = new Label("Difficulty level: ");
        GridPane.setConstraints(computerLevelLabel,0,2);

        TextField playerNameField = new TextField("name");
        GridPane.setConstraints(playerNameField, 1,0);

        ChoiceBox<String> figureBox = new ChoiceBox<>();
        figureBox.getItems().addAll("O", "X");
        figureBox.setValue("O");
        GridPane.setConstraints(figureBox, 1,1);
        
        ChoiceBox<String> computerLevelBox = new ChoiceBox<>();
        computerLevelBox.getItems().addAll("Easy", "Medium", "Hard");
        computerLevelBox.setValue("Medium");
        GridPane.setConstraints(computerLevelBox, 1,2);

        Label roundsLabel = new Label("Number of rounds to win the game: ");
        GridPane.setConstraints(roundsLabel,0,3);

        ChoiceBox<Integer> roundsBox = new ChoiceBox<>();
        roundsBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        roundsBox.setValue(3);
        GridPane.setConstraints(roundsBox, 1,3);

        Button playButton = new Button("Play game");
        GridPane.setConstraints(playButton, 0, 6);
        playButton.setOnAction(e -> window.close());

        Button twoPlayersGame = new Button("Two players game");
        GridPane.setConstraints(twoPlayersGame, 1, 5,2,2);
        twoPlayersGame.setOnAction(e -> {
            window.close();
            TwoPlayersNewGameWindow.display();
        });

        gridPane.getChildren().addAll(playerNameLabel, playerNameField, playerFiguresLabel, figureBox, computerLevelLabel,
                computerLevelBox, roundsLabel, roundsBox, playButton,twoPlayersGame);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.getIcons().add(new Image("file:resources/icon.jpg"));
        window.showAndWait();
    }
}
