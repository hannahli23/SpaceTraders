package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Player;
import com.cosmiccoders.spacetraders.entity.Skills;

public class PlayerInteractor extends Interactor{

    private Player player;
    private Repository repo;

    public PlayerInteractor(Repository repo) {
        super(repo);

        //repo = getRepo();
        //player = getRepo().getPlayer();
    }

    public Player getPlayer() {
        repo = getRepo();
        player = repo.getPlayer();
        return player;
    }

    public void addPlayer (Player p) {
        repo = getRepo();
        repo.addPlayer(p);}

    public void updatePlayer (Player p) {
        repo = getRepo();
        repo.updatePlayer(p);
        Log.i("APP", "Interactor: updating player: " + p);
    }

    public String toString() {
        repo = getRepo();
        return repo.toString(); }

    public int getId() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getId(); }


    public String getName() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getName();
    }

    public int getCurrency() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getCurrency();
    }

    public Difficulty getDifficulty() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getDifficulty(); }

    public int getSkill(Skills skill) {
        repo = getRepo();
        player = repo.getPlayer();
        return player.getSkill(skill);  }

    public void setName(String name) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setName(name); }

    public void setCurrency(int curr) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setCurrency(curr); }

    public boolean checkCurrency(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        return player.checkCurrency(amount);
    }

    public void pay(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        player.pay(amount); }

    public void getPaid(int amount) {
        repo = getRepo();
        player = repo.getPlayer();
        player.getPaid(amount); }

    public void setDifficulty(Difficulty difficulty) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setDifficulty(difficulty);
    }

    public void setSkills(Skills skill, int points) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setSkills(skill, points); }

    public void setId(int id) {
        repo = getRepo();
        player = repo.getPlayer();
        player.setId(id);
    }

    public boolean manipulateCurrency() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.manipulateCurrency();
    }

    public String toString2() {
        repo = getRepo();
        player = repo.getPlayer();
        return player.toString2();
    }
}
