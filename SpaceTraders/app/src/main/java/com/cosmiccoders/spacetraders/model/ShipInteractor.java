package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

public class ShipInteractor extends Interactor{

    public ShipInteractor(Repository repo) {super(repo);}

    //public List<Ship> getAllShips() { return getRepo().getAllShips(); }

    public void addShip(Ship ship) { getRepo().addShip(ship);}

    public void updateShip(Ship ship) { getRepo().updateShip(ship);}

    public void setMainShip(Ship ship) { getRepo().setMainShip(ship); }

    public Ship getMainShip() { return getRepo().getMainShip(); }
}
