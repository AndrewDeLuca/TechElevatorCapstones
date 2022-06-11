package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DimeTest {
    @Test
    public void getName_returns_Dime() {
        // Arrange
        Dime myDime = new Dime();
        // Act
        String getName = myDime.getName();
        // Assert
        Assert.assertEquals("Dime", getName);
    }

    @Test
    public void getValue_returns_10() {
        // Arrange
        Dime myDime = new Dime();
        // Act
        int getValue = myDime.getValue();
        // Assert
        Assert.assertEquals(10, getValue);
    }
}
