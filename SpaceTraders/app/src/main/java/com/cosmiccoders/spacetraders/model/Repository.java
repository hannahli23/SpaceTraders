package com.cosmiccoders.spacetraders.model;


import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Ship;
import com.cosmiccoders.spacetraders.entity.Skills;

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

    /** all the ships in the game */
    private List<Ship> allShips;

    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();
        allShips = new ArrayList<>();
    }

    /**
     * get all the players in the system
     * @return list of all players
     */
    public List<Player> getAllPlayers() { return allPlayers;}

    /**
     * get all the ships in the system
     */
    public List<Ship> getAllShips() {return allShips; }

    /** add a new player to the game
     *
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        int id = Repository.getNextUniqueID();
        player.setId(id);
        allPlayers.add(player);
    }

    public void updatePlayer(Player p) {
        for (Player player: allPlayers) {
            if (player.getId() == p.getId()) {
                player.setName(p.getName());
                player.setCurrency(p.getCurrency());
                player.setDifficulty(p.getDifficulty());
                player.setSkills(Skills.PILOT, p.getSkill(Skills.PILOT));
                player.setSkills(Skills.ENGINEER, p.getSkill(Skills.ENGINEER));
                player.setSkills(Skills.FIGHTER, p.getSkill(Skills.FIGHTER));
                player.setSkills(Skills.TRADER, p.getSkill(Skills.TRADER));
                player.setShip(p.getShip());
            }
        }
    }

    public void addShip(Ship ship) {
        int id = Repository.getNextUniqueID();
        ship.setId(id);
        allShips.add(ship);
    }

    public void updateShip(Ship s) {
        for (Ship ship: allShips) {
            if (ship.getId() == s.getId()) {
                ship.setShipType(s.getShipType());
                ship.setName(s.getShipName());
            }
        }
    }
}