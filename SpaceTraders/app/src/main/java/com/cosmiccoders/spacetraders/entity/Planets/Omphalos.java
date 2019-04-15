package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;


/**
 * This class represents a specific planet, Omphalos, that extends the PlanetTemp abstract class
 */
public class Omphalos extends PlanetTemp {
    /**
     * This is the constructor for Omphalos that calls the constructor in PlanetTemp
     */
    public Omphalos() {
        super("Omphalos", 40, 40, TechLevel.RENAISSANCE,
                PlanetResources.WAR_LIKE);
    }
}
