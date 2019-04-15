package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.TechLevel;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.PlanetInteractor;
import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;

/**
 * Class used to edit the get set player view model
 */
public class GetSetPlanetViewModel extends AndroidViewModel{
    private final PlanetInteractor interactor;

    /**
     * Constructor for GetSetPlanetViewModel - calls constructor of superclass
     * @param application the current application
     */
    public GetSetPlanetViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlanetInteractor();
    }

    /**
     * Sets the current planet
     * @param planet the planet to set
     */
    public void setPlanet(PlanetTemp planet) {interactor.setPlanet(planet);}

    /**
     * Gets the current planet
     * @return PlanetTemp the current planet
     */
    public PlanetTemp getPlanet() {return interactor.getPlanet();}

    /**
     * Sets the current planet's destination
     * @param planet the planet whose destination to set
     */
    public void setPlanetDestination(PlanetTemp planet) {interactor.setPlanetDestination(planet);}

    /**
     * Gets the current planet's destination
     * @return PlanetTemp the planet's destination
     */
    public PlanetTemp getPlanetDestination() {return interactor.getPlanetDestination();}

    /**
     * This function returns the name of the planet
     * @return The planet's name
     */
    public String getPlanetName() {
        return interactor.getPlanetName();}

    /**
     * This function returns the coordinates of the location of the planet as an array
     * @return int[] an array of the x and y coordinates of the planet's location
     */
    public int[] getLocation() {
        return interactor.getLocation(); }

    /**
     * This function returns the tech level of a planet
     * @return TechLevel the planet's tech level
     */
    public TechLevel getTechLevel() {
        return interactor.getTechLevel();}

    /**
     * This function returns the resources of a planet
     * @return PlanetResources the planet's resources
     */
    public PlanetResources getPlanetResources() {
        return interactor.getPlanetResources();}

    /**
     * This function returns the market of a player
     * @return Market the planet's market
     */
    public Market getMarket() {
        return interactor.getMarket();}
    //public ShipYard getShipYard() { return shipYard; }

    public String toPlanetString() {
        return interactor.toPlanetString();
    }

    public String getPlanetDestName() {
        return interactor.getPlanetDesName();
    }

    public String toPlanetDestString() {
        return interactor.toPlanetDesString();
    }

    public int[] getDesLocation() {
        return interactor.getDesLocation();
    }
}
