package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class BlueDwarf extends PlanetTemp{
    public BlueDwarf() {
        super("Blue Dwarf", 63, 36, TechLevel.PINDUSTRIAL,
                PlanetResources.LOTS_OF_HERBS);
    }
}
