package com.cosmiccoders.spacetraders.entity.TradeGoods;

import com.cosmiccoders.spacetraders.entity.PlanetResources;

/**
 * This class represents a specific trade good, Food, that extends the TradeGoods class
 */
public class Food extends TradeGood {
    /**
     * This is the constructor for Food that call the constructor in TradeGoods
     */
    public Food() {
        super(1, 1, 1, 1,1,1, PlanetResources.LOTS_OF_WATER,
                PlanetResources.DESERT, 1, 1);
    }
    //just put random place holder values for everything - confused what the
    // document is referring to for values so will fix later
}
