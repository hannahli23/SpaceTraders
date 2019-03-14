package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

public class PlanetInteractor extends Interactor {
    public PlanetInteractor(Repository repo) { super(repo);}

    public void setPlanet(PlanetTemp planet) { getRepo().setPlanet(planet);}

    public PlanetTemp getPlanet() {return getRepo().getPlanet();}
}