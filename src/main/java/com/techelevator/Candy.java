package com.techelevator;
import com.techelevator.Balance;

public class Candy extends Items {
    private String soundMessage = "Munch, Munch, Yum!";
    private int maxCapacity = 5;

    public Candy(String name, String slotID, double price, int maxCapacity,String type, String soundMessage) {
        super(name, slotID, price, type);
        this.soundMessage = soundMessage;
        this.maxCapacity = maxCapacity;
    }

    public Candy() {

    }

    public String getSoundMessage() {
        return soundMessage;
    }

    public void setSoundMessage(String soundMessage) {
        this.soundMessage = soundMessage;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String dispense(String getSlotID) {
        String message = new String();
       if (maxCapacity == 0) {
           message = message + "This Item is Sold Out.";
       } else {
           maxCapacity = maxCapacity - 1;
           System.out.println(soundMessage);
           message = message + "You have selected: " + getName() + getPrice(); // + currentMoney

       }
       return message;



    }


}
