package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class StartingPlanet extends PlanetTemp {

    public StartingPlanet(int[] location) {
        super("Rolling Hills", location, TechLevel.ARGICULTURE,
                PlanetResources.NO_SPECIAL_RESOURCES);
    }
}
