package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Termite, that extends the Ship class
 */
public class Termite extends Ship {
    /**
     * This is the constructor for Termite, that call the constructor in Ship
     */
    public Termite() {
        super("Termite", 3, 60,
                1, 3, 2,
                3, 13, false,
                1);
    }
}
