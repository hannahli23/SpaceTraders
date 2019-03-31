var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('mysql');
const config = require('../../config');
let dbconfig = config.dbconfig;

var sql = "CALL insert_ship(?,?,?,?,?,?,?,?,?,?)"; // Full name of stored procedure

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
                console.log('get req post body is ' + reqBody.ship_name);
                console.log('get req post body is ' + reqBody.ship_type);
                console.log('get req post body is ' + reqBody.user_id);
			    if (err) {
                    console.log(err);
                    res.status(500).send(err);
                    reject(Error(err.message));
                    connection.release();
			        return reject(err);
			    }
			    console.log('get req post body is ' + reqBody.ship_name);
                console.log('get req post body is ' + reqBody.ship_type);
                console.log('get req post body is ' + reqBody.user_id);

                connection.query(sql,[reqBody.ship_name, reqBody.ship_type,
                    reqBody.hull_strength, reqBody.weapon_slots, reqBody.shield_slots,
                    reqBody.gadget_slots, reqBody.crew_quarters, reqBody.travel_range,
                    reqBody.escape_pod, reqBody.user_id], function(err, results, fields) {
                    if (err) {
                        console.log('dslkfmldsk');
                        console.log(err);
                        return reject(err);
                    }
                    console.log('changed ' + results.changedRows + ' rows');
                    //console.log(results.insertId);
                    res.send(results.changedRows + '   ' + results.insertId);
                    //Return the connection to the pool
                    connection.release();
                    
                    resolve();
		      	});
          }); 
      });  
}

