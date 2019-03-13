package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;

import java.util.HashMap;

import java.util.List;

public class Market extends PriceModel{
    HashMap<String, Integer> PlanetMarket (PlanetResources resources ,TechLevel techLevel) {
        HashMap<String, Integer> toReturn = MarketGoods(resources, techLevel);
        return toReturn;
    }
}