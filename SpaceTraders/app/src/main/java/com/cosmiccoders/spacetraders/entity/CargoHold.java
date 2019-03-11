package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;

import java.util.HashMap;
import java.util.Map;

public class CargoHold {
    private int max;
    private Map<TradeGood, Integer> inventory;
    private int currSize;

    public CargoHold(int max) {
        this.max = max;
        inventory = new HashMap<>();
    }

    public void putItem(TradeGood good, int amount) {
        if ((currSize + amount) >= max) {
            //place some error here
            return;
        }
        if (inventory.containsKey(good)) {
            int temp = inventory.get(good);
            inventory.put(good, temp);
        } else {
            inventory.put(good, 1);
        }
        currSize += amount;
    }

    public void takeItem(TradeGood good, int amount) {
        if (inventory.containsKey(good)) {
            int temp = inventory.get(good);
            if(amount < temp) {
                inventory.put(good, temp - amount);
                currSize -= amount;
            } else if (amount == temp) {
                inventory.remove(good);
                currSize -= amount;
            } else {
                // error message for when you don't have enough items
                return;
            }
        } else {
            //give an error message for the item does not exist
            return;
        }
    }

    public int getMax() { return max; }

    public int getCurrSize() { return currSize; }

    public Map<TradeGood, Integer> getInventory() { return inventory; }
}
