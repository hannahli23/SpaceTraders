package com.cosmiccoders.spacetraders.entity.Ships;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.ShortRangeChart;

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

    public String getShipName() { return name; }

    public String getShipType() { return shipType; }

    public int getId() { return id; }

    public int getHullStrength() { return hullStrength; }

    //public int getNumOfCargoBays() { return numOfCargoBays; }

    public int getNumOfWeaponSlots() { return numOfWeaponSlots; }

    public int getNumOfShieldSlots() { return numOfShieldSlots; }

    public int getNumOfGadgetSlots() { return numOfGadgetSlots; }

    public int getNumOfCrewQuarters() { return numOfCrewQuarters; }

    public int getMaxTravelRange() { return maxTravelRange; }

    public boolean getEscapePod() { return escapePod; }

    public int getFuel() { return fuel; }

    public boolean getFullFuelTank() { return fuel == maxTravelRange; }

    public CargoHold getCargoHold() { return cargoHold; }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    public void setName(String name) { this.name = name; }

    public void setId(int id) {this.id = id; }

    public void setHullStrength(int hullStrength) {
        this.hullStrength = hullStrength;
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        this.numOfWeaponSlots = numOfWeaponSlots;
    }

    public void setNumOfShieldSlots(int numOfShieldSlots) {
        this.numOfShieldSlots = numOfShieldSlots;
    }

    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        this.numOfGadgetSlots = numOfGadgetSlots;
    }

    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        this.numOfCrewQuarters = numOfCrewQuarters;
    }

    public void setMaxTravelRange(int maxTravelRange) {
        this.maxTravelRange = maxTravelRange;
    }

    public void setFullFuelTank() {
        fuel = maxTravelRange;
    }

    public void setFuel(int amount) { fuel = amount; }

    public void takeAwayFromFeul(int amount) { fuel = fuel - amount; }

    public boolean checkEnoughFuel(int amount) { return amount <= fuel; }

    //public void setPlanet(PlanetTemp currPlanet) {
        //this.currPlanet = currPlanet;
    //}

    public void travel(int distance) {
        fuel = fuel - distance;
    }
}
