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
            case EASY -> 360;
            case MEDIUM -> 240;
            case DIFFICULT -> 120;
        };
    }
}
