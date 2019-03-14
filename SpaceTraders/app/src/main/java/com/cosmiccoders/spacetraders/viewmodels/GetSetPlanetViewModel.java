package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.PlanetInteractor;
import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

public class GetSetPlanetViewModel extends AndroidViewModel{
    private PlanetInteractor interactor;

    public GetSetPlanetViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlanetInteractor();
    }

    public void setPlanet(PlanetTemp planet) {interactor.setPlanet(planet);}
    public PlanetTemp getPlanet() {return interactor.getPlanet();}

}
