package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
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

//	String fileName = "vendingmachine.csv";
//	File vendingMachineCSV = new File(fileName);
	ItemOptions itemOptions = new ItemOptions();


	Scanner input = new Scanner(System.in);
	Balance balance = new Balance();
	String formattedMoney = NumberFormat.getCurrencyInstance().format(balance.getCurrentMoney());

	File log = new File("log.txt"); // file that will log feedMoney, transactions, finish transaction





	DateFormat dateTimeFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	Date date = new Date();


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
			System.out.println();
			System.out.println("Current balance: $" + String.format("%.2f", balance.getCurrentMoney()));
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					feedMoneyRun();
					break;
				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					makeSelection();
					break;
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					finishTransaction();



			}


		}

	}
	double addedMoney = 0.00;
	double previousAmount = 0.00;
	public void feedMoneyRun() {



		while (true) {
			String choice = (String) menu.getChoiceFromOptions(FEED_OPTIONS);

			switch (choice) {
				case FEED_OPTION_1:
					addedMoney = 1.00;
					balance.addToCurrentMoney(addedMoney);
					printToLogFeedMoney();
					break;
				case FEED_OPTION_2:
					addedMoney = 2.00;
					balance.addToCurrentMoney(addedMoney);
					printToLogFeedMoney();
					break;
				case FEED_OPTION_3:
					addedMoney = 5.00;
					balance.addToCurrentMoney(addedMoney);
					printToLogFeedMoney();
					break;
				case FEED_OPTION_4:
					addedMoney = 10.00;
					balance.addToCurrentMoney(addedMoney);
					printToLogFeedMoney();
					break;
				case FEED_OPTION_5:
					runPurchase();
			}



			System.out.println();
			System.out.println("Current Money Provided: $" + String.format("%.2f", balance.getCurrentMoney()));

			previousAmount = balance.getCurrentMoney();


		}



	}

	public void printToLogFeedMoney(){
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
			writer.println(dateTimeFormatter.format(date) + " FEED MONEY: " + "$" + addedMoney + " $" + String.format("%.2f", balance.getCurrentMoney()));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}





	public void makeSelection() {

		while (true) {
			displayItems();
			System.out.println("Please enter Slot Number to make purchase: ");
			String itemSlotChoice = input.nextLine().toUpperCase();

			if (!itemOptions.getInventoryList().containsKey(itemSlotChoice)) {
				System.out.println("Slot Number does not exist, please enter a valid Slot Number");
				System.out.println();
				System.out.println();
			}


			if (itemOptions.getInventoryList().containsKey(itemSlotChoice) && balance.getCurrentMoney() < itemOptions.getInventoryList().get(itemSlotChoice).getPrice()) {
				System.out.println("Insufficient Funds, please feed the machine money (1)");
				runPurchase();
			}

			if (itemOptions.getInventoryList().containsKey(itemSlotChoice) && soldOut == false) {
				balance.subtractFromCurrentMoney(itemOptions.getInventoryList().get(itemSlotChoice).getPrice());
				System.out.println(itemOptions.getInventoryList().get(itemSlotChoice).dispense(itemSlotChoice) + "\n" + "Your remaining balance is: $" + String.format("%.2f", balance.getCurrentMoney()));

				try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
					writer.println(dateTimeFormatter.format(date) + " " + itemOptions.getInventoryList().get(itemSlotChoice).getName() + " " + itemOptions.getInventoryList().get(itemSlotChoice).getSlotID() + " " + "$" + String.format("%.2f", previousAmount) + " $" + String.format("%.2f", balance.getCurrentMoney()));

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				previousAmount = balance.getCurrentMoney();

				runPurchase();
			} else {
				System.out.println();
				System.out.println("Please Select Product that is in stock (2).");
				runPurchase();
			}



		}
	}
	public boolean soldOut = false;
	public void displayItems() {


		for (String key : itemOptions.getInventoryList().keySet()) {
			System.out.print(key + " |");
			System.out.print(" " + itemOptions.getInventoryList().get(key).getName() + " |");
			System.out.print(" " + itemOptions.getInventoryList().get(key).getPrice() + " |" + "\n");

			if (itemOptions.getInventoryList().get(key).getMaxCapacity() >= 1) {
				System.out.println(itemOptions.getInventoryList().get(key).getMaxCapacity() + "/5" + " AVAILABLE");
			} else {
				soldOut = true;
				System.out.println("SOLD OUT");
			}
		}


	}

	public void finishTransaction() {
		if (balance.getCurrentMoney() > 0) {
			System.out.println("Your Change is: " + ChangeMaker.changeMaker(balance.getCurrentMoney()));
		}

		balance.subtractFromCurrentMoney(balance.getCurrentMoney());
		System.out.println("Current balance: $" + String.format("%.2f", balance.getCurrentMoney()));

		try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
			writer.println(dateTimeFormatter.format(date) + " " + "GIVE CHANGE:" + " " + "$" + String.format("%.2f", previousAmount) + " $" + String.format("%.2f", balance.getCurrentMoney()));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		run();

	}

}

