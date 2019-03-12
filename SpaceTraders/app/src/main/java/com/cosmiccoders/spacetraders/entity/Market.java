package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;
import com.cosmiccoders.spacetraders.entity.PriceModel;

import java.util.HashMap;

import java.util.List;

public class Market {
    HashMap<String, Integer> PlanetMarket (int techLevel, PlanetResources resources) {
        HashMap<String, Integer> prices = new HashMap<>();
        for (String key: tradeGoods.keySet()) {
            if (planet.TechLevel < key[0]) {
                prices.put(key, null);
                return;
            }
            if (planet.TechLevel < key[1]) {
                prices.put(key, null);
                return;
            }
            int above = planet.TechLevel - key[0];
            int price = key[3] + (key[4]*above);
            prices.put(key, price);
        }
        return prices;
    }

}
    HashMap<String, Integer> toReturn = MarketInterface(techLevel, resources);
        return toReturn;