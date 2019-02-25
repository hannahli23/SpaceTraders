package com.cosmiccoders.spacetraders.entity;

public enum TechLevel {
    ARGICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EINDUSTRIAL(4),
    INDUSTRIAL(5),
    PINDUSTRIAL(6),
    HITECH(7)
    ;


    private final int code;

    TechLevel(int code) { this.code = code; }
}
