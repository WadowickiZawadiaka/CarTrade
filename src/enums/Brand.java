package enums;

public enum Brand {
    BMW(2.4f),
    Audi(2.5f),
    Nissan(1.5f),
    Skoda(1.2f),
    Ford(3.0f),
    Mercedes(3.2f),
    Volvo(1.2f),
    Mazda(5.1f),
    Toyota(2.2f),
    Volkswagen(1.9f),
    Porsche(3.1f);


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
