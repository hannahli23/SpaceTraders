package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Drax, that extends the PlanetTemp abstract class
 */
public class Drax extends PlanetTemp {
    /**
     * This is the constructor for Drax that calls the constructor in PlanetTemp
     */
    public Drax() {
        super("Drax", 150, 150, TechLevel.MEDIEVAL,
                PlanetResources.WEIRD_MUSHROOMS);
    }
}
