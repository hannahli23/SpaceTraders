package com.cosmiccoders.spacetraders.entity;

public enum PlanetResources {
       // public void naturalResources () {
    NO_SPECIAL_RESOURCES("NOSPECIALRESOURCES"),
    MINERAL_RICH("MINERALRICH"),
    MINERAL_POOR("MINERALPOOR"),
    DESERT("DESERT"),
    LOTS_OF_WATER("LOTSOFWATER"),
    RICH_SOIL("RICHSOIL"),
    POOR_SOIL("POORSOIL"),
    RICH_FAUNA("RICHFAUNA"),
    LIFELESS("LIFELESS"),
    WEIRD_MUSHROOMS("WEIRDMUSHROOMS"),
    LOTS_OF_HERBS("LOTSOFHERBS"),
    ARTISITC("ARTISITIC"),
    WAR_LIKE("WARLIKE");

    private final String resources;
    PlanetResources(String resources) {
        this.resources = resources;
    }

    public String getRepresentation() {
        return resources;
    }
}

