package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private List<String> inventoryList = new ArrayList<>();


    public VendingMachine(List<String> inventoryList) {
        this.inventoryList = inventoryList;

    }

    public VendingMachine() {

    }

    public List<String> getInventoryList() {
        return inventoryList;
    }

    public void addToInventoryList(String inventoryList) {
        this.inventoryList.add(inventoryList);
    }
}
