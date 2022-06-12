package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemOptions {

    private Map<String, Items> inventoryList = new LinkedHashMap<>();

    public Map<String, Items> getInventoryList() {
        return inventoryList;
    }

    public void addToInventoryList(String inventoryList, Items type) {
        this.inventoryList.put(inventoryList, type);
    }

    public ItemOptions(){

    }

    public void vendingMachineOptions() {
        String fileName = "vendingmachine.csv";
        File vendingMachineCSV = new File(fileName);

        // Stocking VendingMachine with Items
        try (Scanner inventoryListScanner = new Scanner(vendingMachineCSV)) {
            while (inventoryListScanner.hasNextLine()) {
                String lineOfText = inventoryListScanner.nextLine();
                String[] splitLineForRestocking = lineOfText.split("\\|");

                switch (splitLineForRestocking[0].charAt(0)) {
                    case 'A':
                        Chips chips = new Chips();
                        chips.setSlotID(splitLineForRestocking[0]);
                        chips.setName(splitLineForRestocking[1]);
                        chips.setPrice(Double.parseDouble(splitLineForRestocking[2]));
                        chips.setType(splitLineForRestocking[3]);
                        addToInventoryList(splitLineForRestocking[0], chips);
                        break;
                    case 'B':
                        Candy candy = new Candy();
                        candy.setSlotID(splitLineForRestocking[0]);
                        candy.setName(splitLineForRestocking[1]);
                        candy.setPrice(Double.parseDouble(splitLineForRestocking[2]));
                        candy.setType(splitLineForRestocking[3]);
                        addToInventoryList(splitLineForRestocking[0], candy);
                        break;
                    case 'C':
                        Beverages beverages = new Beverages();
                        beverages.setSlotID(splitLineForRestocking[0]);
                        beverages.setName(splitLineForRestocking[1]);
                        beverages.setPrice(Double.parseDouble(splitLineForRestocking[2]));
                        beverages.setType(splitLineForRestocking[3]);
                        addToInventoryList(splitLineForRestocking[0], beverages);
                        break;
                    case 'D':
                        Gum gum = new Gum();
                        gum.setSlotID(splitLineForRestocking[0]);
                        gum.setName(splitLineForRestocking[1]);
                        gum.setPrice(Double.parseDouble(splitLineForRestocking[2]));
                        gum.setType(splitLineForRestocking[3]);
                        addToInventoryList(splitLineForRestocking[0], gum);
                        break;
                    default:
                        System.out.println("Input File Not Found!");
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

