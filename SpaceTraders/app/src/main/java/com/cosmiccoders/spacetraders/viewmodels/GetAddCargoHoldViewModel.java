package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.model.CargoHoldInteractor;
import com.cosmiccoders.spacetraders.model.Model;

import java.util.Map;

public class GetAddCargoHoldViewModel extends AndroidViewModel {
    private CargoHoldInteractor interactor;

    public GetAddCargoHoldViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getCargoHoldInteractors();
    }

    public boolean putCheck(int amount) {
        return interactor.putCheck(amount);
    }


    public void putItem(String good, int amount) {
        interactor.putItem(good, amount);
    }


    public boolean takeCheck(String good, int amount) {
        return interactor.takeCheck(good, amount);
    }


    public void takeItem(String good, int amount) {
        interactor.takeItem(good, amount);
    }

    public int getMax() {
        return interactor.getMax(); }

    public int getCurrSize() {
        return interactor.getCurrSize(); }

    public void setCurrSize(int amount) {
        interactor.setCurrSize(amount); }

    public Map<String, Integer> getInventory() {
        return interactor.getInventory(); }

    public void setInventory(Map<String, Integer> newInventory) {
        interactor.setInventory(newInventory);}

    public int getNumOfItem(String good) {
        return interactor.getNumOfItem(good);
    }

    @Override
    public String toString() {
        return interactor.toString();
    }
}
