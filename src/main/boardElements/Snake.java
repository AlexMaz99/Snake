package boardElements;

import structures.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final List<Vector2d> positions;

    public Snake() {
        this.positions = new ArrayList<>();
    }

    public void moveSnake(Vector2d position) {
        for (int i = positions.size() - 1; i >= 1; i--)
            positions.set(i, positions.get(i - 1));
        positions.set(0, position);
    }

    public void longerSnake(Vector2d position) {
        positions.add(position);
    }

    public boolean isAtPosition(Vector2d position) {
        return positions.contains(position);
    }

    public Vector2d headPosition(){
        return positions.get(0);
    }

    public Vector2d tailPosition(){
        return positions.get(positions.size() - 1);
    }

    public int getLength(){
        return positions.size();
    }
}
