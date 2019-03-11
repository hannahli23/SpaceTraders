package com.cosmiccoders.spacetraders.entity;
package com.cosmiccoders.spacetraders.entity.PriceModel;

import java.util.HashMap;
import java.util.List;

public class PriceModelSpecifics {

    /* This function takes in the hashmap of tradegoods where the key is
    water, furs, etc and the value is an array of all the attributes of the
    goods. It iterates through the keys in the hashmap and calculates the price
    on the planet that is put into it.
     */

    void ThisFunction (HashMap<String, List> tradeGoods, Planet planet,) {
        HashMap<String, Integer> prices = new HashMap<String, Integer>();
        for (key in tradeGoods){
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
    }
}
