package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.Map;

public class CargoHoldInteractor extends Interactor{
    private Ship ship;
    private CargoHold cargoHold;
    public CargoHoldInteractor(Repository repo) {super(repo);}

    public boolean putCheck(int amount) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.putCheck(amount);
    }


    public void putItem(String good, int amount) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.putItem(good, amount);
    }


    public boolean takeCheck(String good, int amount) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.takeCheck(good, amount);
    }


    public void takeItem(String good, int amount) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.takeItem(good, amount);
    }

    public int getMax() {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getMax(); }

    public int getCurrSize() { ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getCurrSize(); }

    public void setCurrSize(int amount) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setCurrSize(amount); }

    public Map<String, Integer> getInventory() { ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getInventory(); }

    public void setInventory(Map<String, Integer> newInventory) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setInventory(newInventory);}

    public int getNumOfItem(String good) {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getNumOfItem(good);
    }

    @Override
    public String toString() {
        ship = getRepo().getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.toString();
    }
}
