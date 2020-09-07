package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import structures.MoveDirection;

public class GameStage extends Application {
    private GameScene gameScene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Snake");
        stage.setOnCloseRequest(actionEvent -> {
            System.exit(0);
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        Label label = new Label("Hello in Snake! Choose the difficulty level");
        gridPane.add(label, 0, 0);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Easy");
        choiceBox.getItems().add("Medium");
        choiceBox.getItems().add("Difficult");

        gridPane.add(choiceBox, 0, 3);
        GridPane.setHalignment(choiceBox, HPos.CENTER);

        Button startGameButton = new Button("Start");

        startGameButton.setOnAction(actionEvent -> {
            this.gameScene = new GameScene(new Group(), choiceBox.getValue());
            stage.setScene(gameScene);

            gameScene.setOnKeyPressed(keyEvent -> {
                switch (keyEvent.getCode()) {
                    case LEFT -> gameScene.getSimulation().getBoard().setMoveDirection(MoveDirection.LEFT);
                    case RIGHT -> gameScene.getSimulation().getBoard().setMoveDirection(MoveDirection.RIGHT);
                    case DOWN -> gameScene.getSimulation().getBoard().setMoveDirection(MoveDirection.DOWN);
                    case UP -> gameScene.getSimulation().getBoard().setMoveDirection(MoveDirection.UP);
                }
            });

            gameScene.startGame();
        });

        gridPane.add(startGameButton, 0, 5);
        GridPane.setHalignment(startGameButton, HPos.CENTER);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        stage.show();
    }
}
