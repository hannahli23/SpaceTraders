package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Mosquito, that extends the Ship class
 */
public class Mosquito extends Ship {
    /**
     * This is the constructor for Mosquito, that call the constructor in Ship
     */
    public Mosquito() {
        super("Mosquito", 3, 15,
                2, 1, 1,
                0, 13, false,
                1);
    }
}
