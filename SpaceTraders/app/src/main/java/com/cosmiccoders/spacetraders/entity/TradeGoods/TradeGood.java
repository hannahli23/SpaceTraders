package com.cosmiccoders.spacetraders.entity.TradeGoods;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class TradeGood {

    private int mtlp; // Minimum Tech Level to Produce this resource (You can't buy on planets
                        // below this level)

    private int mtlu; // Minimum Tech Level to Use this resource (You can't sell on planets
                        // below this level)

    private TechLevel ttp; // Tech Level which produces the most of this item

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

    private String name;

    private int basePrice;

    public TradeGood(String name, int basePrice, PlanetResources cr, TechLevel ttp) {
        this.name = name;
        this.basePrice = basePrice;
        this.cr = cr;
        this.ttp = ttp;
    }

    public TradeGood(int mtlp, int mtlu, TechLevel ttp, int ipl, int var, int ie, PlanetResources cr,
                     PlanetResources er, int mtl, int mth) {
        this.mtlp = mtl;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
    }

    public String getName() {return name;}

    public TechLevel getTtp() {return ttp;}

    public int getBasePrice() {return basePrice;}

    public PlanetResources getCr() { return cr; }
}
