package com.cosmiccoders.spacetraders.entity.Ships;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.ShortRangeChart;

/**
 * class to represent a Ship
 */
public class Ship {
    private String name;
    private String shipType;
    private int id;
    private int hullStrength; // 1 = Weak, 2 = Medium, 3 = Strong
    //private int numOfCargoBays; // 0-60
    private CargoHold cargoHold;
    private int numOfWeaponSlots; // 0-3
    private int numOfShieldSlots; // 0-3
    private int numOfGadgetSlots; // 0-3
    private int numOfCrewQuarters; // 0-3
    private int maxTravelRange; // 13-20 parsecs (Fuel capability)
    private boolean escapePod; // Has one or doesn't

    private int fuel; // 1-8 tokens
    //private PlanetTemp currPlanet;

    private ShortRangeChart shortRangeChart;

    Ship(String shipType, int hullStrength, int numOfCargoBays,
         int numOfWeaponSlots, int numOfShieldSlots, int numOfGadgetSlots,
         int numOfCrewQuarters, int maxTravelRange, boolean escapePod, int fuelPrice) {
        this.shipType = shipType;
        this.hullStrength = hullStrength;
        this.numOfWeaponSlots = numOfWeaponSlots;
        this.numOfShieldSlots = numOfShieldSlots;
        this.numOfGadgetSlots = numOfGadgetSlots;
        this.numOfCrewQuarters = numOfCrewQuarters;
        this.maxTravelRange = maxTravelRange;
        this.escapePod = escapePod;
        this.fuel= maxTravelRange;

        cargoHold = new CargoHold(numOfCargoBays);
    }

    /**
     * Gets the ship's name
     * @return String the name of the ship
     */
    public String getShipName() { return name; }

    /**
     * Gets the ship's type
     * @return String the type of the ship
     */
    public String getShipType() { return shipType; }

    /**
     * Gets the ship's id
     * @return int the id of the ship
     */
    public int getId() { return id; }

    /**
     * Gets the ship's hull strength
     * @return int the hull strength of the ship
     */
    public int getHullStrength() { return hullStrength; }

    //public int getNumOfCargoBays() { return numOfCargoBays; }

    /**
     * Gets the ship's number of weapon slots
     * @return int the number of weapon slots of the ship
     */
    public int getNumOfWeaponSlots() { return numOfWeaponSlots; }

    /**
     * Gets number of shield slots of the ship
     * @return int the ship's number of shield slots
     */
    public int getNumOfShieldSlots() { return numOfShieldSlots; }

    /**
     * Gets number of gadget slots of the ship
     * @return int the ship's number of gadget slots
     */
    public int getNumOfGadgetSlots() { return numOfGadgetSlots; }

    /**
     * Gets number of crew quarters of the ship
     * @return int the ship's number of crew quarters
     */
    public int getNumOfCrewQuarters() { return numOfCrewQuarters; }

    /**
     * Gets max travel range of the ship
     * @return int the ship's maximum travel range
     */
    public int getMaxTravelRange() { return maxTravelRange; }

    /**
     * Tells whether or not the ship has an escape pod
     * @return boolean if the ship has an escape pod
     */
    public boolean getEscapePod() { return escapePod; }

    /**
     * Gets fuel level of the ship
     * @return int the ship's fuel level
     */
    public int getFuel() { return fuel; }

    /**
     * Tells whether or not the ships fuel tank is full
     * @return boolean if the fuel tank is full
     */
    public boolean getFullFuelTank() { return fuel == maxTravelRange; }

    /**
     * Gets the ship's cargo hold
     * @return CargoHold the ship's cargo hold
     */
    public CargoHold getCargoHold() { return cargoHold; }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    /**
     * Sets the ship's name to the input name
     * @param name to assign to the ship
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets the ship's id to the input id
     * @param id to assign to the ship
     */
    public void setId(int id) {this.id = id; }

    /**
     * Sets the ship's hull strength to the input hull strength
     * @param hullStrength to assign to the ship
     */
    public void setHullStrength(int hullStrength) {
        this.hullStrength = hullStrength;
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    /**
     * Sets the ship's number of weapon slots to the input number
     * @param numOfWeaponSlots to assign to the ship
     */
    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        this.numOfWeaponSlots = numOfWeaponSlots;
    }

    /**
     * Sets the ship's number of shield slots to the input number
     * @param numOfShieldSlots to assign to the ship
     */
    public void setNumOfShieldSlots(int numOfShieldSlots) {
        this.numOfShieldSlots = numOfShieldSlots;
    }

    /**
     * Sets the ship's number of gadget slots to the input number
     * @param numOfGadgetSlots to assign to the ship
     */
    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        this.numOfGadgetSlots = numOfGadgetSlots;
    }

    /**
     * Sets the ship's number of crew quarters to the input number
     * @param numOfCrewQuarters to assign to the ship
     */
    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        this.numOfCrewQuarters = numOfCrewQuarters;
    }

    /**
     * Sets the ship's maximum travel range to the input number
     * @param maxTravelRange to assign to the ship
     */
    public void setMaxTravelRange(int maxTravelRange) {
        this.maxTravelRange = maxTravelRange;
    }

    /**
     * Sets the ship's fuel tank level
     */
    public void setFullFuelTank() {
        fuel = maxTravelRange;
    }

    /**
     * Sets the ship's fuel level to the input amount
     * @param amount of fuel to assign to the ship
     */
    public void setFuel(int amount) { fuel = amount; }

    /**
     * Decreases the ship's fuel level by the input amount
     * @param amount to subtract from the ship's fuel level
     */
    public void takeAwayFromFeul(int amount) { fuel = fuel - amount; }

    /**
     * Checks if the ship's fuel level is greater than or equal to the input amount
     * @param amount to compare to the ship's fuel level
     * @return boolean if the ship has enough fuel
     */
    public boolean checkEnoughFuel(int amount) { return amount <= fuel; }

    //public void setPlanet(PlanetTemp currPlanet) {
        //this.currPlanet = currPlanet;
    //}
    /**
     * Sets the ship's fullFuelTank to flase
     */
    public void travel() {
        boolean fullFuelTank = false;
    }

    public void travel(int distance) {
        fuel = fuel - distance;
    }
}
