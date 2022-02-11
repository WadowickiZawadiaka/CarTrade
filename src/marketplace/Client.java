package marketplace;

import enums.Brand;

public class Client {
    private int balance;
    private final boolean damage;
    private final String vehicleType;
    private final int id;
    private final Brand brand_1;
    private final Brand brand_2;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isDamage() {
        return damage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Brand getBrand_1() {
        return brand_1;
    }

    public Brand getBrand_2() {
        return brand_2;
    }

    public Client(int balance, boolean damage, String vehicleType, int id, Brand brand_1, Brand brand_2) {
        this.balance = balance;
        this.damage = damage;
        this.vehicleType = vehicleType;
        this.id = id;
        this.brand_1 = brand_1;
        this.brand_2 = brand_2;
    }

    public void print() {
        System.out.println("| " + id + " ".repeat(5 - String.valueOf(id).length()) + "| " +
                balance + " ".repeat(9 - String.valueOf(balance).length()) + "| " +
                vehicleType + " ".repeat(11 - vehicleType.length()) + "| " +
                damage + " ".repeat(12 - String.valueOf(damage).length()) + "| " +
                brand_1 + " ".repeat(8 - String.valueOf(brand_1).length()) + "| " +
                brand_2 + " ".repeat(8 - String.valueOf(brand_2).length()) + "|");
    }
}
