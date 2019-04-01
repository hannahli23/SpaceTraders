package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.List;


public class ShipYard {
    private List<Ship> shipList;

    public void sellFuel(Player player, Ship ship) {
        if (!ship.getFullFuelTank()) {
            if (player.checkCurrency(10)) {
                ship.setFullFuelTank();
                int newCurrency = player.getCurrency() - 10;
                player.setCurrency(newCurrency);
            }
        }
    }

}
