package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public abstract class PlanetTemp {
    private String name;
    private int[] location;
    private TechLevel techLevel;
    private PlanetResources planetResources;
    private Market market;
    //private ShipYard shipYard;

    protected PlanetTemp(String name, int x, int y, TechLevel techLevel,
                         PlanetResources planetResources) {
        this.name = name;
        int[] temp = {x, y};
        this.location = temp;
        this.techLevel = techLevel;
        this.planetResources = planetResources;
        market = new Market(planetResources, techLevel);
    }

    public String getName() {return name;}
    public int[] getLocation() { return location.clone(); }
    public TechLevel getTechLevel() {return techLevel;}
    public PlanetResources getPlanetResources() {return planetResources;}
    public Market getMarket() { return market;}
    //public ShipYard getShipYard() { return shipYard; }

    @Override
    public String toString() {
        return "This is planet " + getName() + " which is located at (" + getLocation()[0] + ", "
                + getLocation()[1]+"). It is has a tech level of " + getTechLevel()
                + " and its planet resources are " + getPlanetResources();
    }
}
