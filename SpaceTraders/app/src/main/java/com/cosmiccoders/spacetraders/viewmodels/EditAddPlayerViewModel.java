package com.cosmiccoders.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

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
}