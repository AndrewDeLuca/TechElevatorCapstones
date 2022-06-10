package com.techelevator;

public class Quarter implements CoinChange{

    @Override
    public String getName() {
        return "Quarter";
    }

    @Override
    public int getValue() {
        return 25;
    }
}
