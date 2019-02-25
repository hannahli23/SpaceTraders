package com.cosmiccoders.spacetraders.entity;

public enum PlanetResources {
       // public void naturalResources () {
    NoSpecialResources(0),
    MineralRich(1),
    MineralPoor(2),
    Desert(3),
    LotsOfWater(4),
    RichSoil(5),
    PoorSoil(6),
    RichFauna(7),
    LifeLess(8),
    WeirdMushrooms(9),
    LotsOfHerbs(10),
    Artistic(11),
    WarLike(12);

    private final int resources;
    PlanetResources(int resources) {
        this.resources = resources;
    }

}

