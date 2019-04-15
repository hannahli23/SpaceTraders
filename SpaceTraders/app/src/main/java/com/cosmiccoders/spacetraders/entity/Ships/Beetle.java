package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Beetle, that extends the Ship class
 */
public class Beetle extends Ship {
    /**
     * This is the constructor for Beetle, that call the constructor in Ship
     */
    public Beetle() {
        super("Beetle", 1, 50,
                0, 1, 1,
                3, 14, false,
                2);
    }
}
