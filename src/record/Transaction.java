package record;

public class Transaction {
    private final int price;
    private final int id;
    private final String type;

    public Transaction(int price, int id, String type) {
        this.price = price;
        this.id = id;
        this.type = type;
    }

    public void printTransaction() {
        System.out.println("| " + price + " ".repeat(9 - String.valueOf(price).length()) + "| " +
                id + " ".repeat(9 - String.valueOf(id).length()) + "| " +
                type + " ".repeat(18 - type.length()) + "|");
    }
}
