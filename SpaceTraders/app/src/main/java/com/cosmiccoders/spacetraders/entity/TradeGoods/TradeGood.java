package com.cosmiccoders.spacetraders.entity.TradeGoods;

import com.cosmiccoders.spacetraders.entity.PlanetResources;

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

    public TradeGood(String name, int basePrice, PlanetResources cr, int ttp) {
        this.name = name;
        this.basePrice = basePrice;
        this.cr = cr;
        this.ttp = ttp;
    }

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

    public String getName() {return name;}

    public int getTtp() {return ttp;}

    public int getBasePrice() {return basePrice;}

    public PlanetResources getCr() { return cr; }
}
