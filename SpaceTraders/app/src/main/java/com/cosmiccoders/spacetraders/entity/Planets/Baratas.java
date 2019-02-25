package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Baratas extends PlanetTemp{

    public Baratas(int[] location) {
        super("Baratas", location, TechLevel.HITECH,
                PlanetResources.WarLike);
    }
}
