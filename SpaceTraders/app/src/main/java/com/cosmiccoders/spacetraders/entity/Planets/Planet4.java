package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet4 extends PlanetTemp{

    public Planet4(int[] location) {
        super("Baratas", location, TechLevel.HITECH,
                PlanetResources.WAR_LIKE);
    }
}
