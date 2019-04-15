package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class is the interactor for the planets
 */
public class PlanetInteractor extends Interactor {

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


     /** Sets the input planet's destination
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

    /**
     * This function returns the name of the planet
     * @return The planet's name
     */
    public String getPlanetName() {
        repo = getRepo();
        return repo.getPlanetName();}

    /**
     * This function returns the coordinates of the location of the planet as an array
     * @return int[] an array of the x and y coordinates of the planet's location
     */
    public int[] getLocation() {
        repo = getRepo();
        return repo.getLocation(); }

    /**
     * This function returns the tech level of a planet
     * @return TechLevel the planet's tech level
     */
    public TechLevel getTechLevel() {
        repo = getRepo();
        return repo.getTechLevel();}

    /**
     * This function returns the resources of a planet
     * @return PlanetResources the planet's resources
     */
    public PlanetResources getPlanetResources() {
        repo = getRepo();
        return repo.getPlanetResources();}

    /**
     * This function returns the market of a player
     * @return Market the planet's market
     */
    public Market getMarket() {
        repo = getRepo();
        return repo.getMarket();}

    public String toPlanetString() {
        repo = getRepo();
        return repo.toPlanetString();
    }

    public String getPlanetDesName() {
        repo = getRepo();
        return repo.getPlanetDesName();
    }

    public String toPlanetDesString() {
        repo = getRepo();
        return repo.toPlanetDesString();
    }

    public int[] getDesLocation() {
        repo = getRepo();
        return repo.getDesLocation();
    }

}
