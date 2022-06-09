package com.techelevator;

public class Gum extends Items {
    private String soundMessage = "Chew, Chew, Yum!";

    public Gum(String name, String slotID, double price, int maxCapacity, String type, String soundMessage) {
        super(name, slotID, price, maxCapacity, type);
        this.soundMessage = soundMessage;
    }

    public Gum() {

    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }
}
