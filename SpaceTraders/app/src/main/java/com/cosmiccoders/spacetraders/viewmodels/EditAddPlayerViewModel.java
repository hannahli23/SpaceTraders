package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.PlayerInteractor;
import com.cosmiccoders.spacetraders.entity.Player;

/**
 * Class used to edit the player view model
 */
public class EditAddPlayerViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    /**
     * Constructor for EditAddPlayerViewModel - calls constructor of superclass
     * @param application the current application
     */
    public EditAddPlayerViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractors();
    }

    /**
     * Updates the current player
     * @param player the player to update
     */
    public void updatePlayer(Player player) {
        interactor.updatePlayer(player);
    }

    /**
     * Adds a player
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }

    /**
     * Gets the current player
     * @return Player the current player
     */
    public Player getPlayer(){ return interactor.getPlayer(); }

    /**
     * Gets the toString of the player
     * @return String the toString of the player
     */
    public String toString() { return interactor.toString();}

    /**
     * Gets the player's id
     * @return int the player's id
     */
    public int getId() { return interactor.getId(); }

    /**
     * Gets the String representation of the player
     * @return String the representation of the player
     */
    public String getRepresentation() { return interactor.getRepresentation(); }

    /**
     * Gets the player's name
     * @return String the player's name
     */
    public String getName() { return interactor.getName(); }

    /**
     * Gets the player's currency
     * @return int the player's currency amount
     */
    public int getCurrency() { return interactor.getCurrency(); }

    /**
     * Gets the player's difficulty level
     * @return Difficulty the player's current difficulty level
     */
    public Difficulty getDifficulty() { return interactor.getDifficulty(); }

    /**
     * Gets the player's points for the input skill
     * @param skill the skill to get the points from
     * @return int the points of the input skill
     */
    public int getSkill(Skills skill) {  return interactor.getSkill(skill);  }

    /**
     * Sets the player's name
     * @param name the name to assign to the player
     */
    public void setName(String name) { interactor.setName(name); }

    /**
     * Sets the player's currency
     * @param curr the currency amount to assign to the player
     */
    public void setCurrency(int curr) { interactor.setCurrency(curr); }

    /**
     * Checks to see if the player has, at least, the input amount of money
     * @param amount the amount of money to check for
     * @return boolean if the player as the input amount
     */
    public boolean checkCurrency(int amount) {
        return interactor.checkCurrency(amount);
    }

    /**
     * Uses the entered amount to make a transaction
     * Decreases the players currency amount by the entered amount
     * @param amount the amound to pay
     */
    public void pay(int amount) { interactor.pay(amount); }

    /**
     * Increases the players currency amount by the entered amount
     * @param amount the amount to increase the player's currency
     */
    public void getPaid(int amount) { interactor.getPaid(amount); }

    /**
     * Sets the player's difficulty level to the input level
     * @param difficulty the difficulty to assign to the player
     */
    public void setDifficulty(Difficulty difficulty) { interactor.setDifficulty(difficulty); }

    /**
     * Gives the player the input skill with the input points
     * @param skill the skill to assign to the player
     * @param points the number of points to assign to the player
     */
    public void setSkills(Skills skill, int points) { interactor.setSkills(skill, points); }

    /**
     * Sets the player's id to the input id
     * @param id the new id to assign to the player
     */
    public void setId(int id) {
        interactor.setId(id);
    }

    /**
     * Manipulates the player's currency
     * @return boolean if the currency was manipulated
     */
    public boolean manipulateCurrency() {
        return interactor.manipulateCurrency();
    }

    /**
     * To string for the player
     * @return String the toString for the player
     */
    public String toString2() {
        return interactor.toString2();
    }
}