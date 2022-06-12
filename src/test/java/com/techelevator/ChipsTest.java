package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {
    @Test
    public void dispense_returns_you_have_selected_message_given_valid_slotID_1() {
        // Arrange
        Chips myChips = new Chips();
        String message = "You have selected: null $0.00";
        // Act
        String dispense = myChips.dispense("A1");
        // Assert

        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_returns_this_item_is_sold_out_message_given_maxCapacity_is_0() {
        // Arrange
        Chips myChips = new Chips();
        String message = "This Item is Sold Out.";
        myChips.setMaxCapacity(0);
        // Act
        String dispense = myChips.dispense("A1");
        // Assert
        Assert.assertEquals(message, dispense);
    }

    @Test
    public void dispense_prints_soundMessage() {
        // Arrange
        Chips myChips = new Chips();
        String mySoundMessage = myChips.getSoundMessage();
        String expected = "Crunch, Crunch, Yum!";
        // Act
        String dispense = myChips.dispense("A1");
        // Assert
        Assert.assertEquals(expected, mySoundMessage);
    }
}
