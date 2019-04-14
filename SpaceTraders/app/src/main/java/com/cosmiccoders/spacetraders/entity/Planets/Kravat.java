package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Kravat, that extends the PlanetTemp abstract class
 */
public class Kravat extends PlanetTemp {
    /**
     * This is the constructor for Kravat that calls the constructor in PlanetTemp
     */
    public Kravat() {
        super("Kravat", 0, 0, TechLevel.INDUSTRIAL,
                PlanetResources.LOTS_OF_WATER);
    }
}
