package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Kravat extends PlanetTemp {
    public Kravat(int[] location) {
        super("Kravat", location, TechLevel.INDUSTRIAL,
                PlanetResources.LotsOfWater);
    }
}