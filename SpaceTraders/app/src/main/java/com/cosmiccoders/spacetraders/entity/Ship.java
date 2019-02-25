package com.cosmiccoders.spacetraders.entity;

public class Ship {
    private String name;
    private ShipTypes shipType;
    private int id;

    public Ship(String name) {
        this(name, ShipTypes.GNAT);
    }

    public Ship(String name, ShipTypes shipType) {
        this.name = name;
        this.shipType = shipType;
    }

    public String getShipName() { return name; }

    public ShipTypes getShipType() { return shipType; }

    public int getId() { return id; }

    public void setName(String name) { this.name = name; }

    public void setShipType(ShipTypes shipType) { this.shipType = shipType; }

    public void setId(int id) {this.id = id; }
}
