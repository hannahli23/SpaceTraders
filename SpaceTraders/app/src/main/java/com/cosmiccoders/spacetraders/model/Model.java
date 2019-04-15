package com.cosmiccoders.spacetraders.model;

import java.util.HashMap;
import java.util.Map;

/**
 * main model class
 */
public final class Model {

    /** the data repository */
    private final Repository myRepository;

    private final Map<String, Object> interactorMap;

    /** Singleton Pattern Code
     *  this allows us to get access to this class
     *  anywhere, which will allow our View models to access
     *  the "back end"  more easily
     */
    private static final Model instance = new Model();

    /**
     * returns the current instance of the model
     * @return Model the instance
     */
    public static Model getInstance() { return instance; }

    /**
     * Make a new Model instance
     */
    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
        interactorMap.put("Ship", new ShipInteractor(myRepository));
        interactorMap.put("Planet", new PlanetInteractor(myRepository));
        interactorMap.put("SolarSystem", new SolarSystemInteractor(myRepository));
        interactorMap.put("CargoHold", new CargoHoldInteractor(myRepository));
    }

    /**
     * Returns the current PlanetInteractor
     * @return  PlanetInteractor current PlanetInteractor
     */
    public PlanetInteractor getPlanetInteractor() {
        return (PlanetInteractor) interactorMap.get("Planet");
    }

    /**
     * Returns the current PlayerInteractors
     * @return PlayerInteractors current PlanetInteractor
     */
    public PlayerInteractor getPlayerInteractors() {
        return (PlayerInteractor) interactorMap.get("Player");
    }

    /**
     * Returns the current ShipInteractors
     * @return ShipInteractors current ShipInteractors
     */
    public ShipInteractor getShipInteractors() {
        return (ShipInteractor) interactorMap.get("Ship");
    }

    /**
     * Returns the current SolarSystemInteractors
     * @return SolarSystemInteractors current SolarSystemInteractors
     */
    public SolarSystemInteractor getSolarSystemInteractors() {
        return (SolarSystemInteractor) interactorMap.get("SolarSystem");
    }

    /**
     * Returns the current CargoHoldInteractors
     * @return CargoHoldInteractors current CargoHoldInteractors
     */
    public CargoHoldInteractor getCargoHoldInteractors() {
        return (CargoHoldInteractor) interactorMap.get("CargoHold");
    }
}
