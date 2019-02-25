package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet2 extends PlanetTemp {
    public Planet2 (int[] location) {
        super("Drax", location, TechLevel.MEDIEVAL,
                PlanetResources.WeirdMushrooms);
    }
}
