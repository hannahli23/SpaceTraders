package com.cosmiccoders.spacetraders.entity;

public enum PlanetResources {
       // public void naturalResources () {
    NO_SPECIAL_RESOURCES(0),
    MINERAL_RICH(1),
    MINERAL_POOR(2),
    DESERT(3),
    LOTS_OF_WATER(4),
    RICH_SOIL(5),
    POOR_SOIL(6),
    RICH_FAUNA(7),
    LIFELESS(8),
    WEIRD_MUSHROOMS(9),
    LOTS_OF_HERBS(10),
    ARTISITC(11),
    WAR_LIKE(12);

    private final int resources;
    PlanetResources(int resources) {
        this.resources = resources;
    }

}

