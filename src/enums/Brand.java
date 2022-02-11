package enums;

public enum Brand {
    BMW(2.4f),
    Audi(2.5f),
    Nissan(1.5f),
    Skoda(1.2f),
    Ford(3.0f);

    private final float priceMultiply;

    Brand(float priceMultiply) {
        this.priceMultiply = priceMultiply;
    }

    public static Brand getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public float getPriceMultiply() {
        return priceMultiply;
    }
}
