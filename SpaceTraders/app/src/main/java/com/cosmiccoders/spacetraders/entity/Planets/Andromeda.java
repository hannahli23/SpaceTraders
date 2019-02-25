package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Andromeda extends PlanetTemp {
    public Andromeda(int[] location) {
        super("Andromeda", location, TechLevel.RENAISSANCE,
                PlanetResources.LotsOfWater);
    }
}
