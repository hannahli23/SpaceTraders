package com.cosmiccoders.spacetraders.model;

import java.util.HashMap;
import java.util.Map;

public class Model {

    /** the data repository */
    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private static  Model instance = new Model();

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
    }
    public PlayerInteractor getPlayerInteractors() {
        return (PlayerInteractor) interactorMap.get("Player");
    }

    public ShipInteractor getShipInteractors() {
        return (ShipInteractor) interactorMap.get("Ship");
    }
}