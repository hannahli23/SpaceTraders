const express = require('express');
var logger = require('winston');


var player = require('./player');
var ship = require('./ship');
var cargohold = require('./cargohold');
var items = require('./items');


logger.info('Routes initialized');

module.exports = function(app){
    console.log('Got Routes');

    app.use('/myapi/player', player);
    app.use('/myapi/ship', ship);
    app.use('/myapi/cargohold', cargohold);
    app.use('/myapi/items', items);

    return app;
}