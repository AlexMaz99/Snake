package board;

import boardElements.Apple;
import boardElements.Snake;
import structures.MoveDirection;
import structures.Vector2d;

import java.util.Random;

public class Board {
    private final Vector2d lowerLeft, upperRight;
    private final int size;
    private final Snake snake;
    private Apple apple;
    Random random = new Random();
    private MoveDirection lastDirection = MoveDirection.RIGHT;
    private boolean gameFinished = false;

    public Board(int size) {
        this.size = size;
        this.lowerLeft = new Vector2d(0, 0, true);
        this.upperRight = new Vector2d(size, size, true);
        this.snake = new Snake();
        snake.longerSnake(new Vector2d(0, 0));
        setApple();
    }

    void setApple() {
        Vector2d position;
        do {
            position = new Vector2d(random.nextInt(size), random.nextInt(size), true);
        }
        while (isOccupied(position));

        this.apple = new Apple(position);
    }

    void moveAndEatApple() {
        Vector2d position = snake.tailPosition();

        if (!moveSnakeAtPosition(snake.headPosition().add(this.lastDirection.toVector()))) {
            gameFinished = true;
            return;
        }

        if (apple.getPosition().equals(snake.headPosition())) {
            apple = null;
            snake.longerSnake(position);
        }
    }

    boolean isOccupied(Vector2d position) {
        return snake.isAtPosition(position);
    }

    boolean canMove(Vector2d position) {
        return this.lowerLeft.precedes(position) && this.upperRight.follows(position) && !snake.isAtPosition(position);
    }

    public boolean moveSnakeAtPosition(Vector2d position) {
        if (canMove(position)) {
            snake.moveSnake(position);
            return true;
        }
        return false;
    }

    public void move() {
        moveAndEatApple();

        if (apple == null)
            setApple();
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void setLastDirection(MoveDirection lastDirection) {
        this.lastDirection = lastDirection;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }
}
