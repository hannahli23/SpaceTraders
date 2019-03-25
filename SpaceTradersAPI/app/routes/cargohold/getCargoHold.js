var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('promise-mysql');
const config = require('../../config');
// let dbconfig = config.dbconfig;
let dbconfig = config.dbconfig;

// var sql = 'SELECT * FROM city';
var sql = "CALL GetAllCargoHold()"; // Full name of stored procedure

module.exports = function (req, res, next) {
    //logger.debug('CALL getAllcity is starting');
    console.log("test");
    var reqBody = req.body;
    var reqParams = req.params;

    var pool = mysql.createPool({
        connectionLimit : 10,
        host            : 'localhost',
        user            : 'spacetest',
        password        : '123',
        database        : 'spacetraders'
    });

    //  var pool  = mysql.createPool(dbconfig);


    return new Promise(function (resolve, reject) {
        // var pool  = mysql.createPool(dbconfig);
        pool.getConnection(function (err, connection) {
            console.log('get req post body is ');
            if (err) {
                return reject(err);
            }

            connection.query(sql, function (err, results, fields) {

                if (err) {
                    return reject(err);
                }
                console.log('result from stored procedure is ', results[0][1]);
                //     
                res.send(results[0]);
                // res.send(fields);
                //  resolve(result.recordsets[0]);
                //  res.send(result.recordsets[0]);


                //Return the connection to the pool
                connection.release();

                resolve();
            });
        });
    });


}