package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.SolarSystemInteractor;

import java.util.Map;

public class ViewAddSolarSystemViewModel extends AndroidViewModel {

    private SolarSystemInteractor interactor;

    public ViewAddSolarSystemViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getSolarSystemInteractors();
    }

    public void setPlanetSS(PlanetTemp planet) { interactor.setPlanetSS(planet);}

    public Map<String, PlanetTemp> getPlanetMap() { return interactor.getPlanetMap(); }

    public PlanetTemp getPlanet(String name) { return interactor.getPlanet(name); }
}
