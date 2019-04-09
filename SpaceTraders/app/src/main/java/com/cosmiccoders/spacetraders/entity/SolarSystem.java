package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.*;

import java.util.HashMap;
import java.util.Map;

public class SolarSystem {

    Map<String, PlanetTemp> solarSystem;

    public SolarSystem() {
        solarSystem = new HashMap<>();

        /*solarSystem.put("StartingPlanet", new StartingPlanet());
        solarSystem.put("andromeda", new andromeda());
        solarSystem.put("Baratas", new Baratas());
        solarSystem.put("Cornholio", new Cornholio());
        solarSystem.put("Drax", new Drax());
        solarSystem.put("Kravat", new Kravat());
        solarSystem.put("Omphalos", new Omphalos());
        solarSystem.put("Titikaka", new Titikaka());
        solarSystem.put("Red Dwarf", new RedDwarf());
        solarSystem.put("Blue Dwarf", new BlueDwarf());*/
    }

    public void setPlanet(PlanetTemp planet) {
        solarSystem.put(planet.getName(), planet);
    }

    public PlanetTemp getPlanet(String name) {
        return solarSystem.get(name);
    }

    public Map<String, PlanetTemp> getPlanetMap() {
        return solarSystem;
    }
}
