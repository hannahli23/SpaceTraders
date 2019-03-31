package com.cosmiccoders.spacetraders.model;


import android.media.Image;
import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Planets.PlanetTemp;
import com.cosmiccoders.spacetraders.entity.Planets.StartingPlanet;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;
import com.cosmiccoders.spacetraders.entity.ShortRangeChart;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.entity.SolarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * Make a new Repository object
     */
    public Repository() {
        allShips = new ArrayList<>();
    }


    //ALL THE DIFFERENT COMPONENTS ARE HERE
    /** all the players known in the application */
    private Player player;

    /** all the ships in the game */
    private List<Ship> allShips;

    /** gets the main ship you're using now **/
    private Ship mainShip;

    private PlanetTemp planet;

    private PlanetTemp wantToGo;

    private SolarSystem solarSystem = new SolarSystem();

    //Add short range chart


    //PLAYER FUNCTIONS
    /**
     * get the player
     * @return the player of the game
     */
    public Player getPlayer() { return player;}

    /** add a new player to the game
     *
     * @param player the player to add
     */
    public void addPlayer(Player player) {
        //int id = Repository.getNextUniqueID();
        this.player = player;
    }

    public void updatePlayer(Player p) {
        player.setName(p.getName());
        player.setCurrency(p.getCurrency());
        player.setDifficulty(p.getDifficulty());
        player.setSkills(Skills.PILOT, p.getSkill(Skills.PILOT));
        player.setSkills(Skills.ENGINEER, p.getSkill(Skills.ENGINEER));
        player.setSkills(Skills.FIGHTER, p.getSkill(Skills.FIGHTER));
        player.setSkills(Skills.TRADER, p.getSkill(Skills.TRADER));
    }

    public String toString() {
        return "You are " + player.getName() + " who travels on the " + mainShip.getShipName()
                + " which is a " + mainShip.getShipType() + " type ship. \n You have "
                + player.getSkill(Skills.PILOT) + "points, "
                + player.getSkill(Skills.ENGINEER) + "points, "
                + player.getSkill(Skills.FIGHTER) + "points, and "
                + player.getSkill(Skills.TRADER) + "points in the skills "
                + "pilot, engineer, fighter, trader respectively. \n You currently have $"
                + player.getCurrency() + " and you are playing on " + player.getDifficulty() + " mode.";

        //return ans;
    }

    //Short Range Functions

    //Solar System Functions
    public void setPlanetSS(PlanetTemp planet) {
        solarSystem.setPlanet(planet);
    }

    public Map<String, PlanetTemp> getPlanetMap() {
        return solarSystem.getPlanetMap();
    }

    public PlanetTemp getPlanet(String name) {
        return solarSystem.getPlanet(name);
    }


    //PLANET FUNCTIONS
    public PlanetTemp getPlanet() {return planet;}

    public void setPlanet(PlanetTemp planet) {
        this.planet = planet;
    }

    public void setPlanetDestination(PlanetTemp planet) { this.wantToGo = planet; }

    public PlanetTemp getPlanetDestination() { return wantToGo; }


    //SHIP FUNCTIONS
    /**
     * get all the ships in the system
     */
    public List<Ship> getAllShips() {return allShips; }


    public void addShip(Ship ship) {
        int id = Repository.getNextUniqueID();
        ship.setId(id);
        allShips.add(ship);
    }

    public void updateShip(Ship s) {
        for (Ship ship: allShips) {
            if (ship.getId() == s.getId()) {
                ship.setName(s.getShipName());
            }
        }
    }

    public void setMainShip(Ship ship) { mainShip = ship; }

    public Ship getMainShip() { return mainShip; }


    //CHECK THIS
   // public void initializeChart(Ship ship, planet, solarSystem) {
       // ShortRangeChart myChart = new ShortRangeChart(mainShip, planet, solarSystem);

       // }
}
