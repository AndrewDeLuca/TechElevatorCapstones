package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private final Menu menu;

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


	private static final String FEED_OPTION_1 = "add $1";
	private static final String FEED_OPTION_2 = "add $2";
	private static final String FEED_OPTION_3 = "add $5";
	private static final String FEED_OPTION_4 = "add $10";
	private static final String FEED_OPTION_5 = "Exit this menu";
	private static final String[] FEED_OPTIONS = {FEED_OPTION_1, FEED_OPTION_2, FEED_OPTION_3, FEED_OPTION_4, FEED_OPTION_5};


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	String fileName = "vendingmachine.csv";
	File vendingMachineCSV = new File(fileName);
	ItemOptions itemOptions = new ItemOptions();

	Scanner input = new Scanner(System.in);
	Balance balance = new Balance();


	public void run() {

		itemOptions.vendingMachineOptions();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					runPurchase();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}


	}

	public void runPurchase() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					feedMoneyRun();
					break;
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					makeSelection();
					break;
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					System.exit(0);
			}

			System.out.println();
			System.out.println("Current Money Provided: " + balance.getCurrentMoney());
		}

	}

	public void feedMoneyRun() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(FEED_OPTIONS);

			switch (choice) {
				case FEED_OPTION_1:
					balance.addToCurrentMoney(1.00);
					break;
				case FEED_OPTION_2:
					balance.addToCurrentMoney(2.00);
					break;
				case FEED_OPTION_3:
					balance.addToCurrentMoney(5.00);
					break;
				case FEED_OPTION_4:
					balance.addToCurrentMoney(10.00);
					break;
				case FEED_OPTION_5:
					runPurchase();
			}

			String formatted = NumberFormat.getCurrencyInstance().format(balance.getCurrentMoney());

			System.out.println();
			System.out.println("Current Money Provided: " + formatted);
		}

	}

	public void makeSelection() {

		while (true) {
			displayItems();
			itemOptions.vendingMachineOptions();
			System.out.println("Please enter Slot Number to make purchase: ");
			String itemSlotChoice = input.nextLine().toUpperCase();

			for (String key : itemOptions.getInventoryList().keySet()) {
				if (!itemSlotChoice.equals(key)) {
					System.out.println("The entered product code does not exist!");
				}
			}


			//         if (!itemSlotChoice.equals(vendingMachine.getInventoryList())) {
			//             System.out.println((System.lineSeparator() + "*** " + itemSlotChoice + " is not a valid option ***" + System.lineSeparator()));
			//        }

			//      System.out.println();

		}
	}

	public void displayItems() {


		for (String key : itemOptions.getInventoryList().keySet()) {
			System.out.print(key + " |");
			System.out.print(" " + itemOptions.getInventoryList().get(key).getName() + " |");
			System.out.print(" " + itemOptions.getInventoryList().get(key).getPrice() + " |" + "\n");

			if (itemOptions.getInventoryList().get(key).getMaxCapacity() >= 1) {
				System.out.println(itemOptions.getInventoryList().get(key).getMaxCapacity() + "/5" + " AVAILABLE");
			} else {
				System.out.println("SOLD OUT");
			}
		}

	}

}

