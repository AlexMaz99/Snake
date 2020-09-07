package boardElements;

import org.junit.jupiter.api.Test;
import structures.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @Test
    void headPosition() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));
        snake.getPositions().add(new Vector2d(1, 2));

        // when
        Vector2d headPosition = snake.headPosition();

        // then
        assertEquals(headPosition, new Vector2d(1, 3));
    }

    @Test
    void tailPosition() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));
        snake.getPositions().add(new Vector2d(1, 2));
        snake.getPositions().add(new Vector2d(2, 1));

        // when
        Vector2d tailPosition = snake.tailPosition();

        // then
        assertEquals(tailPosition, new Vector2d(2, 1));
    }

    @Test
    void getLength() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));
        snake.getPositions().add(new Vector2d(1, 2));
        snake.getPositions().add(new Vector2d(2, 2));
        snake.getPositions().add(new Vector2d(2, 1));

        // when
        int length = snake.getLength();

        // then
        assertEquals(4, length);
    }

    @Test
    void isAtPosition() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));

        // when then
        assertTrue(snake.isAtPosition(new Vector2d(1, 3)));
        assertFalse(snake.isAtPosition(new Vector2d(0, 0)));
    }

    @Test
    void moveSnake() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));
        snake.getPositions().add(new Vector2d(1, 2));
        snake.getPositions().add(new Vector2d(2, 2));
        snake.getPositions().add(new Vector2d(2, 1));
        Vector2d position = new Vector2d(1, 4);

        // when
        snake.moveSnake(position);

        // then
        assertTrue(snake.isAtPosition(position));
        assertTrue(snake.isAtPosition(new Vector2d(1, 3)));
        assertTrue(snake.isAtPosition(new Vector2d(1, 2)));
        assertTrue(snake.isAtPosition(new Vector2d(2, 2)));
        assertFalse(snake.isAtPosition(new Vector2d(2, 1)));
    }

    @Test
    void longerSnake() {
        // given
        Snake snake = new Snake();
        snake.getPositions().add(new Vector2d(1, 3));
        snake.getPositions().add(new Vector2d(1, 2));
        snake.getPositions().add(new Vector2d(2, 2));
        snake.getPositions().add(new Vector2d(2, 1));
        Vector2d position = new Vector2d(1, 4);

        // when
        snake.longerSnake(position);

        // then
        assertTrue(snake.isAtPosition(position));
        assertEquals(snake.tailPosition(), position);
    }


}