package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.cosmiccoders.spacetraders.entity.Difficulty;
import com.cosmiccoders.spacetraders.entity.Skills;
import com.cosmiccoders.spacetraders.model.Model;
import com.cosmiccoders.spacetraders.model.PlayerInteractor;
import com.cosmiccoders.spacetraders.entity.Player;

public class EditAddPlayerViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    public EditAddPlayerViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractors();
    }

    public void updatePlayer(Player player) {
        interactor.updatePlayer(player);
    }

    public void addPlayer(Player player) {
        interactor.addPlayer(player);
    }

    public Player getPlayer(){ return interactor.getPlayer(); }
    public String toString() { return interactor.toString();}

    public int getId() { return interactor.getId(); }


    public String getName() { return interactor.getName(); }

    public int getCurrency() { return interactor.getCurrency(); }

    public Difficulty getDifficulty() { return interactor.getDifficulty(); }

    public int getSkill(Skills skill) {  return interactor.getSkill(skill);  }

    public void setName(String name) { interactor.setName(name); }

    public void setCurrency(int curr) { interactor.setCurrency(curr); }

    public boolean checkCurrency(int amount) {
        return interactor.checkCurrency(amount);
    }

    public void pay(int amount) { interactor.pay(amount); }

    public void getPaid(int amount) { interactor.getPaid(amount); }

    public void setDifficulty(Difficulty difficulty) { interactor.setDifficulty(difficulty); }

    public void setSkills(Skills skill, int points) { interactor.setSkills(skill, points); }

    public void setId(int id) {
        interactor.setId(id);
    }

    public boolean manipulateCurrency() {
        return interactor.manipulateCurrency();
    }

    public String toString2() {
        return interactor.toString2();
    }
}