package com.cosmiccoders.spacetraders.entity.TradeGoods;

import com.cosmiccoders.spacetraders.entity.PlanetResources;

/**
 * This class represents a specific trade good, Water, that extends the TradeGoods class
 */
public class Water extends TradeGood {
    /**
     * This is the constructor for Water that call the constructor in TradeGoods
     */
    public Water() {
        super(1, 1, 1, 1,1,1, PlanetResources.LOTS_OF_WATER,
                PlanetResources.DESERT, 1, 1);
    }
    //just put random place holder values for everything - confused what the
    // document is referring to for values so will fix later
}
