package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Skills;

public class PlayerInteractor extends Interactor{

    private Player player;
    public PlayerInteractor(Repository repo) {
        super(repo);

        player = getRepo().getPlayer();
    }

    public Player getPlayer() { return player; }

    public void addPlayer (Player p ) {getRepo().addPlayer(p);}

    public void updatePlayer (Player p) {
        getRepo().updatePlayer(p);
        Log.i("APP", "Interactor: updating player: " + p);
    }

    public String toString() { return getRepo().toString(); }

    public int getId() { return player.getId(); }


    public String getName() { return player.getName(); }

    public int getCurrency() { return player.getCurrency(); }

    public Difficulty getDifficulty() { return player.getDifficulty(); }

    public int getSkill(Skills skill) {  return player.getSkill(skill);  }

    public void setName(String name) { player.setName(name); }

    public void setCurrency(int curr) { player.setCurrency(curr); }

    public boolean checkCurrency(int amount) {
        return player.checkCurrency(amount);
    }

    public void pay(int amount) { player.pay(amount); }

    public void getPaid(int amount) { player.getPaid(amount); }

    public void setDifficulty(Difficulty difficulty) { player.setDifficulty(difficulty); }

       public void setSkills(Skills skill, int points) { player.setSkills(skill, points); }

    public void setId(int id) {
        player.setId(id);
    }

    public boolean manipulateCurrency() {
        return player.manipulateCurrency();
    }

    public String toString2() {
        return player.toString2();
    }
}
