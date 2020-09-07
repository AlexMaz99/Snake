package structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    @Test
    void levelFromString() {
        // given
        String easy = "Easy";

        // when
        Level level = Level.levelFromString(easy);

        // then
        assertEquals(level, Level.EASY);
    }

    @Test
    void getValue() {
        // given
        Level easy = Level.EASY;

        // when
        int easyValue = easy.getValue();

        // then
        assertEquals(360, easyValue);
    }
}