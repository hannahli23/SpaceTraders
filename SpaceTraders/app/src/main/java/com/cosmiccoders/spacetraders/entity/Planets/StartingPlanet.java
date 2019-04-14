package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

/**
 * This class represents a specific planet, StartingPlanet, that extends
 * the PlanetTemp abstract class
 */
public class StartingPlanet extends PlanetTemp {
    /**
     * This is the constructor for StartingPlanet that calls the constructor in PlanetTemp
     */
    public StartingPlanet() {
        super("Rolling Hills", 75, 75, TechLevel.ARGICULTURE,
                PlanetResources.NO_SPECIAL_RESOURCES);
    }
}
