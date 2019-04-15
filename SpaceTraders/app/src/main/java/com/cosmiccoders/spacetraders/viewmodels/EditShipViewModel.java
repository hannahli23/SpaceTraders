package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.ShipInteractor;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

/**
 * Class used to edit the ship view model
 */
public class EditShipViewModel extends AndroidViewModel {

    private ShipInteractor interactor;

    /**
     * Constructor for EditShipViewModel - calls constructor of superclass
     * @param application the current application
     */
    public EditShipViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getShipInteractors();
    }

    /**
     * Updates the current ship
     * @param ship the ship to update
     */
    public void updateShip(Ship ship) { interactor.updateShip(ship);}

    /**
     * Adds a ship to the view model
     * @param ship the ship to add
     */
    public void addShip(Ship ship) {
        interactor.addShip(ship);
    }

    /**
     * Sets the main ship
     * @param ship the ship to set as the main ship
     */
    public void setMainShip(Ship ship) { interactor.setMainShip(ship);}

    /**
     * Gets the main ship
     * @return Ship the main ship
     */
    public Ship getMainShip() { return interactor.getMainShip();}

    /**
     * Gets the name of the ship
     * @return String the ship's name
     */
    public String getShipName() {
        return interactor.getShipName();
    }

    /**
     * Gets the type of the ship
     * @return String the ship's type
     */
    public String getShipType() {
        return interactor.getShipType(); }

    /**
     * Gets the id of the ship
     * @return int the ship's id
     */
    public int getId() {
        return interactor.getId(); }

    /**
     * Gets the hull strength of the ship
     * @return int the ship's hull strength
     */
    public int getHullStrength() {
        return interactor.getHullStrength(); }

    /**
     * Gets the number of weapon slots of the ship
     * @return int the ship's number of weapon slots
     */
    public int getNumOfWeaponSlots() {
        return interactor.getNumOfWeaponSlots(); }

    /**
     * Gets number of shield slots of the ship
     * @return int the ship's number of shield slots
     */
    public int getNumOfShieldSlots() {
        return interactor.getNumOfShieldSlots(); }

    /**
     * Gets number of gadget slots of the ship
     * @return int the ship's number of gadget slots
     */
    public int getNumOfGadgetSlots() {
        return interactor.getNumOfGadgetSlots(); }

    /**
     * Gets number of crew quarters of the ship
     * @return int the ship's number of crew quarters
     */
    public int getNumOfCrewQuarters() {
        return interactor.getNumOfCrewQuarters(); }

    /**
     * Gets max travel range of the ship
     * @return int the ship's maximum travel range
     */
    public int getMaxTravelRange() {
        return interactor.getMaxTravelRange(); }

    /**
     * Tells whether or not the ship has an escape pod
     * @return boolean if the ship has an escape pod
     */
    public boolean getEscapePod() {
        return interactor.getEscapePod(); }

    /**
     * Gets fuel level of the ship
     * @return int the ship's fuel level
     */
    public int getFuel() {
        return interactor.getFuel(); }

    /**
     * Tells whether or not the ships fuel tank is full
     * @return boolean if the fuel tank is full
     */
    public boolean getFullFuelTank() {
        return interactor.getFullFuelTank(); }

    /**
     * Gets the ship's cargo hold
     * @return CargoHold the ship's cargo hold
     */
    public CargoHold getCargoHold() {
        return interactor.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    /**
     * Sets the ship's name to the input name
     * @param name to assign to the ship
     */
    public void setName(String name) {
        interactor.setName(name); }

    /**
     * Sets the ship's id to the input id
     * @param id to assign to the ship
     */
    public void setId(int id) {
        interactor.setId(id); }

    /**
     * Sets the ship's hull strength to the input hull strength
     * @param hullStrength to assign to the ship
     */
    public void setHullStrength(int hullStrength) {
        interactor.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    /**
     * Sets the ship's number of weapon slots to the input number
     * @param numOfWeaponSlots to assign to the ship
     */
    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        interactor.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    /**
     * Sets the ship's number of shield slots to the input number
     * @param numOfShieldSlots to assign to the ship
     */
    public void setNumOfShieldSlots(int numOfShieldSlots) {
        interactor.setNumOfShieldSlots(numOfShieldSlots);
    }

    /**
     * Sets the ship's number of gadget slots to the input number
     * @param numOfGadgetSlots to assign to the ship
     */
    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        interactor.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    /**
     * Sets the ship's number of crew quarters to the input number
     * @param numOfCrewQuarters to assign to the ship
     */
    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        interactor.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    /**
     * Sets the ship's maximum travel range to the input number
     * @param maxTravelRange to assign to the ship
     */
    public void setMaxTravelRange(int maxTravelRange) {
        interactor.setMaxTravelRange(maxTravelRange);
    }

    /**
     * Sets the ship's fuel tank level
     */
    public void setFullFuelTank() {
        interactor.setFullFuelTank();
    }

    /**
     * Sets the ship's fuel level to the input amount
     * @param amount of fuel to assign to the ship
     */
    public void setFuel(int amount) {
        interactor.setFuel(amount); }

    /**
     * Decreases the ship's fuel level by the input amount
     * @param amount to subtract from the ship's fuel level
     */
    public void takeAwayFromFeul(int amount) {
        interactor.takeAwayFromFeul(amount); }

    /**
     * Checks if the ship's fuel level is greater than or equal to the input amount
     * @param amount to compare to the ship's fuel level
     * @return boolean if the ship has enough fuel
     */
    public boolean checkEnoughFuel(int amount) {
        return interactor.checkEnoughFuel(amount);
    }
}