package enums;

public enum Color {
    Black,
    Red,
    White,
    Yellow,
    Blue,
    Purple,
    Silver,
    Green,
    Graphite;

    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
