package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet1 extends PlanetTemp{

    public Planet1(int[] location) {
        super("Malcoria", location, TechLevel.INDUSTRIAL, PlanetResources.RichSoil);
    }
}

