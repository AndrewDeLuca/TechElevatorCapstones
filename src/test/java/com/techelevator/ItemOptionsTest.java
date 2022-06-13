package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ItemOptionsTest {
    @Test
    public void vendingMachineOptions_defaults_to_Input_Not_Found() {
        // arrange

        // act

        // assert
    }


    @Test
    public void test_inventory_for_match() {
        // arrange
        ItemOptions itemOptions = new ItemOptions();

        // act
        String inventoryList = String.valueOf(itemOptions.getInventoryList());

        // assert
        Assert.assertArrayEquals(new String[]{"A1"}, new String[]{"A1"});


    }

}
