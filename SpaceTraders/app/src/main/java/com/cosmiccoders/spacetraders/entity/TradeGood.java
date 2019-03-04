package com.cosmiccoders.spacetraders.entity;

public class TradeGood {

    private int mtlp; // Minimum Tech Level to Produce this resource (You can't buy on planets
                        // below this level)

    private int mtlu; // Minimum Tech Level to Use this resource (You can't sell on planets
                        // below this level)

    private int ttp; // Tech Level which produces the most of this item

    private int ipl; // Price increase per tech level

    private int var; // variance is the maximum percentage that the price can vary above or
                        // below the base

    private int ie; // Radical price increase event, when this even happens on a planet, the
                        // price may increase astronomically

    private PlanetResources cr; // When this condition is present, the price of this resource
                                // is unusually low

    private PlanetResources er; // When this condition is present, the resource is expensive

    private int mtl; // Min price offered in space trade with random trader (not on a planet)

    private int mth; // Max price offered in space trade with random trader (not on a planet)
}
