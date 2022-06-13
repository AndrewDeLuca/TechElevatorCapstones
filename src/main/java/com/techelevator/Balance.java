package com.techelevator;

public class Balance {
    private Double currentMoney = 0.00;

    public Double getCurrentMoney() {
        return currentMoney;
    }

    public void addToCurrentMoney(double moneyToAdd) {
        currentMoney = moneyToAdd + currentMoney;


    }

    public void subtractFromCurrentMoney(double subtractFromMoney) {
        currentMoney = currentMoney - subtractFromMoney;

    }



}


