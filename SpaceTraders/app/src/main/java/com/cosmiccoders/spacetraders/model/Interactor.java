package com.cosmiccoders.spacetraders.model;

/**
 * Basic Interactor class
 */
public class Interactor {

    private final Repository myRepo;

    protected Interactor(Repository repo) {myRepo = repo;}

    protected  Repository getRepo() {return myRepo;}
}
