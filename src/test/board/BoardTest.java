package board;

import org.junit.jupiter.api.Test;
import structures.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void setApple() {
        // given
        Board board = new Board(5);

        // when
        board.setApple();

        // then
        assertNotNull(board.getApple());
    }

    @Test
    void isOccupied() {
        // given
        Board board = new Board(5);
        Vector2d occupiedPosition = new Vector2d(0, 0);
        Vector2d freePosition = new Vector2d(0, 1);

        // when then
        assertTrue(board.isOccupied(occupiedPosition));
        assertFalse(board.isOccupied(freePosition));
    }

    @Test
    void canMove() {
        // given
        Board board = new Board(5);
        Vector2d goodPosition = new Vector2d(4, 4);
        Vector2d badPosition = new Vector2d(-1, -1);

        // when then
        assertTrue(board.canMove(goodPosition));
        assertFalse(board.canMove(badPosition));
    }

    @Test
    void moveSnakeAtGoodPosition() {
        // given
        Board board = new Board(5);
        Vector2d position = new Vector2d(1, 0);

        // when then
        assertTrue(board.moveSnakeAtPosition(position));
        assertTrue(board.getSnake().isAtPosition(position));
    }

    @Test
    void moveSnakeAtBadPosition() {
        // given
        Board board = new Board(5);
        Vector2d position = new Vector2d(-1, 0);

        // when then
        assertFalse(board.moveSnakeAtPosition(position));
        assertFalse(board.getSnake().isAtPosition(position));
    }

    @Test
    void moveAndEatApple() {
        // given
        Board board = new Board(5);
        Vector2d position = new Vector2d(Vector2d.VECTOR_WIDTH, 0);

        // when
        board.moveAndEatApple();

        // then
        assertTrue(board.isOccupied(position));
        assertFalse(board.getSnake().isAtPosition(new Vector2d(0, 0)));
    }

    @Test
    void move() {
        // given
        Board board = new Board(5);

        // when
        board.move();

        // then
        assertNotNull(board.getApple());
        assertTrue(board.isOccupied(new Vector2d(Vector2d.VECTOR_WIDTH, 0)));
    }
}