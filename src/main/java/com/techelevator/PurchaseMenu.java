package com.techelevator;

import com.techelevator.view.Menu;

public class PurchaseMenu {
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
    private final Menu menu;


    public PurchaseMenu(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            switch (choice) {
                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    break;
                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                    ItemOptions itemOptions = new ItemOptions();
                    itemOptions.vendingMachineOptions();
                    break;
                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:


                    System.exit(0);
            }
        }


    }
}
