package com.cosmiccoders.spacetraders.model;


import com.cosmiccoders.spacetraders.entity.CargoHold;
import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Market;
import com.cosmiccoders.spacetraders.entity.PlanetResources;
import com.cosmiccoders.spacetraders.entity.Planets.*;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Ships.Ship;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.entity.SolarSystem;
import com.cosmiccoders.spacetraders.entity.TechLevel;

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
        next_id = next_id + 1;
        return next_id;
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
    private final List<Ship> allShips;

    /** gets the main ship you're using now **/
    private Ship mainShip;

    private PlanetTemp planet;

    private PlanetTemp wantToGo;

    private final SolarSystem solarSystem = new SolarSystem();

    private CargoHold cargoHold;

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
        player = p;
    }

    public String toPlayerString() {
        return "You are " + player.getName() + " who travels on the " + mainShip.getShipName()
                + " which is a " + mainShip.getShipType() + " type ship which has "
                + mainShip.getFuel()
                + " fuel. \n You have "
                + player.getSkill(Skills.PILOT) + "points, "
                + player.getSkill(Skills.ENGINEER) + "points, "
                + player.getSkill(Skills.FIGHTER) + "points, and "
                + player.getSkill(Skills.TRADER) + "points in the skills "
                + "pilot, engineer, fighter, trader respectively. \n You currently have $"
                + player.getCurrency() + " and you are playing on " + player.getDifficulty()
                + " mode.";
    }

    /**
     * Gets the representation of the current player
     * @return String the current player's representation
     */
    public String getRepresentation() {
        return player.getRepresentation();
    }

    /**
     * Gets the current player's id
     * @return int the id of the current player
     */
    public int getPlayerId() {
        return player.getId(); }

    /**
     * Gets the current player's name
     * @return String the name of the current player
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Gets the current player's currency
     * @return int the currency amount of the current player
     */
    public int getCurrency() {
        return player.getCurrency();
    }

    /**
     * Gets the current player's difficulty level
     * @return Difficulty the difficulty level of the current player
     */
    public Difficulty getDifficulty() {
        return player.getDifficulty(); }

    /**
     * Gets the current player's skill
     * @param skill the skill to get the number of
     * @return int the skill number of the current player
     */
    public int getSkill(Skills skill) {
        return player.getSkill(skill);  }

    /**
     * Sets the current player's name to the input name
     * @param name the name to assign to the player
     */
    public void setPlayerName(String name) {
        player.setName(name); }

    /**
     * Sets the current player's currency to the input currency
     * @param curr the currency amount to assign to the player
     */
    public void setCurrency(int curr) {
        player.setCurrency(curr); }

    /**
     * This function checks if the currency you currently have is greater
     * or equal to the amount we want to check it against
     * @param amount the amount to check your current currency against
     * @return whether or not you have enough money
     */
    public boolean checkCurrency(int amount) {
        return player.checkCurrency(amount);
    }

    /**
     * This function takes a certain amount of money out of your currency
     * @param amount is the amount of money we want to take away from our
     *               current amount
     */
    public void pay(int amount) {
        player.pay(amount); }

    /**
     * This function puts a certain amount of money into your current currency
     * @param amount is the amount of money we want to store in your money stores
     */
    public void getPaid(int amount) {
        player.getPaid(amount); }

    /**
     * This function determines the difficulty of the game
     * This function sets a difficulty to a player
     * @param difficulty is the difficulty the player
     */
    public void setDifficulty(Difficulty difficulty) {
        player.setDifficulty(difficulty);
    }

    /**
     * This function sets an amount of points for a skill
     * @param skill is the skill that we want to append to
     * @param points is the amount of points we want to give to a skill
     */
    public void setSkills(Skills skill, int points) {
        player.setSkills(skill, points); }

    /**
     * This function sets the user's ID
     * @param id The id of the player
     */
    public void setId(int id) {
        player.setId(id);
    }

    /**
     * This function changes the currency of the player
     * @return A boolean to change the players currency
     */
    public boolean manipulateCurrency() {
        return player.manipulateCurrency();
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

    public void setSolarSystem() {
        PlanetTemp test = new Kravat();
        setPlanetSS(new StartingPlanet());
        setPlanetSS(new Andromeda());
        setPlanetSS(new Baratas());
        setPlanetSS(new Cornholio());
        setPlanetSS(new Drax());
        setPlanetSS(test);
        setPlanetSS(new Omphalos());
        setPlanetSS(new Titikaka());
        setPlanetSS(new RedDwarf());
        setPlanetSS(new BlueDwarf());
    }








    //PLANET FUNCTIONS
    public PlanetTemp getPlanet() {return planet;}

    public void setPlanet(PlanetTemp planet) {
        this.planet = planet;
    }

    public void setPlanetDestination(PlanetTemp planet) { this.wantToGo = planet; }

    public PlanetTemp getPlanetDestination() { return wantToGo; }

    /**
     * This function returns the name of the planet
     * @return The planet's name
     */
    public String getPlanetName() {
        return planet.getName();}

    /**
     * This function returns the name of the planet
     * @return The planet's name
     */
    public String getPlanetDesName() {
        return wantToGo.getName();}
    /**
     * This function returns the coordinates of the location of the planet as an array
     * @return int[] an array of the x and y coordinates of the planet's location
     */
    public int[] getLocation() { return planet.getLocation(); }

    /**
     * This function returns the coordinates of the location of the planet as an array
     * @return int[] an array of the x and y coordinates of the planet's location
     */
    public int[] getDesLocation() { return wantToGo.getLocation(); }

    /**
     * This function returns the tech level of a planet
     * @return TechLevel the planet's tech level
     */
    public TechLevel getTechLevel() {return planet.getTechLevel();}

    /**
     * This function returns the resources of a planet
     * @return PlanetResources the planet's resources
     */
    public PlanetResources getPlanetResources() {return planet.getPlanetResources();}

    /**
     * This function returns the market of a player
     * @return Market the planet's market
     */
    public Market getMarket() { return planet.getMarket();}
    //public ShipYard getShipYard() { return shipYard; }

    /**
     * This function return the information for the following planet
     * @return String representation of the planet
     */
    public String toPlanetString() {
        return planet.toString();
    }

    /**
     * This function return the information for the following planet
     * @return String representation of the planet
     */
    public String toPlanetDesString() {
        return wantToGo.toString();
    }






    //SHIP FUNCTIONS
    /**
     * get all the ships in the system
     */
    //public List<Ship> getAllShips() {return allShips; }


    public void addShip(Ship ship) {
        int id = Repository.getNextUniqueID();
        ship.setId(id);
        allShips.add(ship);
    }

    public void updateShip(Ship s) {
        mainShip = s;
    }

    public void setMainShip(Ship ship) { mainShip = ship; }

    public Ship getMainShip() { return mainShip; }

    /**
     * Gets the ship's name
     * @return String the name of the ship
     */
    public String getShipName() {
        return mainShip.getShipName();
    }

    /**
     * Gets the ship's type
     * @return String the type of the ship
     */
    public String getShipType() {
        return mainShip.getShipType(); }

    /**
     * Gets the ship's id
     * @return int the id of the ship
     */
    public int getShipId() {
        return mainShip.getId(); }

    /**
     * Gets the ship's hull strength
     * @return int the hull strength of the ship
     */
    public int getHullStrength() {
        return mainShip.getHullStrength(); }

    /**
     * Gets the ship's number of weapon slots
     * @return int the number of weapon slots of the ship
     */
    public int getNumOfWeaponSlots() {
        return mainShip.getNumOfWeaponSlots(); }

    /**
     * Gets number of shield slots of the ship
     * @return int the ship's number of shield slots
     */
    public int getNumOfShieldSlots() {
        return mainShip.getNumOfShieldSlots(); }

    /**
     * Gets number of gadget slots of the ship
     * @return int the ship's number of gadget slots
     */
    public int getNumOfGadgetSlots() {
        return mainShip.getNumOfGadgetSlots(); }

    /**
     * Gets number of crew quarters of the ship
     * @return int the ship's number of crew quarters
     */
    public int getNumOfCrewQuarters() {
        return mainShip.getNumOfCrewQuarters(); }

    /**
     * Gets max travel range of the ship
     * @return int the ship's maximum travel range
     */
    public int getMaxTravelRange() {
        return mainShip.getMaxTravelRange(); }

    /**
     * Tells whether or not the ship has an escape pod
     * @return boolean if the ship has an escape pod
     */
    public boolean getEscapePod() {
        return mainShip.getEscapePod(); }

    /**
     * Gets fuel level of the ship
     * @return int the ship's fuel level
     */
    public int getFuel() {
        return mainShip.getFuel(); }

    /**
     * Tells whether or not the ships fuel tank is full
     * @return boolean if the fuel tank is full
     */
    public boolean getFullFuelTank() {
        return mainShip.getFullFuelTank(); }

    /**
     * Gets the ship's cargo hold
     * @return CargoHold the ship's cargo hold
     */
    public CargoHold getCargoHold() {
        return mainShip.getCargoHold(); }

    //public PlanetTemp getCurrPlanet() { return currPlanet; }

    /**
     * Sets the ship's name to the input name
     * @param name to assign to the ship
     */
    public void setShipName(String name) {
        mainShip.setName(name); }

    /**
     * Sets the ship's id to the input id
     * @param id to assign to the ship
     */
    public void setShipId(int id) {
        mainShip.setId(id); }

    /**
     * Sets the ship's hull strength to the input hull strength
     * @param hullStrength to assign to the ship
     */
    public void setHullStrength(int hullStrength) {
        mainShip.setHullStrength(hullStrength);
    }

    // public void setNumOfCargoBays(int numOfCargoBays) { this.numOfCargoBays = numOfCargoBays; }

    /**
     * Sets the ship's number of weapon slots to the input number
     * @param numOfWeaponSlots to assign to the ship
     */
    public void setNumOfWeaponSlots(int numOfWeaponSlots) {
        mainShip.setNumOfWeaponSlots(numOfWeaponSlots);
    }

    /**
     * Sets the ship's number of shield slots to the input number
     * @param numOfShieldSlots to assign to the ship
     */
    public void setNumOfShieldSlots(int numOfShieldSlots) {
        mainShip.setNumOfShieldSlots(numOfShieldSlots);
    }

    /**
     * Sets the ship's number of gadget slots to the input number
     * @param numOfGadgetSlots to assign to the ship
     */
    public void setNumOfGadgetSlots(int numOfGadgetSlots) {
        mainShip.setNumOfGadgetSlots(numOfGadgetSlots);
    }

    /**
     * Sets the ship's number of crew quarters to the input number
     * @param numOfCrewQuarters to assign to the ship
     */
    public void setNumOfCrewQuarters(int numOfCrewQuarters) {
        mainShip.setNumOfCrewQuarters(numOfCrewQuarters);
    }

    /**
     * Sets the ship's maximum travel range to the input number
     * @param maxTravelRange to assign to the ship
     */
    public void setMaxTravelRange(int maxTravelRange) {
        mainShip.setMaxTravelRange(maxTravelRange);
    }

    /**
     * Sets the ship's fuel tank level
     */
    public void setFullFuelTank() {
        mainShip.setFullFuelTank();
    }

    /**
     * Sets the ship's fuel level to the input amount
     * @param amount of fuel to assign to the ship
     */
    public void setFuel(int amount) {
        mainShip.setFuel(amount); }

    /**
     * Decreases the ship's fuel level by the input amount
     * @param amount to subtract from the ship's fuel level
     */
    public void takeAwayFromFeul(int amount) {
        mainShip.takeAwayFromFeul(amount); }

    /**
     * Checks if the ship's fuel level is greater than or equal to the input amount
     * @param amount to compare to the ship's fuel level
     * @return boolean if the ship has enough fuel
     */
    public boolean checkEnoughFuel(int amount) {
        return mainShip.checkEnoughFuel(amount);
    }












    //CargoHold Stuff
    /**
     * Calls CargoHold's putCheck method which checks to see if the amount
     * of items you want to put into your cargoHold can actually fit
     * @param amount number of items you want to put into your cargoHold
     * @return boolean of whether or not the amount of items will fit
     */
    public boolean putCheck(int amount) {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.putCheck(amount);
    }

    /**
     * Calls CargoHold's putItem method which puts an amount of a certain item into the cargo hold
     * @param good is the good we want to increase
     * @param amount is the amount of a good that we want to add
     */
    public void putItem(String good, int amount) {
        cargoHold = mainShip.getCargoHold();
        cargoHold.putItem(good, amount);
    }


    /**
     * Calls CargoHold's takeCheck method which checks if there is amount of an item to take
     * @param good the good we want to take out
     * @param amount the amount of a good we want to take out
     * @return whether we can take out that amount of an item
     */
    public boolean takeCheck(String good, int amount) {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.takeCheck(good, amount);
    }

    /**
     * Calls CargoHold's takeItem method which takes an amount of an item out of the inventory
     * @param good is the good we want to take out
     * @param amount is the amount of a good we want to take out
     */
    public void takeItem(String good, int amount) {
        cargoHold = mainShip.getCargoHold();
        cargoHold.takeItem(good, amount);
    }

    /**
     * Calls CargoHold's getMax method which gets the maximum storage capacity of the ship
     * @return int the max storage capacity of the cargo hold
     */
    public int getMax() {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.getMax(); }

    /**
     * Calls CargoHold's getCurrSize method which gets the current
     * number of items in the cargo hold
     * @return int the current number of items in the cargo hold
     */
    public int getCurrSize() {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.getCurrSize(); }

    /**
     * Calls CargoHold's getCurrSize method which sets currSize equal to input amount
     * @param amount the value to set currSize to
     */
    public void setCurrSize(int amount) {
        cargoHold = mainShip.getCargoHold();
        cargoHold.setCurrSize(amount); }

    /**
     * Calls CargoHold's getInventory method which gets the caro hold's current inventory
     * @return Map<String,Integer> a map of the cargo hold's current inventory
     */
    public Map<String, Integer> getInventory() {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.getInventory(); }

    /**
     * Calls CargoHold's setInventory method which sets the cargo hold's
     * inventory to the input inventory
     * @param newInventory the map of the inventory to assign to the cargo hold
     */
    public void setInventory(Map<String, Integer> newInventory) {
        cargoHold = mainShip.getCargoHold();
        cargoHold.setInventory(newInventory);}

    /**
     * Calls CargoHold's getNumOfItem function which tells us how much of an item
     * is in the cargo hold
     * @param good the good to get the amount of
     * @return the amount of the good in the cargo hold
     */
    public int getNumOfItem(String good) {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.getNumOfItem(good);
    }

    public String toCargoHoldString() {
        cargoHold = mainShip.getCargoHold();
        return cargoHold.toString();
    }
}
