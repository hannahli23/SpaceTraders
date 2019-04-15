package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

import java.util.Map;

public class SolarSystemInteractor extends Interactor {

    public SolarSystemInteractor(Repository repo) { super(repo);}

    public void setPlanetSS(PlanetTemp planet) {getRepo().setPlanetSS(planet);}

    public Map<String, PlanetTemp> getPlanetMap() { return getRepo().getPlanetMap(); }

    public PlanetTemp getPlanet(String name) {return getRepo().getPlanet(name);}

    public void setSolarSystem() { getRepo().setSolarSystem(); }

}
