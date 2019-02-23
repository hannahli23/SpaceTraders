package com.cosmiccoders.spacetraders.model;


import com.cosmiccoders.spacetraders.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an abstraction of the data storage for the business classes
 */
class Repository {

    /***
     * Generate unique numbers to be used as keys
     */
    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

    /** all the players known in the application */
    private List<Player> allPlayers;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();
    }

    /**
     * get all the players in the system
     * @return list of all playerss
     */
    public List<Player> getAllPlayers() { return allPlayers;}

    /** add a new player to the game
     *
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        player.setId(Repository.getNextUniqueID());
        allPlayers.add(player);
    }

}
