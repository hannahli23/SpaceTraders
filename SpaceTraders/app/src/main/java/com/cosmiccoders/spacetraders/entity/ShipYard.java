package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.List;


public class ShipYard {
    private List<Ship> shipList;

    public void sellFuel(Player player, Ship ship) {
        boolean canFill = false;
        if (!ship.getFullFuelTank()) {
            canFill = player.manipulateCurrency();
        }
        if(canFill) {
            fillTank(ship);
        }
    }

    private void fillTank(Ship ship) {
        ship.setFullFuelTank();
    }

}
