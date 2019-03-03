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

    public String getName() {return name;}
    public int[] getLocation() {return location;}
    public TechLevel getTechLevel() {return techLevel;}
    public PlanetResources getPlanetResources() {return planetResources;}

    public String toString() {
        return "This is planet " + getName() + " which is located at (" + getLocation()[0] + ", "
                + getLocation()[1]+"). It is has a tech level of " + getTechLevel()
                + " and its planet resources are " + getPlanetResources();
    }

}
