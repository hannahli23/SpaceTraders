package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Gnat, that extends the Ship class
 */
public class Gnat extends Ship {
    /**
     * This is the constructor for Gnat, that call the constructor in Ship
     */
    public Gnat() {
        super("Gnat", 2, 15,
                1, 0, 1,
                0, 14, false,
                2);
    }
}
