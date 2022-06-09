package com.techelevator;

public class Chips extends Items {
    private String soundMessage = "Crunch, Crunch, Yum!";

    public Chips(String name, String slotID, double price, int maxCapacity,String type, String soundMessage) {
        super(name, slotID, price, maxCapacity,type);
        this.soundMessage = soundMessage;
    }

    public Chips() {

    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }


}
