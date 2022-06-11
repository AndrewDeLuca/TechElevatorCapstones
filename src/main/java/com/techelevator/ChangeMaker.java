package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ChangeMaker {



    public static String changeMaker (double currentMoney) {


        CoinChange[] coins = new CoinChange[] { new Quarter(), new Dime(), new Nickel() };
        currentMoney = currentMoney * 100; // So that we get currentMoney in cents
        String changeString = ""; // stores our change total

        Map<CoinChange, Integer> changeMap = new HashMap<>();

        for (CoinChange coin : coins) {

            if (currentMoney <= 0) { // there's no money to make change
                break;
            }

            int cents = (int)currentMoney / coin.getValue(); //

            if (cents > 0) { // if there is any change to be made
                currentMoney = currentMoney % (coin.getValue() * cents); // remainder of currentMoney / (coinValue * (currentMoney / coinValue))
                changeMap.put(coin, cents);
            }
        }

        for (CoinChange coin : changeMap.keySet()) {
            changeString = changeString + (changeMap.get(coin) + " " + coin.getName() + "(s)" + " ");
        }



        return changeString;
    }


}
