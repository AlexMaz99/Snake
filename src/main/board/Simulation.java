package board;

public class Simulation {
    private final Board board;

    public Simulation(int size) {
        this.board = new Board(size);
    }

    public Board getBoard() {
        return board;
    }

    public String getScore() {
        return board.getSnake().getLength() + "";
    }
}
