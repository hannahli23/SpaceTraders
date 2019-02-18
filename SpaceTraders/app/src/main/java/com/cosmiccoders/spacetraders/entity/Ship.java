package com.cosmiccoders.spacetraders.entity;

public class Ship {
    private String name;
    private ShipTypes shipType;

    public Ship(String name) {
        this(name, ShipTypes.GNAT);
    }

    public Ship(String name, ShipTypes shipType) {
        this.name = name;
        this.shipType = shipType;
    }

    public String getShipName() { return name; }

    public ShipTypes getShipType() { return shipType; }

    public void setName(String name) { this.name = name; }

    public void setShipType(ShipTypes shipType) { this.shipType = shipType; }
}
