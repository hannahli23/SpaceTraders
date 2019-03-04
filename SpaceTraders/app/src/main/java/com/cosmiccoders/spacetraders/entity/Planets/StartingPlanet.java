package com.cosmiccoders.spacetraders.entity.Planets;

import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;

public class StartingPlanet extends PlanetTemp {

<<<<<<< HEAD
    public StartingPlanet(int[] location) {
        super("Rolling Hills", location, TechLevel.ARGICULTURE,
                PlanetResources.NO_SPECIAL_RESOURCES);
=======
    public StartingPlanet() {
        super("Rolling Hills", 75, 75, TechLevel.ARGICULTURE,
                PlanetResources.NoSpecialResources);
>>>>>>> 39e1555dd0cb192a268bc4777c25c09780a4b4d8
    }
}
