package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet3 extends PlanetTemp {
    String name = "Titikaka";
    private int[] location = {3,2};
    private TechLevel techLevel = TechLevel.HITECH;
//    private PlanetResources planetResources = PlanetResources;

    public Planet3() {
        super.setName(name);
        super.setLocation(location);
        super.setTechLevel(techLevel);
//        super.setPlanetResources(planetResources);
    }
}
