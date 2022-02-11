package vehicles;

import game.Player;

public class Truck extends Vehicle {
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public void printVehicle() {
        System.out.println("| " + id + " ".repeat(5 - String.valueOf(id).length()) +
                "| " + price + " ".repeat(9 - String.valueOf(price).length()) +
                "| " + brand.toString() + " ".repeat(9 - String.valueOf(brand).length()) +
                "| " + color.toString() + " ".repeat(9 - String.valueOf(color).length()) +
                "| " + mileage + " ".repeat(9 - String.valueOf(mileage).length()) +
                "| " + brakes + " ".repeat(9 - String.valueOf(brakes).length()) +
                "| " + suspension + " ".repeat(12 - String.valueOf(suspension).length()) +
                "| " + engine + " ".repeat(9 - String.valueOf(engine).length()) +
                "| " + carBody + " ".repeat(10 - String.valueOf(carBody).length()) +
                "| " + gearBox + " ".repeat(9 - String.valueOf(gearBox).length()) +
                "| " + capacity + " ".repeat(9 - String.valueOf(capacity).length()) +
                "| " + type + " ".repeat(9 - type.length()) + "|");
    }

    @Override
    public void printVehicleSell() {
    }

    @Override
    public void buyFromMarketplace(Player player) {
    }
}
