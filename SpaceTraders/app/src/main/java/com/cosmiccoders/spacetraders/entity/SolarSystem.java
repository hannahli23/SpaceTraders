package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the game's solar system
 */
public class SolarSystem {

    private final Map<String, PlanetTemp> solarSystem;

    /**
     * Constructor for SolarSystem
     * Instantiates an empty hash map
     */
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

    /**
     * Adds the input planet to the solar system
     * @param planet the planet to add to the solar system
     */
    public void setPlanet(PlanetTemp planet) {
        solarSystem.put(planet.getName(), planet);
    }

    /**
     * Gets the input planet from the solar system
     * @param name the planet to obtain
     * @return PlanetTemp a planet from the solar system
     */
    public PlanetTemp getPlanet(String name) {
        return solarSystem.get(name);
    }

    /**
     * Gets a Map representation of all of the planets in the solar system
     * @return Map<String, PlanetTemp> the solar system
     */
    public Map<String, PlanetTemp> getPlanetMap() {
        return Collections.unmodifiableMap(solarSystem);
    }
}
