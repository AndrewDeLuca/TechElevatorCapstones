package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
    @Test
    public void dispense_returns_you_have_selected_message_given_valid_slotID_1() {
        // Arrange
        Gum myGum = new Gum();
        String message = "You have selected: null $0.00";
        // Act
        String dispense = myGum.dispense("D1");
        // Assert

        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_returns_this_item_is_sold_out_message_given_maxCapacity_is_0() {
        // Arrange
        Gum myGum = new Gum();
        String message = "This Item is Sold Out.";
        myGum.setMaxCapacity(0);
        // Act
        String dispense = myGum.dispense("D1");
        // Assert
        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_prints_soundMessage() {
        // Arrange
        Gum myGum = new Gum();
        String mySoundMessage = myGum.getSoundMessage();
        String expected = "Chew, Chew, Yum!";
        // Act
        String dispense = myGum.dispense("D1");
        // Assert
        Assert.assertEquals(expected, mySoundMessage);
    }
}
