package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Omphalos extends PlanetTemp {
    public Omphalos() {
        super("Omphalos", 40, 40, TechLevel.RENAISSANCE,
                PlanetResources.WarLike);
    }
}
