package structures;

public enum Level {
    EASY, MEDIUM, DIFFICULT;


    public static Level levelFromString(String level) {
        return switch (level) {
            case "Easy" -> EASY;
            case "Medium" -> MEDIUM;
            case "Difficult" -> DIFFICULT;
            default -> throw new IllegalStateException("Unexpected value: " + level);
        };
    }

    public int getValue() {
        return switch (this) {
            case EASY -> 500;
            case MEDIUM -> 280;
            case DIFFICULT -> 120;
        };
    }
}
