package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

public class ShipInteractor extends Interactor{

    private Ship ship;
    private CargoHold cargoHold;
    public ShipInteractor(Repository repo) {super(repo);}

    //public List<Ship> getAllShips() { return getRepo().getAllShips(); }

    public void addShip(Ship ship) { getRepo().addShip(ship);}

    public void updateShip(Ship ship) { getRepo().updateShip(ship);}

    public void setMainShip(Ship ship) { getRepo().setMainShip(ship); }

    public Ship getMainShip() { return getRepo().getMainShip(); }

    public String getShipName() {
        ship = getRepo().getMainShip();
        return ship.getShipName();
    }

    public String getShipType() {
        ship = getRepo().getMainShip();
        return ship.getShipType(); }

    public int getId() {
        ship = getRepo().getMainShip();
        return ship.getId(); }

    public int getHullStrength() {
        ship = getRepo().getMainShip();
        return ship.getHullStrength(); }


    public int getNumOfWeaponSlots() {
        ship = getRepo().getMainShip();
        return ship.getNumOfWeaponSlots(); }

    public int getNumOfShieldSlots() {
        ship = getRepo().getMainShip();
        return ship.getNumOfShieldSlots(); }

    public int getNumOfGadgetSlots() {
        ship = getRepo().getMainShip();
        return ship.getNumOfGadgetSlots(); }

    public int getNumOfCrewQuarters() {
        ship = getRepo().getMainShip();
        return ship.getNumOfCrewQuarters(); }

    public int getMaxTravelRange() {
        ship = getRepo().getMainShip();
        return ship.getMaxTravelRange(); }

    public boolean getEscapePod() {
        ship = getRepo().getMainShip();
        return ship.getEscapePod(); }

    public int getFuel() {
        ship = getRepo().getMainShip();
        return ship.getFuel(); }

    public boolean getFullFuelTank() {
        ship = getRepo().getMainShip();
        return ship.getFullFuelTank(); }

    public CargoHold getCargoHold() {
        ship = getRepo().getMainShip();
        return ship.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    public void setName(String name) {
        ship = getRepo().getMainShip();
        ship.setName(name); }

    public void setId(int id) {
        ship = getRepo().getMainShip();
        ship.setId(id); }

    public void setHullStrength(int hullStrength) {
        ship = getRepo().getMainShip();
        ship.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        ship = getRepo().getMainShip();
        ship.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    public void setNumOfShieldSlots(int numOfShieldSlots) {
        ship = getRepo().getMainShip();
        ship.setNumOfShieldSlots(numOfShieldSlots);
    }

    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        ship = getRepo().getMainShip();
        ship.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        ship = getRepo().getMainShip();
        ship.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    public void setMaxTravelRange(int maxTravelRange) {
        ship = getRepo().getMainShip();
        ship.setMaxTravelRange(maxTravelRange);
    }

    public void setFullFuelTank() {
        ship = getRepo().getMainShip();
        ship.setFullFuelTank();
    }

    public void setFuel(int amount) {
        ship = getRepo().getMainShip();
        ship.setFuel(amount); }

    public void takeAwayFromFeul(int amount) {
        ship = getRepo().getMainShip();
        ship.takeAwayFromFeul(amount); }

    public boolean checkEnoughFuel(int amount) {
        ship = getRepo().getMainShip();
        return ship.checkEnoughFuel(amount);
    }
}
