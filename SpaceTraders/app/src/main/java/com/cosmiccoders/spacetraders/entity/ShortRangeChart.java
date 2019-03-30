package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;
import com.cosmiccoders.spacetraders.entity.SolarSystem;

import java.util.List;
import java.util.Map;

public class ShortRangeChart {

    private List<PlanetTemp> planetsInRange;

    public ShortRangeChart(Ship ship, SolarSystem solarSystem) {
        int[] currLocation = ship.getCurrPlanet().getLocation();
        for (Map.Entry<String, PlanetTemp> entry: solarSystem.getPlanetMap().entrySet()) {
            if (distance(currLocation, entry.getValue().getLocation()) <= ship.getMaxTravelRange()) {
                planetsInRange.add(entry.getValue());
            }
        }
    }

    public double distance(int[] currLocation, int[] destination) {
        int x1 = currLocation[0];
        int x2 = destination[0];
        int y1 = currLocation[1];
        int y2 = destination[1];
        double distance = Math.sqrt(Math.pow((x1-x2), 2)
                + Math.pow((y1-y2), 2));
        return distance;
    }

    public List<PlanetTemp> getPlanetsInRange() {
        return planetsInRange;
    }
}
