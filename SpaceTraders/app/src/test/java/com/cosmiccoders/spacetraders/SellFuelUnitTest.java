package com.cosmiccoders.spacetraders;

import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.ShipYard;
import com.cosmiccoders.spacetraders.entity.Ships.Beetle;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import org.junit.Assert;
import org.junit.Test;


/**
 * Local unit test that tests the sellFuel method in the ShipYard class
 * @author bolson31
 */
public class SellFuelUnitTest {

    /**
     * Local unit test that tests the sellFuel method in the ShipYard class
     */
    @Test
    public void TestSellFuel() {
        ShipYard testShipYard = new ShipYard();
        Player testPlayer = new Player();
        Ship testShip = new Beetle();
        testShip.setFuel(0);

        Assert.assertTrue(testPlayer.checkCurrency(10));
        Assert.assertTrue(!testShip.getFullFuelTank());

        testShipYard.sellFuel(testPlayer, testShip);

        Assert.assertTrue(testShip.getFullFuelTank());
    }
}
