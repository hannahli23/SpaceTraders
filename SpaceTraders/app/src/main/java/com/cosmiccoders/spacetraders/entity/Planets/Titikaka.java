package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, Titikaka, that extends the PlanetTemp abstract class
 */
public class Titikaka extends PlanetTemp{
    /**
     * This is the constructor for Titikaka that calls the constructor in PlanetTemp
     */
    public Titikaka() {
        super("Titikaka", 100, 100, TechLevel.ARGICULTURE,
                PlanetResources.RICH_SOIL);
    }
}
