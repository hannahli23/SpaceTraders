package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.ShipInteractor;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

public class EditShipViewModel extends AndroidViewModel {

    private ShipInteractor interactor;

    public EditShipViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getShipInteractors();
    }

    public void updateShip(Ship ship) { interactor.updateShip(ship);}

    public void addShip(Ship ship) {
        interactor.addShip(ship);
    }

    public void setMainShip(Ship ship) { interactor.setMainShip(ship);}

    public Ship getMainShip() { return interactor.getMainShip();}

    public String getShipName() {
        return interactor.getShipName();
    }

    public String getShipType() {
        return interactor.getShipType(); }

    public int getId() {
        return interactor.getId(); }

    public int getHullStrength() {
        return interactor.getHullStrength(); }


    public int getNumOfWeaponSlots() {
        return interactor.getNumOfWeaponSlots(); }

    public int getNumOfShieldSlots() {
        return interactor.getNumOfShieldSlots(); }

    public int getNumOfGadgetSlots() {
        return interactor.getNumOfGadgetSlots(); }

    public int getNumOfCrewQuarters() {
        return interactor.getNumOfCrewQuarters(); }

    public int getMaxTravelRange() {
        return interactor.getMaxTravelRange(); }

    public boolean getEscapePod() {
        return interactor.getEscapePod(); }

    public int getFuel() {
        return interactor.getFuel(); }

    public boolean getFullFuelTank() {
        return interactor.getFullFuelTank(); }

    public CargoHold getCargoHold() {
        return interactor.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    public void setName(String name) {
        interactor.setName(name); }

    public void setId(int id) {
        interactor.setId(id); }

    public void setHullStrength(int hullStrength) {
        interactor.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        interactor.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    public void setNumOfShieldSlots(int numOfShieldSlots) {
        interactor.setNumOfShieldSlots(numOfShieldSlots);
    }

    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        interactor.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        interactor.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    public void setMaxTravelRange(int maxTravelRange) {
        interactor.setMaxTravelRange(maxTravelRange);
    }

    public void setFullFuelTank() {
        interactor.setFullFuelTank();
    }

    public void setFuel(int amount) {
        interactor.setFuel(amount); }

    public void takeAwayFromFeul(int amount) {
        interactor.takeAwayFromFeul(amount); }

    public boolean checkEnoughFuel(int amount) {
        return interactor.checkEnoughFuel(amount);
    }
}