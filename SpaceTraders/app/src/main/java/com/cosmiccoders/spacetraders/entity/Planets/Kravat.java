package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Kravat extends PlanetTemp {
    public Kravat() {
        super("Kravat", 0, 0, TechLevel.INDUSTRIAL,
                PlanetResources.LotsOfWater);
    }
}
