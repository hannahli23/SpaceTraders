package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Bumblebee, that extends the Ship class
 */
public class Bumblebee extends Ship {
    /**
     * This is the constructor for Bumblebee, that call the constructor in Ship
     */
    public Bumblebee() {
        super("Bumblebee", 2, 20,
                1, 2, 2,
                1, 15, true,
                3);
    }
}
