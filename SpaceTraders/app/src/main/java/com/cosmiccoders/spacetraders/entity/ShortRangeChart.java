package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class that keeps track of the planets in a range
 */
public class ShortRangeChart {

    private final List<PlanetTemp> planetsInRange;

    /**
     * Constructor for ShortRangeChart
     * @param ship the ship to check the range against the planet
     * @param mainPlanet the main planet in the solar system
     * @param solarSystem a Map of all planets in the solar system
     */
    public ShortRangeChart(Ship ship, PlanetTemp mainPlanet, Map<String, PlanetTemp>solarSystem) {
        int[] currLocation = mainPlanet.getLocation();
        planetsInRange = new ArrayList<>();
        for (Map.Entry<String, PlanetTemp> entry: solarSystem.entrySet()) {
            if (distance(currLocation, entry.getValue().getLocation()) <=
                    ship.getMaxTravelRange()) {
                planetsInRange.add(entry.getValue());
            }
        }
    }

    /**
     * Gets the distance to the destination planet
     * @param currLocation a array of the ships current location coordinates
     * @param destination a array of the ships desitnation location coordinates
     * @return int the distance from the current location to the destination location
     */
    public int distance(int[] currLocation, int[] destination) {
        int x1 = currLocation[0];
        int x2 = destination[0];
        int y1 = currLocation[1];
        int y2 = destination[1];
        int distance = (int) Math.sqrt(Math.pow((x1-x2), 2)
                + Math.pow((y1-y2), 2));
        return distance;
    }

    /**
     * Gets a list of the planets in range of the ship
     * @return List<PlanetTemp> an array of planets in range of the ship
     */
    public List<PlanetTemp> getPlanetsInRange() {
        return Collections.unmodifiableList(planetsInRange);
    }
}
