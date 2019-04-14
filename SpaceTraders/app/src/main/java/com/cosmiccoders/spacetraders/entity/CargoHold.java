package com.cosmiccoders.spacetraders.entity;

import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the ship's cargo inventory
 */
public class CargoHold {
    /**
     * int max is the max storage capacity of the ship
     * inventory is a map that maps the name of a good to how much of the good you have
     * currSize is the current amount of items in your ship
     */
    private final int max;
    private Map<String, Integer> inventory;
    private int currSize;

    /**
     * This is the constructor for cargohold
     * @param max is the max storage capacity of our ship
     */
    public CargoHold(int max) {
        this.max = max;
        inventory = new HashMap<>();
        currSize = 0;
    }

    /**
     * Check to see if the amount of items you want to put into your cargoHold can actually fit
     * @param amount number of items you want to put into your cargoHold
     * @return boolean of whether or not the amount of items will fit
     */
    public boolean putCheck(int amount) {
        if ((currSize + amount) >= max) {
            Log.i("Check size",  (currSize + amount) + "");
            return false;
        } else {
            return true;
        }
    }

    /**
     * This function puts an amount of a certain item into the cargo hold
     * @param good is the good we want to increase
     * @param amount is the amount of a good that we want to add
     */
    public void putItem(String good, int amount) {
        if (inventory.containsKey(good)) {
            int temp = inventory.get(good);
            temp += amount;
            inventory.put(good, temp);
        } else {
            inventory.put(good, 1);
        }
        currSize += amount;
    }

    /**
     * This checks if there is amount of an item to take
     * @param good the good we want to take out
     * @param amount the amount of a good we want to take out
     * @return whether we can take out that amount of an item
     */
    public boolean takeCheck(String good, int amount) {
        if(inventory.containsKey(good)) {
            return inventory.get(good) >= amount;
        } else {
            return false;
        }
    }

    /**
     * A function that takes an amount of an item out of the inventory
     * @param good is the good we want to take out
     * @param amount is the amount of a good we want to take out
     */
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

    /**
     * Gets the maximum storage capacity of the ship
     * @return int the max storage capacity of the ship
     */
    public int getMax() { return max; }

    /**
     * Gets the current number of items in the ship
     * @return int the current number of items in the ship
     */
    public int getCurrSize() { return currSize; }

    /**
     * Sets currSize equal to input amount
     * @param amount the value to set currSize to
     */
    public void setCurrSize(int amount) {currSize = amount; }

    /**
     * Gets the ship's current inventory
     * @return Map<String,Integer> a map of the ship's current inventory
     */
    public Map<String, Integer> getInventory() { return Collections.unmodifiableMap(inventory); }

    /**
     * Sets the ship's inventory to the input inventory
     * @param newInventory the map of the inventory to assign to the ship
     */
    public void setInventory(Map<String, Integer> newInventory) {inventory = newInventory;}

    /**
     * This function tells us how much of an item we have
     * @param good the good to get the amount of
     * @return the amount of a good we have
     */
    public int getNumOfItem(String good) {
        if(inventory.containsKey(good)) {
            return inventory.get(good);
        } else {
            return 0;
        }
    }

    @Override
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
