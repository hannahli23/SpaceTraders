package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Wasp, that extends the Ship class
 */
public class Wasp extends Ship {
    /**
     * This is the constructor for Wasp, that call the constructor in Ship
     */
    public Wasp() {
        super("Wasp", 3, 35,
                3, 2, 2,
                3, 14, false,
                2);
    }
}
