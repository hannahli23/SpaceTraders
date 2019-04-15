package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Skills;

/**
 * This class is the interactor for the players
 */
public class PlayerInteractor extends Interactor{

    private Player player;
    private Repository repo;

    /**
     * Constructor for the PlayerInteractor class
     * Calls the constructor of its superclass, Repository
     * @param repo the current repository
     */
    public PlayerInteractor(Repository repo) {
        super(repo);

        //repo = getRepo();
        //player = getRepo().getPlayer();
    }

    /**
     * Gets the current player object
     * @return Player the current player
     */
    public Player getPlayer() {
        repo = getRepo();
        player = repo.getPlayer();
        return player;
    }

    /**
     * Adds another player instance
     * @param p the Player to add
     */
    public void addPlayer (Player p) {
        repo = getRepo();
        repo.addPlayer(p);}

    /**
     * Updates the current player object
     * @param p the player to update
     */
    public void updatePlayer (Player p) {
        repo = getRepo();
        repo.updatePlayer(p);
        Log.i("APP", "Interactor: updating player: " + p);
    }

    /**
     * Gets the representation of the current player
     * @return String the current player's representation
     */
    public String getRepresentation() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getRepresentation();
    }

    /**
     * Gets the toString of the current repository
     * @return String the string representation of the repository
     */
    public String toString() {
        repo = getRepo();
        return repo.toString(); }

    /**
     * Gets the current player's id
     * @return int the id of the current player
     */
    public int getId() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getId(); }

    /**
     * Gets the current player's name
     * @return String the name of the current player
     */
    public String getName() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getName();
    }

    /**
     * Gets the current player's currency
     * @return int the currency amount of the current player
     */
    public int getCurrency() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getCurrency();
    }

    /**
     * Gets the current player's difficulty level
     * @return Difficulty the difficulty level of the current player
     */
    public Difficulty getDifficulty() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getDifficulty(); }

    /**
     * Gets the current player's skill
     * @param skill the skill to get the number of
     * @return int the skill number of the current player
     */
    public int getSkill(Skills skill) {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getSkill(skill);  }

    /**
     * Sets the current player's name to the input name
     * @param name the name to assign to the player
     */
    public void setName(String name) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setName(name); }

    /**
     * Sets the current player's currency to the input currency
     * @param curr the currency amount to assign to the player
     */
    public void setCurrency(int curr) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setCurrency(curr); }

    /**
     * This function checks if the currency you currently have is greater
     * or equal to the amount we want to check it against
     * @param amount the amount to check your current currency against
     * @return whether or not you have enough money
     */
    public boolean checkCurrency(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        return player.checkCurrency(amount);
    }

    /**
     * This function takes a certain amount of money out of your currency
     * @param amount is the amount of money we want to take away from our
     *               current amount
     */
    public void pay(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        player.pay(amount); }

    /**
     * This function puts a certain amount of money into your current currency
     * @param amount is the amount of money we want to store in your money stores
     */
    public void getPaid(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        player.getPaid(amount); }

    /**
     * This function determines the difficulty of the game
     * This function sets a difficulty to a player
     * @param difficulty is the difficulty the player
     */
    public void setDifficulty(Difficulty difficulty) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setDifficulty(difficulty);
    }

    /**
     * This function sets an amount of points for a skill
     * @param skill is the skill that we want to append to
     * @param points is the amount of points we want to give to a skill
     */
    public void setSkills(Skills skill, int points) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setSkills(skill, points); }

    /**
     * This function sets the user's ID
     * @param id The id of the player
     */
    public void setId(int id) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setId(id);
    }

    /**
     * This function changes the currency of the player
     * @return A boolean to change the players currency
     */
    public boolean manipulateCurrency() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.manipulateCurrency();
    }

    /**
     * This function changes values to be of type String
     * @return A string representation of the data
     */
    public String toString2() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.toString2();
    }
}
