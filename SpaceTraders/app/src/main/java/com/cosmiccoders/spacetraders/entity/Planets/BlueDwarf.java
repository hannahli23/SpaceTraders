package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, BlueDwarf, that extends the PlanetTemp abstract class
 */
public class BlueDwarf extends PlanetTemp{
    /**
     * This is the constructor for BlueDwarf that calls the constructor in PlanetTemp
     */
    public BlueDwarf() {
        super("Blue Dwarf", 63, 36, TechLevel.PINDUSTRIAL,
                PlanetResources.LOTS_OF_HERBS);
    }
}
