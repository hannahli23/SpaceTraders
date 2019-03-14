package com.cosmiccoders.spacetraders.model;

import android.util.Log;

import com.cosmiccoders.spacetraders.entity.Player;

public class PlayerInteractor extends Interactor{

    public PlayerInteractor(Repository repo) { super(repo);}

    public Player getPlayer() { return getRepo().getPlayer(); }

    public void addPlayer (Player p ) {getRepo().addPlayer(p);}

    public void updatePlayer (Player p) {
        getRepo().updatePlayer(p);
        Log.i("APP", "Interactor: updating player: " + p);
    }

    public String toString() { return getRepo().toString();}
}
