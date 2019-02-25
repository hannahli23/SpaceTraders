package com.cosmiccoders.spacetraders.model;

import java.util.List;

import com.cosmiccoders.spacetraders.entity.Ship;

public class ShipInteractor extends Interactor{

    public ShipInteractor(Repository repo) {super(repo);}

    public List<Ship> getAllShips() { return getRepo().getAllShips(); }

    public void addShip(Ship ship) { getRepo().addShip(ship);}

    public void updateShip(Ship ship) { getRepo().updateShip(ship);}
}
