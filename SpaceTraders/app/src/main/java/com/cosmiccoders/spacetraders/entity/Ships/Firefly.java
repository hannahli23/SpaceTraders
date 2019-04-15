package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Firefly, that extends the Ship class
 */
public class Firefly extends Ship {
    /**
     * This is the constructor for Firefly, that call the constructor in Ship
     */
    public Firefly() {
        super("Firefly", 2, 20,
                1, 1, 1,
                0, 17, true,
                5);
    }
}
