package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, RedDwarf, that extends the PlanetTemp abstract class
 */
public class RedDwarf extends PlanetTemp{
    /**
     * This is the constructor for RedDwarf that calls the constructor in PlanetTemp
     */
    public RedDwarf() {
        super("Red Dwarf", 70, 90, TechLevel.HITECH,
                PlanetResources.POOR_SOIL);
    }
}
