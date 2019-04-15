package com.cosmiccoders.spacetraders.entity.Ships;

/**
 * This class represents a specific ship, Hornet, that extends the Ship class
 */
public class Hornet extends Ship {
    /**
     * This is the constructor for Hornet, that call the constructor in Ship
     */
    public Hornet() {
        super("Hornet", 3, 20,
                3, 2, 1,
                2, 16, false,
                3);
    }
}
