package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

// currentMoney = 8.55

public class ChangeMakerTest {
    @Test
    public void changeMaker_returns_changeString_given_855() {
        // Arrange
        ChangeMaker myChangeMaker = new ChangeMaker();
        // Act
        String actual = myChangeMaker.changeMaker(8.55);
        // Assert
        Assert.assertEquals("34 Quarter(s) 1 Nickel(s) ", actual);
    }
}
