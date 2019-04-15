package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

import java.util.Map;

/**
 * Class representing the interaction of solar systems
 */
public class SolarSystemInteractor extends Interactor {
    private Repository repo;

    /**
     * Constructor for SolarSystemInteractor
     * @param repo the current repository
     */
    public SolarSystemInteractor(Repository repo) { super(repo);}

    /**
     * Adds the input planet to the solar system
     * @param planet the planet to add to the solar system
     */
    public void setPlanetSS(PlanetTemp planet) {
        repo = getRepo();
        repo.setPlanetSS(planet);}


    /**
     * Gets a Map representation of all of the planets in the solar system
     * @return Map<String, PlanetTemp> the solar system
     */
    public Map<String, PlanetTemp> getPlanetMap() {
        repo = getRepo();
        return repo.getPlanetMap(); }

    /**
     * Gets the input planet from the solar system
     * @param name the planet to obtain
     * @return PlanetTemp a planet from the solar system
     */
    public PlanetTemp getPlanet(String name) {
        repo = getRepo();
        return repo.getPlanet(name);}

    /**
     * Sets the solar system
     */
    public void setSolarSystem() {
        repo = getRepo();
        repo.setSolarSystem(); }

}
