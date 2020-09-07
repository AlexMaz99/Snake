package boardElements;

import structures.Vector2d;

public class Apple {
    private final Vector2d position;

    public Apple(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }
}
