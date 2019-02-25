package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class Planet5 extends PlanetTemp {
    public Planet5 (int[] location) {
        super("Omphalos", location, TechLevel.RENAISSANCE,
                PlanetResources.WarLike);
}
