package gui;

import board.Simulation;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import structures.Level;
import structures.Vector2d;

import java.util.Timer;
import java.util.TimerTask;

import java.util.HashMap;

import static structures.Vector2d.VECTOR_WIDTH;

public class GameScene extends Scene {
    private static final int size = 20;
    private final HashMap<Vector2d, Rectangle> rectangles = new HashMap<>();
    private Simulation simulation;
    private final Level level;
    private Timer timer;
    private final Text endGameText;
    private final Text scoreText;
    private int theBestScore = 0;

    public GameScene(Group group, String level) {
        super(group, size * VECTOR_WIDTH, size * VECTOR_WIDTH + 4 * VECTOR_WIDTH);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle rectangle = new Rectangle(VECTOR_WIDTH, VECTOR_WIDTH);
                rectangle.setHeight(VECTOR_WIDTH);
                rectangle.setWidth(VECTOR_WIDTH);
                rectangle.setArcHeight(1);
                rectangle.setArcWidth(1);
                rectangle.setFill(Color.GAINSBORO);
                rectangle.setX(i * VECTOR_WIDTH);
                rectangle.setY(j * VECTOR_WIDTH);

                rectangles.put(new Vector2d((int) rectangle.getX(), (int) rectangle.getY()), rectangle);
                group.getChildren().add(rectangle);
            }
        }
        this.level = Level.levelFromString(level);
        this.simulation = new Simulation(size);
        Rectangle rectangle = rectangles.get(this.simulation.getBoard().getSnake().headPosition());
        rectangle.setFill(Color.DARKGREEN);

        rectangle = rectangles.get(this.simulation.getBoard().getApple().getPosition());
        rectangle.setFill(Color.RED);

        scoreText = new Text("Your score: " + this.simulation.getScore() + "\t The best score: " + theBestScore);
        scoreText.setX(size * VECTOR_WIDTH / 2 - 5 * VECTOR_WIDTH);
        scoreText.setY(size * VECTOR_WIDTH + VECTOR_WIDTH);
        scoreText.setFill(Color.BLACK);
        scoreText.setFont(new Font(12));
        group.getChildren().add(scoreText);

        endGameText = new Text("Game over\n Try again");
        endGameText.setX(size * VECTOR_WIDTH / 2 - 2 * VECTOR_WIDTH);
        endGameText.setY(size * VECTOR_WIDTH + 2 * VECTOR_WIDTH);
        endGameText.setFill(Color.WHITE);
        endGameText.setFont(new Font(12));
        endGameText.setOnMouseClicked(mouseEvent -> {
            newGame();
        });
        endGameText.setStrokeWidth(1);
        group.getChildren().add(endGameText);
    }

    void refreshScene() {
        for (Vector2d position : rectangles.keySet()) {
            Rectangle rectangle = rectangles.get(position);
            if (simulation.getBoard().getSnake().isAtPosition(position)) {
                if (simulation.getBoard().getSnake().headPosition().equals(position))
                    rectangle.setFill(Color.DARKGREEN);
                else
                    rectangle.setFill(Color.GREEN);
            } else if (simulation.getBoard().getApple().getPosition().equals(position)) {
                rectangle.setFill(Color.RED);
            } else
                rectangle.setFill(Color.GAINSBORO);
        }
        scoreText.setText("Your score: " + this.simulation.getScore() + "\t The best score: " + theBestScore);
    }

    void startGame() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (simulation.getBoard().isGameFinished()) {
                        refreshScene();
                        endGame();
                    } else {
                        simulation.getBoard().move();
                        refreshScene();
                    }
                });
            }
        }, 0, this.level.getValue());
    }

    void endGame() {
        timer.cancel();
        if (Integer.parseInt(simulation.getScore()) > theBestScore) {
            theBestScore = Integer.parseInt(simulation.getScore());
            scoreText.setText("Your score: " + this.simulation.getScore() + "\t The best score: " + theBestScore);
        }
        endGameText.setFill(Color.BLACK);
        endGameText.setStroke(Color.BLACK);
    }

    void newGame() {
        this.simulation = new Simulation(size);
        endGameText.setFill(Color.WHITE);
        endGameText.setStroke(Color.WHITE);
        startGame();
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public static int getSize() {
        return size;
    }

    public HashMap<Vector2d, Rectangle> getRectangles() {
        return rectangles;
    }
}
