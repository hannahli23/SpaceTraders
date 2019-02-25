package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet6 extends PlanetTemp{

    public Planet6(int[] location) {
        super("Cornholio", location, TechLevel.RENAISSANCE,
                PlanetResources.Artistic);
    }
}
