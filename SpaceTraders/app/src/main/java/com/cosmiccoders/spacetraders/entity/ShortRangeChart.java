package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.List;

public class ShortRangeChart {

    private List<PlanetTemp> planetsInRange;

    public ShortRangeChart(Ship ship, SolarSystem solarSystem) {
        int[] currLocation = ship.getCurrPlanet().getLocation();
        for (PlanetTemp p : solarSystem) {
            if (distance(currLocation, p.getLocation()) <= ship.getMaxTravelRange()) {
                planetsInRange.add(p);
            }
        }
    }

    public float distance(int[] currLocation, int[] destination) {
        int x1 = currLocation[0];
        int x2 = destination[0];
        int y1 = currLocation[1];
        int y2 = destination[1];
        float distance = Math.sqrt(Math.pow((x1-x2), 2)
                + Math.pow((y1-y2), 2));
        return distance;
    }
}
