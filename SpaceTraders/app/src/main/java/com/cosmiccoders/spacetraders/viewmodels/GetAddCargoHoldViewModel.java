package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.model.CargoHoldInteractor;
import com.cosmiccoders.spacetraders.model.Model;

import java.util.Map;

/**
 * Class used to edit the cargo hold view model
 */
public class GetAddCargoHoldViewModel extends AndroidViewModel {
    private final CargoHoldInteractor interactor;

    /**
     * Constructor for GetAddCargoHoldViewModel - calls constructor of superclass
     * @param application the current application
     */
    public GetAddCargoHoldViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getCargoHoldInteractors();
    }

    /**
     * Checks to see if the amount of items you want to put into your cargoHold can actually fit
     * @param amount number of items you want to put into your cargoHold
     * @return boolean of whether or not the amount of items will fit
     */
    public boolean putCheck(int amount) {
        return interactor.putCheck(amount);
    }

    /**
     * Puts an amount of a certain item into the cargo hold
     * @param good is the good we want to increase
     * @param amount is the amount of a good that we want to add
     */
    public void putItem(String good, int amount) {
        interactor.putItem(good, amount);
    }

    /**
     * Checks if there is amount of an item to take
     * @param good the good we want to take out
     * @param amount the amount of a good we want to take out
     * @return whether we can take out that amount of an item
     */
    public boolean takeCheck(String good, int amount) {
        return interactor.takeCheck(good, amount);
    }

    /**
     * Takes an amount of an item out of the inventory
     * @param good is the good we want to take out
     * @param amount is the amount of a good we want to take out
     */
    public void takeItem(String good, int amount) {
        interactor.takeItem(good, amount);
    }

    /**
     * Gets the maximum storage capacity of the cargo hold
     * @return int the max storage capacity of the cargo hold
     */
    public int getMax() {
        return interactor.getMax(); }

    /**
     * Gets the current number of items in the cargo hold
     * @return int the current number of items in the cargo hold
     */
    public int getCurrSize() {
        return interactor.getCurrSize(); }

    /**
     * Sets currSize equal to input amount
     * @param amount the value to set currSize to
     */
    public void setCurrSize(int amount) {
        interactor.setCurrSize(amount); }

    /**
     * Gets the caro hold's current inventory
     * @return Map<String,Integer> a map of the cargo hold's current inventory
     */
    public Map<String, Integer> getInventory() {
        return interactor.getInventory(); }

    /**
     * Sets the cargo hold's inventory to the input inventory
     * @param newInventory the map of the inventory to assign to the cargo hold
     */
    public void setInventory(Map<String, Integer> newInventory) {
        interactor.setInventory(newInventory);}

    /**
     * Gets amount of input good that is in the cargo hold
     * @param good the good to get the amount of
     * @return the amount of the good in the cargo hold
     */
    public int getNumOfItem(String good) {
        return interactor.getNumOfItem(good);
    }

    @Override
    public String toString() {
        return interactor.toString();
    }
}
