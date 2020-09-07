package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void precedes() {
        // given
        Vector2d vector1 = new Vector2d(5, 6);
        Vector2d vector2 = new Vector2d(6, 6);

        // when then
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void follows() {
        // given
        Vector2d vector1 = new Vector2d(6, 6);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertTrue(vector1.follows(vector2));
    }

    @Test
    void upperRight() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.upperRight(vector2), new Vector2d(5, 7));
    }

    @Test
    void lowerLeft() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.lowerLeft(vector2), new Vector2d(4, 6));
    }

    @Test
    void add() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.add(vector2), new Vector2d(9, 13));

    }

    @Test
    void subtract() {
        // given
        Vector2d vector1 = new Vector2d(4, 7);
        Vector2d vector2 = new Vector2d(5, 6);

        // when then
        assertEquals(vector1.subtract(vector2), new Vector2d(-1, 1));
    }

    @Test
    void opposite() {
        // given
        Vector2d vector2d = new Vector2d(5, 6);

        // when then
        assertEquals(vector2d.opposite(), new Vector2d(-5, -6));

    }
}