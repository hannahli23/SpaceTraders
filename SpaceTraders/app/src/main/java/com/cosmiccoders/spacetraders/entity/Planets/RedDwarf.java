package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class RedDwarf extends PlanetTemp{
    public RedDwarf() {
        super("Red Dwarf", 70, 90, TechLevel.HITECH,
                PlanetResources.POOR_SOIL);
    }
}
