package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Drax extends PlanetTemp {
    public Drax(int[] location) {
        super("Drax", location, TechLevel.MEDIEVAL,
                PlanetResources.WeirdMushrooms);
    }
}
