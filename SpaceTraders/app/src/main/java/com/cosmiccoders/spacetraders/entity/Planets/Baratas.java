package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Baratas, that extends the PlanetTemp abstract class
 */
public class Baratas extends PlanetTemp{
    /**
     * This is the constructor for Baratas that calls the constructor in PlanetTemp
     */
    public Baratas() {
        super("Baratas", 110, 10, TechLevel.HITECH,
                PlanetResources.WAR_LIKE);
    }
}
