package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

public class ShipInteractor extends Interactor{

    private Ship ship;
    private Repository repo;
    public ShipInteractor(Repository repo) {super(repo);}

    //public List<Ship> getAllShips() { return getRepo().getAllShips(); }

    public void addShip(Ship ship) {
        repo = getRepo();
        repo.addShip(ship);}

    public void updateShip(Ship ship) {
        repo = getRepo();
        repo.updateShip(ship);}

    public void setMainShip(Ship ship) {
        repo = getRepo();
        repo.setMainShip(ship); }

    public Ship getMainShip() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship; }

    public String getShipName() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getShipName();
    }

    public String getShipType() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getShipType(); }

    public int getId() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getId(); }

    public int getHullStrength() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getHullStrength(); }


    public int getNumOfWeaponSlots() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getNumOfWeaponSlots(); }

    public int getNumOfShieldSlots() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getNumOfShieldSlots(); }

    public int getNumOfGadgetSlots() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getNumOfGadgetSlots(); }

    public int getNumOfCrewQuarters() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getNumOfCrewQuarters(); }

    public int getMaxTravelRange() {
        ship = repo.getMainShip();
        return ship.getMaxTravelRange(); }

    public boolean getEscapePod() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getEscapePod(); }

    public int getFuel() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getFuel(); }

    public boolean getFullFuelTank() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getFullFuelTank(); }

    public CargoHold getCargoHold() {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    public void setName(String name) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setName(name); }

    public void setId(int id) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setId(id); }

    public void setHullStrength(int hullStrength) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    public void setNumOfShieldSlots(int numOfShieldSlots) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setNumOfShieldSlots(numOfShieldSlots);
    }

    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    public void setMaxTravelRange(int maxTravelRange) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setMaxTravelRange(maxTravelRange);
    }

    public void setFullFuelTank() {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setFullFuelTank();
    }

    public void setFuel(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.setFuel(amount); }

    public void takeAwayFromFeul(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        ship.takeAwayFromFeul(amount); }

    public boolean checkEnoughFuel(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        return ship.checkEnoughFuel(amount);
    }
}
