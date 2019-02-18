package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Person;
import com.cosmiccoders.spacetraders.entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

    private Person person;

    private List<Person> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void addPlayer(Person p) {
        players.add(p);
    }
}
