package boardElements;

import org.junit.jupiter.api.Test;
import structures.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

class AppleTest {

    @Test
    void getPosition() {
        // given
        Apple apple = new Apple(new Vector2d(5, 5));

        // when
        Vector2d position = apple.getPosition();

        // then
        assertEquals(new Vector2d(5, 5), position);
    }
}