package com.github.aleksanderkot00.tictactoe.window;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(200);
        window.setMaxWidth(400);
        window.setMaxHeight(200);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());

        VBox layot = new VBox(10);
        layot.getChildren().addAll(label, closeButton);
        layot.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layot);
        window.setScene(scene);
        window.getIcons().add(new Image("file:src/main/resources/icon.jpg"));
        window.showAndWait();
    }
}
