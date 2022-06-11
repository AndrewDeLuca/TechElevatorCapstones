package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class QuarterTest {
    @Test
    public void getName_returns_Quarter() {
        // Arrange
        Quarter myQuarter = new Quarter();
        // Act
        String getName = myQuarter.getName();
        // Assert
        Assert.assertEquals("Quarter", getName);
    }

    @Test
    public void getValue_returns_25() {
        // Arrange
        Quarter myQuarter = new Quarter();
        // Act
        int getValue = myQuarter.getValue();
        // Assert
        Assert.assertEquals(25, getValue);
    }

}
