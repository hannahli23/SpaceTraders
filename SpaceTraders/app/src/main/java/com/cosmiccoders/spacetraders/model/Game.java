package com.cosmiccoders.spacetraders.model;

import com.cosmiccoders.spacetraders.entity.Person;
import com.cosmiccoders.spacetraders.entity.Ship;

public class Game {
    private static int next_id = 1;

    private static int getNextUniqueID() {
        return next_id++;
    }

}
