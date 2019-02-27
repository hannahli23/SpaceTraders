package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Ship;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.ShipInteractor;

public class EditShipHomeViewModel extends AndroidViewModel {

    private ShipInteractor interactor;

    public EditShipHomeViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getShipInteractors();
    }

    public void updateShip(Ship ship) {
        interactor.updateShip(ship);
    }

    public void addShip(Ship ship) {
        interactor.addShip(ship);
    }

}
