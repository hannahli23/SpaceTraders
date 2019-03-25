package com.cosmiccoders.spacetraders.entity;

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

    public String getRepresentation(){ return difficulty; }

}
