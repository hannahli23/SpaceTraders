package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

    private Player player;

    private List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player p) {
        players.add(p);
    }
}
