package com.cosmiccoders.spacetraders.entity.TradeGoods;

import com.cosmiccoders.spacetraders.entity.PlanetResources;

/**
 * Class representing the trade goods of a planet
 */
public class TradeGood {

    // below this level)

    // below this level)

    private final int ttp; // Tech Level which produces the most of this item

    // below the base

    // price may increase astronomically

    private final PlanetResources cr; // When this condition is present, the price of this resource
                                // is unusually low

    private String name;

    private int basePrice;

    /**
     * Constructor for TradeGood class
     * @param name the name of the resource
     * @param basePrice the price of the resource
     * @param cr if condition is present, price of resource will be low
     * @param ttp tech level which produces the most of this item
     */
    public TradeGood(String name, int basePrice, PlanetResources cr, int ttp) {
        this.name = name;
        this.basePrice = basePrice;
        this.cr = cr;
        this.ttp = ttp;
    }

    /**
     * A second constructor for TradeGood class
     * @param mtlp minimum tech level to produce resource
     * @param mtlu minimum tech level to use resource
     * @param ttp tech level which produces the most of this item
     * @param ipl price increase per tech level
     * @param var maximum percentage that price can vary above or below
     * @param ie radical price increase event
     * @param cr if condition is present, price of resource will be low
     * @param er when this condition is present, the resource is expensive
     * @param mtl min price offered in space trade with random trader (not on a planet)
     * @param mth max price offered in space trade with random trader (not on a planet)
     */
    public TradeGood(int mtlp, int mtlu, int ttp, int ipl, int var, int ie, PlanetResources cr,
                     PlanetResources er, int mtl, int mth) {
        // Minimum Tech Level to Produce this resource (You can't buy on planets
        int mtlp1 = mtl;
        // Minimum Tech Level to Use this resource (You can't sell on planets
        this.ttp = ttp;
        // Price increase per tech level
        // variance is the maximum percentage that the price can vary above or
        // Radical price increase event, when this even happens on a planet, the
        this.cr = cr;
        // When this condition is present, the resource is expensive
        // Min price offered in space trade with random trader (not on a planet)
        // Max price offered in space trade with random trader (not on a planet)
    }

    /**
     * Gets name of resource
     * @return String the name of the good
     */
    public String getName() {return name;}

    /**
     * Gets the Minimum Tech Level to Use this resource
     * @return int the Minimum Tech Level to Use this resource
     */
    public int getTtp() {return ttp;}

    /**
     * Gets the base price of this resource
     * @return int the base price of this resource
     */
    public int getBasePrice() {return basePrice;}

    /**
     * Gets the Radical price increase event
     * @return PlanetResources a radical price increase event
     */
    public PlanetResources getCr() { return cr; }
}
