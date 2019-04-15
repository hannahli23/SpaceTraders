package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

/**
 * class to represent a ship interactor
 */
public class ShipInteractor extends Interactor{

    private Ship ship;
    private Repository repo;
    public ShipInteractor(Repository repo) {super(repo);}

    //public List<Ship> getAllShips() { return getRepo().getAllShips(); }

    /**
     * Adds a ship object to ship interactor
     * @param ship the ship to add
     */
    public void addShip(Ship ship) {
        repo = getRepo();
        repo.addShip(ship);}

    /**
     * Updates the input ship object
     * @param ship the ship to update
     */
    public void updateShip(Ship ship) {
        repo = getRepo();
        repo.updateShip(ship);}

    /**
     * Sets the input ship to be the main ship
     * @param ship the ship to set as the main ship
     */
    public void setMainShip(Ship ship) {
        repo = getRepo();
        repo.setMainShip(ship); }

    /**
     * Gets the main ship
     * @return ship the main ship
     */
    public Ship getMainShip() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship; }

    /**
     * Gets the ship's name
     * @return String the name of the ship
     */
    public String getShipName() {
        repo = getRepo();
        return repo.getShipName();
    }

    /**
     * Gets the ship's type
     * @return String the type of the ship
     */
    public String getShipType() {
        repo = getRepo();
        return repo.getShipType(); }

    /**
     * Gets the ship's id
     * @return int the id of the ship
     */
    public int getId() {
        repo = getRepo();
        return repo.getShipId(); }

    /**
     * Gets the ship's hull strength
     * @return int the hull strength of the ship
     */
    public int getHullStrength() {
        repo = getRepo();
        return repo.getHullStrength(); }

    /**
     * Gets the ship's number of weapon slots
     * @return int the number of weapon slots of the ship
     */
    public int getNumOfWeaponSlots() {
        repo = getRepo();
        return repo.getNumOfWeaponSlots(); }

    /**
     * Gets number of shield slots of the ship
     * @return int the ship's number of shield slots
     */
    public int getNumOfShieldSlots() {
        repo = getRepo();
        return repo.getNumOfShieldSlots(); }

    /**
     * Gets number of gadget slots of the ship
     * @return int the ship's number of gadget slots
     */
    public int getNumOfGadgetSlots() {
        repo = getRepo();
        return repo.getNumOfGadgetSlots(); }

    /**
     * Gets number of crew quarters of the ship
     * @return int the ship's number of crew quarters
     */
    public int getNumOfCrewQuarters() {
        repo = getRepo();
        return repo.getNumOfCrewQuarters(); }

    /**
     * Gets max travel range of the ship
     * @return int the ship's maximum travel range
     */
    public int getMaxTravelRange() {
        repo = getRepo();
        return repo.getMaxTravelRange(); }

    /**
     * Tells whether or not the ship has an escape pod
     * @return boolean if the ship has an escape pod
     */
    public boolean getEscapePod() {
        repo = getRepo();
        return repo.getEscapePod(); }

    /**
     * Gets fuel level of the ship
     * @return int the ship's fuel level
     */
    public int getFuel() {
        repo = getRepo();
        return repo.getFuel(); }

    /**
     * Tells whether or not the ships fuel tank is full
     * @return boolean if the fuel tank is full
     */
    public boolean getFullFuelTank() {
        repo = getRepo();
        return repo.getFullFuelTank(); }

    /**
     * Gets the ship's cargo hold
     * @return CargoHold the ship's cargo hold
     */
    public CargoHold getCargoHold() {
        repo = getRepo();
        return repo.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    /**
     * Sets the ship's name to the input name
     * @param name to assign to the ship
     */
    public void setName(String name) {
        repo = getRepo();
        repo.setShipName(name); }

    /**
     * Sets the ship's id to the input id
     * @param id to assign to the ship
     */
    public void setId(int id) {
        repo = getRepo();
        repo.setShipId(id); }

    /**
     * Sets the ship's hull strength to the input hull strength
     * @param hullStrength to assign to the ship
     */
    public void setHullStrength(int hullStrength) {
        repo = getRepo();
        repo.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    /**
     * Sets the ship's number of weapon slots to the input number
     * @param numOfWeaponSlots to assign to the ship
     */
    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        repo = getRepo();
        repo.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    /**
     * Sets the ship's number of shield slots to the input number
     * @param numOfShieldSlots to assign to the ship
     */
    public void setNumOfShieldSlots(int numOfShieldSlots) {
        repo = getRepo();
        repo.setNumOfShieldSlots(numOfShieldSlots);
    }

    /**
     * Sets the ship's number of gadget slots to the input number
     * @param numOfGadgetSlots to assign to the ship
     */
    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        repo = getRepo();
        repo.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    /**
     * Sets the ship's number of crew quarters to the input number
     * @param numOfCrewQuarters to assign to the ship
     */
    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        repo = getRepo();
        repo.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    /**
     * Sets the ship's maximum travel range to the input number
     * @param maxTravelRange to assign to the ship
     */
    public void setMaxTravelRange(int maxTravelRange) {
        repo = getRepo();
        repo.setMaxTravelRange(maxTravelRange);
    }

    /**
     * Sets the ship's fuel tank level
     */
    public void setFullFuelTank() {
        repo = getRepo();
        repo.setFullFuelTank();
    }

    /**
     * Sets the ship's fuel level to the input amount
     * @param amount of fuel to assign to the ship
     */
    public void setFuel(int amount) {
        repo = getRepo();
        repo.setFuel(amount); }

    /**
     * Decreases the ship's fuel level by the input amount
     * @param amount to subtract from the ship's fuel level
     */
    public void takeAwayFromFeul(int amount) {
        repo = getRepo();
        repo.takeAwayFromFeul(amount); }

    /**
     * Checks if the ship's fuel level is greater than or equal to the input amount
     * @param amount to compare to the ship's fuel level
     * @return boolean if the ship has enough fuel
     */
    public boolean checkEnoughFuel(int amount) {
        repo = getRepo();
        return repo.checkEnoughFuel(amount);
    }
}
