package vehicles;

import enums.Brand;
import enums.Color;
import game.Player;

public abstract class Vehicle implements saleable{

    protected String type;
    protected int id;
    protected int price;
    protected Brand brand;
    protected int mileage;
    protected Color color;
    protected boolean brakes;
    protected boolean suspension;
    protected boolean engine;
    protected boolean carBody;
    protected boolean gearBox;
    protected int brakesRepairPrice;
    protected int suspensionRepairPrice;
    protected int engineRepairPrice;
    protected int carBodyRepairPrice;
    protected int gearBoxRepairPrice;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isBrakes() {
        return brakes;
    }

    public void setBrakes(boolean brakes) {
        this.brakes = brakes;
    }

    public boolean isSuspension() {
        return suspension;
    }

    public void setSuspension(boolean suspension) {
        this.suspension = suspension;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public boolean isCarBody() {
        return carBody;
    }

    public void setCarBody(boolean carBody) {
        this.carBody = carBody;
    }

    public boolean isGearBox() {
        return gearBox;
    }

    public void setGearBox(boolean gearBox) {
        this.gearBox = gearBox;
    }

    public int getBrakesRepairPrice() {
        return brakesRepairPrice;
    }

    public void setBrakesRepairPrice(int brakesRepairPrice) {
        this.brakesRepairPrice = brakesRepairPrice;
    }

    public int getSuspensionRepairPrice() {
        return suspensionRepairPrice;
    }

    public void setSuspensionRepairPrice(int suspensionRepairPrice) {
        this.suspensionRepairPrice = suspensionRepairPrice;
    }

    public int getEngineRepairPrice() {
        return engineRepairPrice;
    }

    public void setEngineRepairPrice(int engineRepairPrice) {
        this.engineRepairPrice = engineRepairPrice;
    }

    public int getCarBodyRepairPrice() {
        return carBodyRepairPrice;
    }

    public void setCarBodyRepairPrice(int carBodyRepairPrice) {
        this.carBodyRepairPrice = carBodyRepairPrice;
    }

    public int getGearBoxRepairPrice() {
        return gearBoxRepairPrice;
    }

    public void setGearBoxRepairPrice(int gearBoxRepairPrice) {
        this.gearBoxRepairPrice = gearBoxRepairPrice;
    }

    public Vehicle() {
    }

    public abstract void printVehicle();

    public void printVehicleSell() {
        System.out.println("| " + id + " ".repeat(5 - String.valueOf(id).length()) +
                "| " + (int) (price * 1.02f) + " ".repeat(15 - String.valueOf((int) (price * 1.02f)).length()) + "|");
    }

    public boolean checkIsFine() {
        return brakes && suspension && engine && carBody && gearBox;
    }

    public abstract void buyFromMarketplace(Player player);
}
