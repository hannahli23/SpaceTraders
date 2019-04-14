package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ShortRangeChart {

    private List<PlanetTemp> planetsInRange;

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

    public int distance(int[] currLocation, int[] destination) {
        int x1 = currLocation[0];
        int x2 = destination[0];
        int y1 = currLocation[1];
        int y2 = destination[1];
        int distance = (int) Math.sqrt(Math.pow((x1-x2), 2)
                + Math.pow((y1-y2), 2));
        return distance;
    }

    public List<PlanetTemp> getPlanetsInRange() {
        return Collections.unmodifiableList(planetsInRange);
    }
}
