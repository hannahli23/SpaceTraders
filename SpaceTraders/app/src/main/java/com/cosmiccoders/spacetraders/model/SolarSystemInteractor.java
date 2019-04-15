package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

import java.util.Map;


public class SolarSystemInteractor extends Interactor {
    private Repository repo;
    public SolarSystemInteractor(Repository repo) { super(repo);}

    public void setPlanetSS(PlanetTemp planet) {
        repo = getRepo();
        repo.setPlanetSS(planet);}

    public Map<String, PlanetTemp> getPlanetMap() {
        repo = getRepo();
        return repo.getPlanetMap(); }

    public PlanetTemp getPlanet(String name) {
        repo = getRepo();
        return repo.getPlanet(name);}

    public void setSolarSystem() {
        repo = getRepo();
        repo.setSolarSystem(); }

}
