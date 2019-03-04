package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet3 extends PlanetTemp{

    public Planet3(int[] location) {
        super("Titikaka", location, TechLevel.ARGICULTURE,
                PlanetResources.RICH_SOIL);
    }
}
