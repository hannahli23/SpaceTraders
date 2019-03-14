package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.TradeGoods.TradeGood;

import java.util.HashMap;
import java.util.Map;

public class CargoHold {
    private int max;
    private Map<String, Integer> inventory;
    private int currSize;

    public CargoHold(int max) {
        this.max = max;
        inventory = new HashMap<>();
    }

    public boolean putCheck(int amount) {
        if (currSize + amount >= max) {
            return false;
        } else {
            return true;
        }
    }
    public void putItem(String good, int amount) {
        if (inventory.containsKey(good)) {
            int temp = inventory.get(good);
            inventory.put(good, temp);
        } else {
            inventory.put(good, 1);
        }
        currSize += amount;
    }

    public boolean takeCheck(String good, int amount) {
        if(inventory.containsKey(good)) {
            return inventory.get(good) > amount;
        } else {
            return false;
        }
    }
    public void takeItem(String good, int amount) {
        int temp = inventory.get(good);
        if(amount < temp) {
            inventory.put(good, temp - amount);
            currSize -= amount;
        } else {
            inventory.remove(good);
            currSize -= amount;
        }
    }

    public int getMax() { return max; }

    public int getCurrSize() { return currSize; }

    public Map<String, Integer> getInventory() { return inventory; }

    public String toString() {
        String result = "You have: ";
        if(currSize == 0) {
            return "There's nothing here";
        } else {
            for (Map.Entry<String, Integer> entry: inventory.entrySet()) {
               result = result + entry.getValue() + " " + entry.getKey() +"\n";
            }
        }
        return result;
    }
}
