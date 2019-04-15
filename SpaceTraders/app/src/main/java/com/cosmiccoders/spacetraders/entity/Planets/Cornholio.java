package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Cornholio, that extends the PlanetTemp abstract class
 */
public class Cornholio extends PlanetTemp{
    /**
     * This is the constructor for Cornholio that calls the constructor in PlanetTemp
     */
    public Cornholio() {
        super("Cornholio", 10, 110, TechLevel.RENAISSANCE,
                PlanetResources.ARTISITC);
    }
}
