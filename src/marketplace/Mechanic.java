package marketplace;

public class Mechanic {
    private final float price;
    private final int repairProbability;
    private final int damageProbability;
    private final String name;

    public float getPrice() {
        return price;
    }

    public Mechanic(float price, int repairProbability, int damageProbability, String name) {
        this.price = price;
        this.repairProbability = repairProbability;
        this.damageProbability = damageProbability;
        this.name = name;
    }

    public void printMechanicData() {
        System.out.println("| " + name + " ".repeat(9 - String.valueOf(name).length()) + "| " +
                price + " ".repeat(12 - String.valueOf(price).length()) + "| " +
                repairProbability + " ".repeat(21 - String.valueOf(repairProbability).length()) + "| " +
                damageProbability + " ".repeat(15 - String.valueOf(damageProbability).length()) + "|");
    }
}
