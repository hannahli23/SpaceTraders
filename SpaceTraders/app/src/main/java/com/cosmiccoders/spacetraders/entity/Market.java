package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;

import java.util.Map;

/**
 * This class as a Market for the player which is used in the PlanetTemp Class
 */
public class Market extends PriceModel{
    /** The goodlist is for the goods available on each planet
     *  The canSell is for the goods the player can sell
     */
    private Map<String, Integer> goodList;
    private Map<String, Boolean> canSell;

    /**
     * This is the Market constructor
     * @param pr is the planet resources from each planet
     * @param tl is the tech level from each planet
     */
    public Market(PlanetResources pr, TechLevel tl) {
        goodList = MarketGoods(pr, tl);
        canSell = checkCanSell(tl);
    }

    /**
     * This function returns the goodList
     * @return a Map<String, Integer> which has a String as the good name and
     *         an integer which is the goods price
     */
    public Map<String, Integer> getGoodList() {
        return goodList;
    }

    /**
     * This functions returns whether a player can sell the item or not
     * @param good is the name of the good that we want to check
     * @return a boolean value representing whether or not we can sell the good
     */
    public Boolean getCanSell(String good) {
        return canSell.get(good);
    }

    /**
     * This funciton returns the price of a good
     * @param good is the good we want to find the price of
     * @return an integer value for the price of the good
     */
    public int getPrice(String good) {
        return goodList.get(good);
    }

    /**
     * This function returns a string that lists each good and it's price
     * @return a string that includes each good and the price of the good.
     */
    public String toString() {
        String result = "";
        for (Map.Entry<String, Integer> entry: goodList.entrySet()) {
            result = result + entry.getKey() + ": " + entry.getValue() +"\n";
        }
        return result;
    }

}