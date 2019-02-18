package com.cosmiccoders.spacetraders.entity;

import java.util.EnumMap;

public class Person {
    /**
     * Creating all the necessary fields for a player
     * String name = name of player
     * All int values refer to the skills of the player
     * Difficulty refers the the difficulty level that the player selected
     **/
    private String name;
    private int currency;
    private Difficulty difficulty;
    private Ship ship;

    private EnumMap<Skills, Integer> skillsPoints = new EnumMap<>(Skills.class);

    public Person() {
        this("name", 0, 0, 0, 0,
                1000, Difficulty.EASY, new Ship("Grancypher"));
    }

    /**
     * One param constructor for the player
     * @param name is the name of the person
     */
    public Person(String name) {
        this(name, 0, 0, 0, 0,
                1000, Difficulty.EASY, new Ship("Grancypher"));
    }

    /**
     * Parameter for every attribute of the person
     * @param name is the name of the person
     * @param pilot is the skill points in that category
     * @param fighter is the skill points in that category
     * @param trader is the skill points in that category
     * @param engineer is the skill points in that category
     * @param difficulty is the difficulty the player choses to play at
     */
    public Person(String name, int pilot, int fighter, int trader, int engineer,
                  Difficulty difficulty) {
        this(name, pilot, fighter, trader, engineer, 1000, difficulty, new Ship("Grancypher"));
    }

    /**
     * Parameter for every attribute of the person
     * @param name is the name of the person
     * @param pilot is the skill points in that category
     * @param fighter is the skill points in that category
     * @param trader is the skill points in that category
     * @param engineer is the skill points in that category
     * @param currency is the amount of money the person currently has
     * @param difficulty is the difficulty the player choses to play at
     */
    public Person(String name, int pilot, int fighter, int trader, int engineer,
                  int currency, Difficulty difficulty, Ship ship) {
        this.name = name;

        skillsPoints.put(Skills.PILOT, pilot);
        skillsPoints.put(Skills.FIGHTER, fighter);
        skillsPoints.put(Skills.TRADER, trader);
        skillsPoints.put(Skills.ENGINEER, engineer);

        this.currency = currency;
        this.difficulty = difficulty;

        this.ship = ship;
    }

    public String getName() { return name; }

    public int getCurrency() { return currency; }

    public Difficulty getDifficulty() { return difficulty; }

    public int getSkill(Skills skill) { return skillsPoints.get(skill); }

    public Ship getShip() { return ship; }

    public void setName(String name) { this.name = name; }

    public void setCurrency(int curr) { currency = curr; }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public void setSkills(Skills skill, int points) { skillsPoints.put(skill, points); }

    public String toString() {
        String ans = "You are " + name + " who travels on the " + ship.getShipName()
                + " which is a " + ship.getShipType() + " type ship. You have "
                + getSkill(Skills.PILOT) + "points, "
                + getSkill(Skills.ENGINEER) + "points, "
                + getSkill(Skills.FIGHTER) + "points, and "
                + getSkill(Skills.TRADER) + "points in the skills "
                + "pilot, engineer, fighter, trader respectively. You currently have $"
                + getCurrency() + " and you are playing on " + getDifficulty() + " mode.";

        return ans;
    }

}