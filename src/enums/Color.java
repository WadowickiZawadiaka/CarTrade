package enums;

public enum Color {
    Black,
    Red,
    White;

    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
