package com.techelevator;

public class Candy extends Items {
    private String soundMessage = "Munch, Munch, Yum!";

    public Candy(String name, String slotID, double price, int maxCapacity,String type, String soundMessage) {
        super(name, slotID, price, maxCapacity, type);
        this.soundMessage = soundMessage;
    }

    public Candy() {

    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }


}
