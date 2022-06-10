package com.techelevator;

import java.util.*;

public class VendingMachine {
    private Map<String, Items> inventoryList = new LinkedHashMap<>();


    public VendingMachine(Map<String, Items> inventoryList) {
        this.inventoryList = inventoryList;

    }

    public VendingMachine() {

    }

    public Map<String, Items> getInventoryList() {
        return inventoryList;
    }

    public void addToInventoryList(String inventoryList, Items type) {
        this.inventoryList.put(inventoryList, type);
    }
}
