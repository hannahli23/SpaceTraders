package com.cosmiccoders.spacetraders;

import com.cosmiccoders.spacetraders.entity.CargoHold;

import org.junit.Assert;
import org.junit.Test;


/**
 * Local unit test that tests the putCheck method from the CargoHold class
 * @author oamyette3
 */
public class TakeCheckTest {

    /**
     * checks negative out of bounds
     */
    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsNegative() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        test1.takeCheck("Water",-10);
    }

    /**
     * checks zero out of bounds
     */
    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsZero() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        test1.takeCheck("Water",0);
    }

    /**
     * checks to see if there are enough waters
     */
    @Test
    public void notEnoughItems() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        Assert.assertTrue(!test1.takeCheck("Water",6));
    }

    /**
     * checks to see if there are enough waters
     */
    @Test
    public void EnoughItems() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        Assert.assertTrue(test1.takeCheck("Water",4));
    }

    /**
     * checks to see if it will give false given an item not in the market
     */
    @Test
    public void ItemNotInCargoHold() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        Assert.assertTrue(!test1.takeCheck("Ore",4));
    }

    /**
     * checks to see if it will give false given an item not in the market
     */
    @Test
    public void ItemInCargoHold() {
        CargoHold test1 = new CargoHold(20);
        test1.putItem("Water", 5);
        test1.putItem("Robot ", 10);
        Assert.assertTrue(!test1.takeCheck("Robot",4));
    }


}
