package vehicles;

import game.Player;

public class Car extends Vehicle {
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
                "| " + " ".repeat(9) +
                "| " + type + " ".repeat(9 - type.length()) + "|");
    }

    @Override
    public void buyFromMarketplace(Player player) {
        player.setBalance(player.getBalance() - (int) (price * 1.02f));
        player.addVehicle(this);
    }
}
