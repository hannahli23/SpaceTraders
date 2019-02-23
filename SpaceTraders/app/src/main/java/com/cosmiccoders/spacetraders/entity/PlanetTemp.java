package com.cosmiccoders.spacetraders.entity;

abstract class PlanetTemp {
    private String name;
    private int[] location;
    private TechLevel techLevel;
    private PlanetResources planetResources;

    public void setName(String name) {this.name = name;}
    public void setLocation(int[] location) {this.location = location;}
    public void setTechLevel(TechLevel techLevel) {this.techLevel = techLevel;}
    public void setPlanetResources(PlanetResources planetResources) {this.planetResources = planetResources;}
}
