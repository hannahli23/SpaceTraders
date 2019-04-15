package com.cosmiccoders.spacetraders.entity;

/**
 * An enum representing the potential skills a player can have
 */
public enum Skills {
    PILOT("pilot"),
    FIGHTER("fighter"),
    TRADER("trader"),
    ENGINEER("engineer")
    ;

    private final String skill;

    Skills(String skill) {
        this.skill = skill;
    }

}