package com.cosmiccoders.spacetraders;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Ships.Gnat;
import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Planets.Andromeda;
import com.cosmiccoders.spacetraders.entity.Market;

import org.junit.Assert;
import org.junit.Test;

/**
 * Local unit test that tests the putCheck method from the CargoHold class
 * @author wli423
 */
public class PutCheckTest {

    /**
     * checks negative out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void outOfBoundsNegative() {
        CargoHold test1 = new CargoHold(20);
        test1.putCheck(-10);
    }

    /**
     * checks out of bounds over the maximum value
     */
    @Test (expected = IllegalArgumentException.class)
    public void outOfBoundsOverMax() {
        CargoHold test1 = new CargoHold(20);
        test1.putCheck(100);
    }

    /**
     * checks when number is equal to the lower bound
     */
    @Test
    public void onBoundsSmall() {
        CargoHold test1 = new CargoHold(20);
        Assert.assertTrue(test1.putCheck(1));
    }

    /**
     * checks when the number is equal to the upper bound
     */
    @Test
    public void onBoundsLarge() {
        CargoHold test1 = new CargoHold(20);
        Assert.assertTrue(test1.putCheck(20));
    }

    /**
     * checks when cargo hold is full
     */
    @Test
    public void notEnoughRoom() {
        CargoHold test1 = new CargoHold(20);
        test1.setCurrSize(19);
        Assert.assertTrue(!test1.putCheck(3));
    }

    /**
     * checks when cargo hold is not full
     */
    @Test
    public void enoughRoom() {
        CargoHold test1 = new CargoHold(20);
        test1.setCurrSize(2);
        Assert.assertTrue(test1.putCheck(8));
    }

    /**
     * checks when not full and in bounds
     */
    @Test
    public void enoughRoomBound() {
        CargoHold test1 = new CargoHold(20);
        test1.setCurrSize(19);
        Assert.assertTrue(test1.putCheck(1));
    }


}
