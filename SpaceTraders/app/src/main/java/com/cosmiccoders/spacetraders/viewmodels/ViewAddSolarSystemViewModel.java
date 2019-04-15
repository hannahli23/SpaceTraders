package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.SolarSystemInteractor;

import java.util.Map;

/**
 * Class representing the view of solar systems
 */
public class ViewAddSolarSystemViewModel extends AndroidViewModel {

    private final SolarSystemInteractor interactor;

    /**
     * Constructor for ViewAddSolarSystemViewModel
     * @param application the current applicatiom
     */
    public ViewAddSolarSystemViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getSolarSystemInteractors();
    }

    /**
     * Adds the input planet to the solar system
     * @param planet the planet to add to the solar system
     */
    public void setPlanetSS(PlanetTemp planet) { interactor.setPlanetSS(planet);}

    /**
     * Gets a Map representation of all of the planets in the solar system
     * @return Map<String, PlanetTemp> the solar system
     */
    public Map<String, PlanetTemp> getPlanetMap() { return interactor.getPlanetMap(); }

    /**
     * Gets the input planet from the solar system
     * @param name the planet to obtain
     * @return PlanetTemp a planet from the solar system
     */
    public PlanetTemp getPlanet(String name) { return interactor.getPlanet(name); }

    /**
     * Sets the solar system
     */
    public void setSolarSystem() { interactor.setSolarSystem(); }
}
