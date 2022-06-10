package com.techelevator;

public class Items {

    private String name;
    private String slotID;
    private double price;
    private String type;


    public Items(String name, String slotID, double price, String type) {
        this.name = name;
        this.slotID = slotID;
        this.price = price;

        this.type = type;

    }

    public Items() {
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



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
