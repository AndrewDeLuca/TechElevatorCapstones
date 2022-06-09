package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements VendingMachineItems{
    private Map<String, String> mapOfItems = new HashMap<>();


    public VendingMachine(Map<String, String> mapOfItems) {
        this.mapOfItems = mapOfItems;

    }

    public VendingMachine() {

    }

    public Map<String, String> getMapOfItems() {
        return mapOfItems;
    }

    public void setMapOfItems(Map<String, String> mapOfItems) {
        this.mapOfItems = mapOfItems;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSlotID() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getMaxCapacity() {
        return 0;
    }
}
