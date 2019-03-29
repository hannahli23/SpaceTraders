package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.List;

public class ShipYard {
    private List<Ship> shipList;

    public void sellFuel(Player player) {
        if (!player.getShip().getFullFuelTank()) {
            if (player.checkCurrency(player.getShip().getFuelPrice())) {
                player.getShip().setFullFuelTank(true);
                int newCurrency = player.getCurrency() - player.getShip().getFuelPrice();
                player.setCurrency(newCurrency);
            }
        }
    }

}
