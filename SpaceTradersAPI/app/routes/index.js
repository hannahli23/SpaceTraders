const express = require('express');
var logger = require('winston');


var player = require('./player');


logger.info('Routes initialized');

module.exports = function(app){
    console.log('Got Routes');

    app.use('/myapi/player', player);
  
    return app;
}