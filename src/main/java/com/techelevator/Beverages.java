package com.techelevator;

public class Beverages implements VendingMachineItems{
    private String name;
    private String slotID;
    private double price;
    private int maxCapacity = 5;

    public Beverages(String name, String slotID, double price, int maxCapacity) {
        this.name = name;
        this.slotID = slotID;
        this.price = price;
        this.maxCapacity = maxCapacity;

    }

    public Beverages() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
