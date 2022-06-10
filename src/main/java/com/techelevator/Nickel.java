package com.techelevator;

public class Nickel implements CoinChange{

    @Override
    public String getName() {
        return "Nickel";
    }

    @Override
    public int getValue() {
        return 5;
    }
}
