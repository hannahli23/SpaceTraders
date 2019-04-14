package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Skills;

public class PlayerInteractor extends Interactor{

    private Player player;

    public PlayerInteractor(Repository repo) {
        super(repo);

        //repo = getRepo();
        player = getRepo().getPlayer();
    }

    public Player getPlayer() {
        player = getRepo().getPlayer();
        return player;
    }

    public void addPlayer (Player p) { getRepo().addPlayer(p);}

    public void updatePlayer (Player p) {
        getRepo().updatePlayer(p);
        Log.i("APP", "Interactor: updating player: " + p);
    }

    public String toString() { return getRepo().toString(); }

    public int getId() {
        player = getRepo().getPlayer();
        return player.getId(); }


    public String getName() {
        player = getRepo().getPlayer();
        return player.getName();
    }

    public int getCurrency() {
        player = getRepo().getPlayer();
        return player.getCurrency();
    }

    public Difficulty getDifficulty() {
        player = getRepo().getPlayer();
        return player.getDifficulty(); }

    public int getSkill(Skills skill) {
        player = getRepo().getPlayer();
        return player.getSkill(skill);  }

    public void setName(String name) {
        player = getRepo().getPlayer();
        player.setName(name); }

    public void setCurrency(int curr) {
        player = getRepo().getPlayer();
        player.setCurrency(curr); }

    public boolean checkCurrency(int amount) {
        player = getRepo().getPlayer();
        return player.checkCurrency(amount);
    }

    public void pay(int amount) {
        player = getRepo().getPlayer();
        player.pay(amount); }

    public void getPaid(int amount) {
        player = getRepo().getPlayer();
        player.getPaid(amount); }

    public void setDifficulty(Difficulty difficulty) {
        player = getRepo().getPlayer();
        player.setDifficulty(difficulty); }

       public void setSkills(Skills skill, int points) {
           player = getRepo().getPlayer();
           player.setSkills(skill, points); }

    public void setId(int id) {
        player = getRepo().getPlayer();
        player.setId(id);
    }

    public boolean manipulateCurrency() {
        player = getRepo().getPlayer();
        return player.manipulateCurrency();
    }

    public String toString2() {
        player = getRepo().getPlayer();
        return player.toString2();
    }
}
