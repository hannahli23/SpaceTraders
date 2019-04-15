package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Player;

/**
 * This class is the interactor for the planets
 */
public class PlanetInteractor extends Interactor {

    private Player player;
    private Repository repo;

    /**
     * Constructor for PlanetInteractor
     * @param repo the current repository
     */
    public PlanetInteractor(Repository repo) { super(repo);}

    /**
     * Sets the planet
     * @param planet the planet to set
     */
    public void setPlanet(PlanetTemp planet) {
        repo = getRepo();
        repo.setPlanet(planet);
    }

    /**
     * Gets the current planet
     * @return PlanetTemp the current planet
     */
    public PlanetTemp getPlanet() {
        repo = getRepo();
        return repo.getPlanet();
    }

    /**
     * Sets the input planet's destination
     * @param planet the planet whose destination to set
     */
    public void setPlanetDestination(PlanetTemp planet) {
        repo = getRepo();
        repo.setPlanetDestination(planet);
    }

    /**
     * Gets the current planet's destination
     * @return PlanetTemp plantet's destination
     */
    public PlanetTemp getPlanetDestination() {
        repo = getRepo();
        return repo.getPlanetDestination();
    }
}
