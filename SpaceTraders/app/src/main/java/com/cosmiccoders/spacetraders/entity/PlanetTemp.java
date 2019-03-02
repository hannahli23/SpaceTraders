package com.cosmiccoders.spacetraders.entity;

public abstract class PlanetTemp {
    private String name;
    private int[] location;
    private TechLevel techLevel;
    private PlanetResources planetResources;

    protected PlanetTemp(String name, int x, int y, TechLevel techLevel,
                         PlanetResources planetResources) {
        this.name = name;
        int[] temp = {x, y};
        this.location = temp;
        this.techLevel = techLevel;
        this.planetResources = planetResources;
    }

    public String getName(String name) {return name;}
    public int[] getLocation(int[] location) {return location;}
    public TechLevel getTechLevel(TechLevel techLevel) {return techLevel;}
    public PlanetResources getPlanetResources(PlanetResources planetResources) {return planetResources;}
}
