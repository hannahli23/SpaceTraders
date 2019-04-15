package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Grasshopper, that extends the Ship class
 */
public class Grasshopper extends Ship {
    /**
     * This is the constructor for Grasshopper, that call the constructor in Ship
     */
    public Grasshopper() {
        super("Grasshopper", 3, 30,
                2, 2, 3,
                3, 15, false,
                2);
    }
}
