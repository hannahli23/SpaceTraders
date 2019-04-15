package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.List;

/**
 * Class representing the ship yard, where all of the ships reside in a list
 */
public class ShipYard {
    private List<Ship> shipList;

    /**
     * Performs the action of selling fuel
     * @param player the player who is selling their ships fuel
     * @param ship the ship to sell fuel from
     */
    public void sellFuel(Player player, Ship ship) {
        boolean canFill = false;
        if (!ship.getFullFuelTank()) {
            canFill = player.manipulateCurrency();
        }
        if (canFill) {
            fillTank(ship);
        }
    }

    /**
     * Fills the ships fuel tank
     * @param ship the ship whose tank to fill
     */
    private void fillTank(Ship ship) {
        ship.setFullFuelTank();
    }

}
