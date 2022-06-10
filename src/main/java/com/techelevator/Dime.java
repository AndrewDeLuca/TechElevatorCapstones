package com.techelevator;

public class Dime implements CoinChange{

    @Override
    public String getName() {
        return "Dime";
    }

    @Override
    public int getValue() {
        return 10;
    }
}
