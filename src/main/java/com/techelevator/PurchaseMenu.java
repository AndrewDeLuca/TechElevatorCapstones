//package com.techelevator;
//import com.techelevator.view.Menu;
//import com.techelevator.ItemOptions;
//import com.techelevator.Items;
//
//import java.text.NumberFormat;
//import java.util.List;
//import java.util.Locale;
//import java.util.Scanner;
//
//public class PurchaseMenu {
//    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
//    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
//    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
//    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
//    private final Menu menu;
//
//    private static final String FEED_OPTION_1 = "add $1";
//    private static final String FEED_OPTION_2 = "add $2";
//    private static final String FEED_OPTION_3 = "add $5";
//    private static final String FEED_OPTION_4 = "add $10";
//    private static final String FEED_OPTION_5 = "Exit this menu";
//    private static final String[] FEED_OPTIONS = {FEED_OPTION_1, FEED_OPTION_2, FEED_OPTION_3, FEED_OPTION_4, FEED_OPTION_5};
//
//
//    public PurchaseMenu(Menu menu) {
//        this.menu = menu;
//    }
//    Scanner input = new Scanner(System.in);
//    Balance balance = new Balance();
//    ItemOptions itemOptions = new ItemOptions();
//
//
//    public void runPurchase() {
//
//        while (true) {
//            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
//
//            switch (choice) {
//                case PURCHASE_MENU_OPTION_FEED_MONEY:
//                    feedMoneyRun();
//                    break;
//                case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
//                    makeSelection();
//                    break;
//                case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
//                    System.exit(0);
//            }
//
//            System.out.println();
//            System.out.println("Current Money Provided: " + balance.getCurrentMoney());
//        }
//
//    }
//
//    public void feedMoneyRun() {
//
//        while (true) {
//            String choice = (String) menu.getChoiceFromOptions(FEED_OPTIONS);
//
//            switch (choice) {
//                case FEED_OPTION_1:
//                    balance.addToCurrentMoney(1.00);
//                    break;
//                case FEED_OPTION_2:
//                    balance.addToCurrentMoney(2.00);
//                    break;
//                case FEED_OPTION_3:
//                    balance.addToCurrentMoney(5.00);
//                    break;
//                case FEED_OPTION_4:
//                    balance.addToCurrentMoney(10.00);
//                    break;
//                case FEED_OPTION_5:
//                    runPurchase();
//            }
//
//            String formatted = NumberFormat.getCurrencyInstance().format(balance.getCurrentMoney());
//
//            System.out.println();
//            System.out.println("Current Money Provided: " + formatted);
//        }
//
//    }
//
//    public void makeSelection() {
//
//
//
//        while (true) {
//
//
//
//            itemOptions.vendingMachineOptions();
//            System.out.println("Please enter Slot Number to make purchase: ");
//            String itemSlotChoice = input.nextLine().toUpperCase();
//
//
//
//
//   //         if (!itemSlotChoice.equals(vendingMachine.getInventoryList())) {
//   //             System.out.println((System.lineSeparator() + "*** " + itemSlotChoice + " is not a valid option ***" + System.lineSeparator()));
//   //        }
//
//     //      System.out.println();
//
//
//
//        }
//
//    }
//
//}
