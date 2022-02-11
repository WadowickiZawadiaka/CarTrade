package record;

public class Repair {
    private final int price;
    private final int carId;
    private final int partId;

    public Repair(int price, int carId, int partId) {
        this.price = price;
        this.carId = carId;
        this.partId = partId;
    }

    public void print() {
        System.out.println("| " + price + " ".repeat(9 - String.valueOf(price).length()) + "| " +
                carId + " ".repeat(9 - String.valueOf(carId).length()) + "| " +
                partId + " ".repeat(10 - String.valueOf(partId).length()) + "|");
    }
}