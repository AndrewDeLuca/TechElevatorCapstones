package com.techelevator;

public class Beverages extends Items {
    private String soundMessage = "Glugg, Glugg, Yum!";

    public Beverages(String name, String slotID, double price, int maxCapacity,String type, String soundMessage) {
        super(name, slotID, price, maxCapacity, type);
        this.soundMessage = soundMessage;
    }

    public Beverages() {

    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }
}
