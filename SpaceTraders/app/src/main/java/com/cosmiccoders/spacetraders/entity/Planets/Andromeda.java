package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Andromeda extends PlanetTemp {
    public Andromeda() {
        super("andromeda", 70, 70, TechLevel.RENAISSANCE,
                PlanetResources.LOTS_OF_WATER);
    }
}
