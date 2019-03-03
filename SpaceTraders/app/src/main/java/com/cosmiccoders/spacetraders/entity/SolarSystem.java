package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Planets.*;

import java.util.HashMap;
import java.util.Map;

public class SolarSystem {

    Map<String, PlanetTemp> solarSystem;

    public SolarSystem() {
        solarSystem = new HashMap<>();

        solarSystem.put("StartingPlanet", new StartingPlanet());
        solarSystem.put("Andromeda", new Andromeda());
        solarSystem.put("Baratas", new Baratas());
        solarSystem.put("Cornholio", new Cornholio());
        solarSystem.put("Drax", new Drax());
        solarSystem.put("Kravat", new Kravat());
        solarSystem.put("Omphalos", new Omphalos());
        solarSystem.put("Titikaka", new Titikaka());
    }

    public PlanetTemp getPlanet(String name) {
        return solarSystem.get(name);
    }

    public Map<String, PlanetTemp> getPlanetMap() {
        return solarSystem;
    }
}
