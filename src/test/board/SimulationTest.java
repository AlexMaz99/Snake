package board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void getScore() {
        // given
        Simulation simulation = new Simulation(10);

        // when
        String score = simulation.getScore();

        // then
        assertEquals("1", score);
    }
}