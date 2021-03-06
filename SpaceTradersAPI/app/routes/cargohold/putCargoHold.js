var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('promise-mysql');
const config = require('../../config');
// let dbconfig = config.dbconfig;
let dbconfig = config.dbconfig;

// var sql = 'SELECT * FROM city';
var sql = "CALL UpdateCargoHold(?, ?)"; // Full name of stored procedure

module.exports = function(req, res, next) {
    //logger.debug('COC_Postcocdbinfo is starting');

        var reqBody = req.body;
        var reqParams = req.params;

        var pool  = mysql.createPool({
            connectionLimit : 10,
            host            : 'localhost',
            user            : 'spacetest',
            password        : '123',
            database        : 'spacetraders'
        });
    return new Promise(function (resolve, reject){ 
        // var pool  = mysql.createPool(dbconfig);
        console.log('get req post body is ');
         
        pool.getConnection(function(err, connection) {
            console.log('putCargo ' + reqBody.user_id);
            console.log('putCargo  ' + reqBody.curr_size);
            if (err) {
                console.log(err);
                res.status(500).send(err);
                reject(Error(err.message));
                connection.release();
                return reject(err);
            }

            connection.query(sql,[reqBody.user_id, reqBody.curr_size], function(err, results, fields) {
                if (err) {
                    return reject(err);
                }
                console.log('changed ' + results.changedRows + ' rows');
                //Return the connection to the pool
                connection.release();
                
                resolve();
              });
      }); 
  });  
}
