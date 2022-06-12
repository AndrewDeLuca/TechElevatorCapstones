package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
    @Test
    public void dispense_returns_you_have_selected_message_given_valid_slotID_1() {
        // Arrange
        Candy myCandy = new Candy();
        String message = "You have selected: null $0.00";
        // Act
        String dispense = myCandy.dispense("B1");
        // Assert
        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_returns_this_item_is_sold_out_message_given_maxCapacity_is_0() {
        // Arrange
        Candy myCandy = new Candy();
        String message = "This Item is Sold Out.";
        myCandy.setMaxCapacity(0);
        // Act
        String dispense = myCandy.dispense("B1");
        // Assert
        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_prints_soundMessage() {
        // Arrange
        Candy myCandy = new Candy();
        String mySoundMessage = myCandy.getSoundMessage();
        String expected = "Munch, Munch, Yum!";
        // Act
        String dispense = myCandy.dispense("C1");
        // Assert
        Assert.assertEquals(expected, mySoundMessage);
    }
}
