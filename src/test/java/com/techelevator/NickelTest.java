package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NickelTest {

    @Test
    public void getName_returns_Nickel() {
        // Arrange
        Nickel myNickel = new Nickel();
        // Act
        String getName = myNickel.getName();
        // Assert
        Assert.assertEquals("Nickel", getName);
    }

    @Test
    public void getValue_returns_5() {
        // Arrange
        Nickel myNickel = new Nickel();
        // Act
        int getValue= myNickel.getValue();
        // Assert
        Assert.assertEquals(5, getValue);
    }
}
