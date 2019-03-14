package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

public class Market extends PriceModel{
    private Map<String, Integer> goodList;
    private Map<String, Boolean> canSell;

    public Market(PlanetResources pr, TechLevel tl) {
        goodList = MarketGoods(pr, tl);
        canSell = checkCanSell(tl);
    }

    public Map<String, Integer> getGoodList() {
        return goodList;
    }

    public Boolean getCanSell(String good) {
        return canSell.get(good);
    }

    public int getPrice(String good) {
        return goodList.get(good);
    }

    public String toString() {
        String result = "";
        for (Map.Entry<String, Integer> entry: goodList.entrySet()) {
            result = result + entry.getKey() + " " + entry.getValue() +"\n";
        }
        return result;
    }

}