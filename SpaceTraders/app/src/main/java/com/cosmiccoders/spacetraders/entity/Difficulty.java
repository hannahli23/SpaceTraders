package com.cosmiccoders.spacetraders.entity;

/**
 * Enum that represents the various difficulties that a player can select
 */
public enum Difficulty {
    BEGINNER("beginner"),
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard"),
    IMPOSSIBLE("impossible")
    ;

    private final String difficulty;

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the current difficulty level
     * @return String the current difficulty level
     */
    public String getRepresentation(){ return difficulty; }

}
