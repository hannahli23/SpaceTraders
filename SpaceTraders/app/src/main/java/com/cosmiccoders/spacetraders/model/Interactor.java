package com.cosmiccoders.spacetraders.model;

public class Interactor {

    private Repository myRepo;

    protected Interactor(Repository repo) {myRepo = repo;}

    protected  Repository getRepo() {return myRepo;}
}