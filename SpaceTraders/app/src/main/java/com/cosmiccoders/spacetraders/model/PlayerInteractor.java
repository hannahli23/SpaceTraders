package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import java.util.List;

import com.cosmiccoders.spacetraders.entity.Player;

public class PlayerInteractor extends Interactor{

    public PlayerInteractor(Repository repo) { super(repo);}

    public List<Player> getAllPlayers() { return getRepo().getAllPlayers(); }

    public void addPlayer (Player p ) {getRepo().addPlayer(p);}

    public void updatePlayer (Player p) {
        getRepo().updatePlayer(p);
        Log.i("APP", "Interactor: updating student: " + p);
    }
}
