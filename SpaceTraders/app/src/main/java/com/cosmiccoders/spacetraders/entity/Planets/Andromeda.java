package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Andromeda, that extends the PlanetTemp abstract class
 */
public class Andromeda extends PlanetTemp {
    /**
     * This is the constructor for Andromeda that calls the constructor in PlanetTemp
     */
    public Andromeda() {
        super("andromeda", 70, 70, TechLevel.RENAISSANCE,
                PlanetResources.LOTS_OF_WATER);
    }
}
