package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet1 extends PlanetTemp {
    public Planet1 (int[] location) {
        super("Kravat", location, TechLevel.INDUSTRIAL,
                PlanetResources.LOTS_OF_WATER);
    }
}
