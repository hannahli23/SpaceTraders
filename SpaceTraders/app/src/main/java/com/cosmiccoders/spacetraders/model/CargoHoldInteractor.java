package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.Map;

public class CargoHoldInteractor extends Interactor{
    private Ship ship;
    private CargoHold cargoHold;
    private Repository repo;
    public CargoHoldInteractor(Repository repo) {super(repo);}

    public boolean putCheck(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.putCheck(amount);
    }


    public void putItem(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.putItem(good, amount);
    }


    public boolean takeCheck(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.takeCheck(good, amount);
    }


    public void takeItem(String good, int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.takeItem(good, amount);
    }

    public int getMax() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getMax(); }

    public int getCurrSize() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getCurrSize(); }

    public void setCurrSize(int amount) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setCurrSize(amount); }

    public Map<String, Integer> getInventory() {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        return cargoHold.getInventory(); }

    public void setInventory(Map<String, Integer> newInventory) {
        repo = getRepo();
        ship = repo.getMainShip();
        cargoHold = ship.getCargoHold();
        cargoHold.setInventory(newInventory);}

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
