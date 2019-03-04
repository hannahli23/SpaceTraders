package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public abstract class PlanetTemp {
    private String name;
    private int[] location;
    private TechLevel techLevel;
    private PlanetResources planetResources;

<<<<<<< HEAD:SpaceTraders/app/src/main/java/com/cosmiccoders/spacetraders/entity/Planets/PlanetTemp.java
    private Market market;

    protected PlanetTemp(String name, int[] location, TechLevel techLevel,
=======
    protected PlanetTemp(String name, int x, int y, TechLevel techLevel,
>>>>>>> 39e1555dd0cb192a268bc4777c25c09780a4b4d8:SpaceTraders/app/src/main/java/com/cosmiccoders/spacetraders/entity/PlanetTemp.java
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
