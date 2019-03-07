package com.cosmiccoders.spacetraders.entity;

import com.cosmiccoders.spacetraders.entity.Ships.Ship;

import java.util.EnumMap;
import java.util.List;

public class Player {
    /**
     * Creating all the necessary fields for a player
     * String name = name of player
     * All int values refer to the skills of the player
     * Difficulty refers the the difficulty level that the player selected
     **/
    private int id;
    private String name;
    private int currency;
    private Difficulty difficulty;
    private Ship ship;

    private List<TradeGood> tradeGoods;

    private EnumMap<Skills, Integer> skillsPoints = new EnumMap<>(Skills.class);

    public Player() {
        this("Gran", 0, 0, 0, 0,
                1000, Difficulty.EASY);
    }

    /**
     * One param constructor for the Player
     * @param name is the name of the Player
     */
    public Player(String name) {
        this(name, 0, 0, 0, 0,
                1000, Difficulty.EASY);
    }

    /**
     * Parameter for every attribute of the Player
     * @param name is the name of the Player
     * @param pilot is the skill points in that category
     * @param fighter is the skill points in that category
     * @param trader is the skill points in that category
     * @param engineer is the skill points in that category
     * @param difficulty is the difficulty the player chooses to play at
     */
    public Player(String name, int pilot, int fighter, int trader, int engineer,
                  Difficulty difficulty) {
        this(name, pilot, fighter, trader, engineer, 1000, difficulty);
    }

    /**
     * Parameter for every attribute of the Player
     * @param name is the name of the Player
     * @param pilot is the skill points in that category
     * @param fighter is the skill points in that category
     * @param trader is the skill points in that category
     * @param engineer is the skill points in that category
     * @param currency is the amount of money the Player currently has
     * @param difficulty is the difficulty the player chooses to play at
     */
    public Player(String name, int pilot, int fighter, int trader, int engineer,
                  int currency, Difficulty difficulty) {
        this.name = name;

        skillsPoints.put(Skills.PILOT, pilot);
        skillsPoints.put(Skills.FIGHTER, fighter);
        skillsPoints.put(Skills.TRADER, trader);
        skillsPoints.put(Skills.ENGINEER, engineer);

        this.currency = currency;
        this.difficulty = difficulty;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public int getCurrency() { return currency; }

    public Difficulty getDifficulty() { return difficulty; }

    public int getSkill(Skills skill) { return skillsPoints.get(skill); }

    public Ship getShip() { return ship; }

    public void setName(String name) { this.name = name; }

    public void setCurrency(int curr) { currency = curr; }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public void setSkills(Skills skill, int points) { skillsPoints.put(skill, points); }

    public void setShip(Ship ship) { this.ship = ship; }

    public String toString() {
        String ans = "You are " + name + " who travels on the " + ship.getShipName()
                + " which is a " + ship.getShipType() + " type ship. \n You have "
                + getSkill(Skills.PILOT) + "points, "
                + getSkill(Skills.ENGINEER) + "points, "
                + getSkill(Skills.FIGHTER) + "points, and "
                + getSkill(Skills.TRADER) + "points in the skills "
                + "pilot, engineer, fighter, trader respectively. \n You currently have $"
                + getCurrency() + " and you are playing on " + getDifficulty() + " mode.";

        return ans;
    }

    public void setId(int id) {
        this.id = id;
    }

}