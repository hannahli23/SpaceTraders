package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Drax extends PlanetTemp {
    public Drax() {
        super("Drax", 150, 150, TechLevel.MEDIEVAL,
                PlanetResources.WeirdMushrooms);
    }
}
