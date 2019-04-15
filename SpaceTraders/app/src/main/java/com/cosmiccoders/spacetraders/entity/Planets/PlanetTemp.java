package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class is an abstract class to be used by the planet classes
 */
public abstract class PlanetTemp {
    private String name;
    private int[] location;
    private TechLevel techLevel;
    private PlanetResources planetResources;
    private Market market;
    //private ShipYard shipYard;

    /**
     * PlanetTemp constructor
     * @param name planet name
     * @param x coordinate of planet
     * @param y coordinate of planet
     * @param techLevel planet tech level
     * @param planetResources planet's resources
     */
    PlanetTemp(String name, int x, int y, TechLevel techLevel,
               PlanetResources planetResources) {
        this.name = name;
        int[] temp = {x, y};
        this.location = temp;
        this.techLevel = techLevel;
        this.planetResources = planetResources;
        market = new Market(planetResources, techLevel);
    }

    /**
     * This function returns the name of the planet
     * @return The planet's name
     */
    public String getName() {return name;}

    /**
     * This function returns the coordinates of the location of the planet as an array
     * @return int[] an array of the x and y coordinates of the planet's location
     */
    public int[] getLocation() { return location.clone(); }

    /**
     * This function returns the tech level of a planet
     * @return TechLevel the planet's tech level
     */
    public TechLevel getTechLevel() {return techLevel;}

    /**
     * This function returns the resources of a planet
     * @return PlanetResources the planet's resources
     */
    public PlanetResources getPlanetResources() {return planetResources;}

    /**
     * This function returns the market of a player
     * @return Market the planet's market
     */
    public Market getMarket() { return market;}
    //public ShipYard getShipYard() { return shipYard; }

    @Override
    public String toString() {
        return "This is planet " + getName() + " which is located at (" + getLocation()[0] + ", "
                + getLocation()[1]+"). It is has a tech level of " + getTechLevel()
                + " and its planet resources are " + getPlanetResources();
    }
}
