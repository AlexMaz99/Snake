package structures;

public enum MoveDirection {
    RIGHT, LEFT, UP, DOWN;

    // UP and DOWN are the other way because of javafx board
    public Vector2d toVector() {
        return switch (this) {
            case UP -> new Vector2d(0, -Vector2d.VECTOR_WIDTH);
            case DOWN -> new Vector2d(0, Vector2d.VECTOR_WIDTH);
            case RIGHT -> new Vector2d(Vector2d.VECTOR_WIDTH, 0);
            case LEFT -> new Vector2d(-Vector2d.VECTOR_WIDTH, 0);
        };
    }
}
