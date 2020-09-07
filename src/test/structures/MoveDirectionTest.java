package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveDirectionTest {

    @Test
    void toVector() {
        // given

        // when then
        assertEquals(MoveDirection.UP.toVector(), new Vector2d(0, -Vector2d.VECTOR_WIDTH));
        assertEquals(MoveDirection.DOWN.toVector(), new Vector2d(0, Vector2d.VECTOR_WIDTH));
        assertEquals(MoveDirection.RIGHT.toVector(), new Vector2d(Vector2d.VECTOR_WIDTH, 0));
        assertEquals(MoveDirection.LEFT.toVector(), new Vector2d(-Vector2d.VECTOR_WIDTH, 0));
    }
}