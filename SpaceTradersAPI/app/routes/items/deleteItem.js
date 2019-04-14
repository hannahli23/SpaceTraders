var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('promise-mysql');
const config = require('../../config');
// let dbconfig = config.dbconfig;
let dbconfig = config.dbconfig;

var sql = "CALL DeleteCargoItem(?)"; // Full name of stored procedure

module.exports = function(req, res, next) {
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
        pool.getConnection(function(err, connection) {
            console.log('hmmmmmmmmmmmmmmmm ' + reqBody.user_id);
            if (err) {
                console.log(err);
                res.status(500).send(err);
                reject(Error(err.message));
                connection.release();
                return reject(err);
            }
            connection.query(sql,[reqBody.user_id], function(err, results, fields) {
                if (err) {
                    return reject(err);
                }
                console.log('changed ' + results.changedRows + ' rows');
                //Return the connection to the pool
                connection.release();
                res.send('changed ' + results.changedRows + ' rows')
                
                resolve();
              });
      }); 
  });  
}
