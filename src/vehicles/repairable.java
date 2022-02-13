package vehicles;

import game.Player;

public interface repairable {

        boolean repairBrakes(Vehicle vehicle, Player player);

        boolean repairSuspension(Vehicle vehicle, Player player);

        boolean repairEngine(Vehicle vehicle, Player player);

        boolean repairCarBody(Vehicle vehicle, Player player);

        boolean repairGearBox(Vehicle vehicle, Player player);

}
