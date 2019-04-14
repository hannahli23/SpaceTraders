package com.cosmiccoders.spacetraders.entity;

import java.util.EnumMap;

public class Player {
    /**
     * Creating all the necessary fields for a player
     * String name = name of player
     * int currency = the amount of money the player currently has
     * Difficulty refers the the difficulty level that the player selected
     * The EnumMap skillsPoints maps each skill point to the number of points in each category
     **/
    private int id;
    private String name;
    private int currency;
    private Difficulty difficulty;
    private EnumMap<Skills, Integer> skillsPoints = new EnumMap<>(Skills.class);
    //private Ship ship;

    /**
     * A empty constructor for player with default values
     */
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
    /**
     * This function returns the ID of a player
     * @return The players ID
     */
    public int getId() { return id; }
    /**
     * This function returns the name of a player
     * @return The players name
     */
    public String getName() { return name; }
    /**
     * This function returns the currency a player has
     * @return The players currency
     */
    public int getCurrency() { return currency; }
    /**
     * This function returns the difficulty chosen by a player
     * @return The players chosen difficulty
     */
    public Difficulty getDifficulty() { return difficulty; }
    /**
     * This function returns the skill points of a player
     * @return The players skill points
     */
    public int getSkill(Skills skill) { return skillsPoints.get(skill); }

    /**
     * This function returns the name of a player
     * @return The player's name
     */

    public void setName(String name) { this.name = name; }
    /**
     * This function returns the currency of a player
     * @return The player's name
     */
    public void setCurrency(int curr) { currency = curr; }

    /**
     * This function checks if the currency you currently have is greater
     * or equal to the amount we want to check it against
     * @param amount
     * @return whether or not you have enough money
     */
    public boolean checkCurrency(int amount) {
        return amount <= currency;
    }

    /**
     * This function takes a certain amount of money out of your currency
     * @param amount is the amount of money we want to take away from our
     *               current amount
     */
    public void pay(int amount) { currency -= amount; }

    /**
     * This function puts a certain amout of monday into your current currency
     * @param amount is the amount of money we want to store in your money stores
     */
    public void getPaid(int amount) {currency += amount; }


    /**
     * This function determines the difficulty of the game
     * This function sets a difficulty to a player
     * @param difficulty is the difficulty the player
     */
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    /**
     * This function sets an amount of points for a skill
     * @param skill is the skill that we want to append to
     * @param points is the amount of points we want to give to a skill
     */
    public void setSkills(Skills skill, int points) { skillsPoints.put(skill, points); }

    /**
     * This function sets the user's ID
     * @param id The id of the player
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This function changes the currency of the player
     * @return A boolean to change the players currency
     */
    public boolean manipulateCurrency() {
        if (checkCurrency(10)) {
            int newCurrency = getCurrency() - 10;
            setCurrency(newCurrency);
            return true;
        }
        return false;
    }
    /**
     * This function changes values to be of type String
     * @return A string representation of the data
     */
    public String toString2() {
        return "You are " + getName()
                + ". \n You have "
                + getSkill(Skills.PILOT) + "points, "
                + getSkill(Skills.ENGINEER) + "points, "
                + getSkill(Skills.FIGHTER) + "points, and "
                + getSkill(Skills.TRADER) + "points in the skills "
                + "pilot, engineer, fighter, trader respectively. \n You currently have $"
                + getCurrency() + " and you are playing on " + getDifficulty() + " mode.";

        //return ans;
    }

}