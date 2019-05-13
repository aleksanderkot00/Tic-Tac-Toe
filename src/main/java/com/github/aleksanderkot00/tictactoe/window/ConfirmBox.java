package com.github.aleksanderkot00.tictactoe.window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(200);
        window.setMaxWidth(400);
        window.setMaxHeight(200);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(yesButton, noButton);

        VBox layot = new VBox(10);
        hBox.setAlignment(Pos.CENTER);
        layot.getChildren().addAll(label, hBox);
        layot.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layot);
        window.setScene(scene);
        window.getIcons().add(new Image("file:src/main/resources/icon.jpg"));
        window.showAndWait();

        return answer;
    }
}
