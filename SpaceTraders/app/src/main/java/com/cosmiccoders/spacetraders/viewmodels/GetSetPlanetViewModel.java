package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.PlanetInteractor;
import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

/**
 * Class used to edit the get set player view model
 */
public class GetSetPlanetViewModel extends AndroidViewModel{
    private PlanetInteractor interactor;

    /**
     * Constructor for GetSetPlanetViewModel - calls constructor of superclass
     * @param application the current application
     */
    public GetSetPlanetViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlanetInteractor();
    }

    /**
     * Sets the current planet
     * @param planet the planet to set
     */
    public void setPlanet(PlanetTemp planet) {interactor.setPlanet(planet);}

    /**
     * Gets the current planet
     * @return PlanetTemp the current planet
     */
    public PlanetTemp getPlanet() {return interactor.getPlanet();}

    /**
     * Sets the current planet's destination
     * @param planet the planet whose destination to set
     */
    public void setPlanetDestination(PlanetTemp planet) {interactor.setPlanetDestination(planet);}

    /**
     * Gets the current planet's destination
     * @return PlanetTemp the planet's destination
     */
    public PlanetTemp getPlanetDestination() {return interactor.getPlanetDestination();}

}
