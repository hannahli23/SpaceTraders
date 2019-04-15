package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.Map;

/**
 * This class is the interactor for a player's cargo hold
 */
public class CargoHoldInteractor extends Interactor{
    private Ship ship;
    private CargoHold cargoHold;
    private Repository repo;

    /**
     * Constructor for CargoHoldInteractor - calls constructor of superclass, Interactor
     * @param repo the current repository
     */
    public CargoHoldInteractor(Repository repo) {super(repo);}

    /**
     * Calls CargoHold's putCheck method which checks to see if the amount
     * of items you want to put into your cargoHold can actually fit
     * @param amount number of items you want to put into your cargoHold
     * @return boolean of whether or not the amount of items will fit
     */
    public boolean putCheck(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.putCheck(amount);
    }

    /**
     * Calls CargoHold's putItem method which puts an amount of a certain item into the cargo hold
     * @param good is the good we want to increase
     * @param amount is the amount of a good that we want to add
     */
    public void putItem(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.putItem(good, amount);
    }


    /**
     * Calls CargoHold's takeCheck method which checks if there is amount of an item to take
     * @param good the good we want to take out
     * @param amount the amount of a good we want to take out
     * @return whether we can take out that amount of an item
     */
    public boolean takeCheck(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.takeCheck(good, amount);
    }

    /**
     * Calls CargoHold's takeItem method which takes an amount of an item out of the inventory
     * @param good is the good we want to take out
     * @param amount is the amount of a good we want to take out
     */
    public void takeItem(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.takeItem(good, amount);
    }

    /**
     * Calls CargoHold's getMax method which gets the maximum storage capacity of the ship
     * @return int the max storage capacity of the cargo hold
     */
    public int getMax() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getMax(); }

    /**
     * Calls CargoHold's getCurrSize method which gets the current
     * number of items in the cargo hold
     * @return int the current number of items in the cargo hold
     */
    public int getCurrSize() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getCurrSize(); }

    /**
     * Calls CargoHold's getCurrSize method which sets currSize equal to input amount
     * @param amount the value to set currSize to
     */
    public void setCurrSize(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setCurrSize(amount); }

    /**
     * Calls CargoHold's getInventory method which gets the caro hold's current inventory
     * @return Map<String,Integer> a map of the cargo hold's current inventory
     */
    public Map<String, Integer> getInventory() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getInventory(); }

    /**
     * Calls CargoHold's setInventory method which sets the cargo hold's
     * inventory to the input inventory
     * @param newInventory the map of the inventory to assign to the cargo hold
     */
    public void setInventory(Map<String, Integer> newInventory) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setInventory(newInventory);}

    /**
     * Calls CargoHold's getNumOfItem function which tells us how much of an item
     * is in the cargo hold
     * @param good the good to get the amount of
     * @return the amount of the good in the cargo hold
     */
    public int getNumOfItem(String good) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getNumOfItem(good);
    }

    @Override
    public String toString() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.toString();
    }
}
