package com.cosmiccoders.spacetraders.entity;

public enum Difficulty {
    EASY("easy"),
    NORMAL("normal"),
    HARD("hard")
    ;

    private final String difficulty;

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
