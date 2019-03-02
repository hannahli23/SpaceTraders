package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Titikaka extends PlanetTemp{

    public Titikaka() {
        super("Titikaka", 100, 100, TechLevel.ARGICULTURE,
                PlanetResources.RichSoil);
    }
}
