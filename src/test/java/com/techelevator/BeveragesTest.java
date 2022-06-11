package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTest {
    @Test
    public void dispense_returns_message_given_valid_slotID_1() {
        // Arrange
        Beverages myBeverages = new Beverages();
        String message = "";
        // Act
        String dispense = myBeverages.dispense("C1");
        // Assert
        Assert.assertEquals(message, dispense);
    }
}
