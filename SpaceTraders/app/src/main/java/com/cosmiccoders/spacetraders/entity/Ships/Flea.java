package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Flea, that extends the Ship class
 */
public class Flea extends Ship {
    /**
     * This is the constructor for Flea, that call the constructor in Ship
     */
    public Flea() {
        super("Flea", 1, 3,
                0, 0, 0,
                0, 20, true,
                8);
    }
}
