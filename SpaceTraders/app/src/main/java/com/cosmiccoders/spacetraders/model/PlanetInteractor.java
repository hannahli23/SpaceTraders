package com.cosmiccoders.spacetraders.model;

import android.media.Image;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

public class PlanetInteractor extends Interactor {
    public PlanetInteractor(Repository repo) { super(repo);}

    public void setPlanet(PlanetTemp planet) { getRepo().setPlanet(planet);}

    public PlanetTemp getPlanet() {return getRepo().getPlanet();}


    //planet interactors
    public void setPlanetDestination(PlanetTemp planet) {
        getRepo().setPlanetDestination(planet);
    }

    public PlanetTemp getPlanetDestination() {
        return getRepo().getPlanetDestination();
    }
}
