var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('mysql');
const config = require('../../config');
let dbconfig = config.dbconfig;

var sql = "CALL insert_player(?,?,?,?,?,?,?,?,?)"; // Full name of stored procedure

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
                console.log('get req post body is ' + reqBody.username);
                console.log('get req post body is ' + reqBody.currency);
			    if (err) {
                    console.log(err);
                    res.status(500).send(err);
                    reject(Error(err.message));
                    connection.release();
			        return reject(err);
			    }
			    console.log('get req post body is '+ reqBody.player_name);
                console.log('get req post body is '+ reqBody.currency);

                connection.query(sql,[reqBody.user_id, reqBody.player_name,reqBody.currency,
                    reqBody.difficulty, reqBody.fighter_points, reqBody.trader_points, reqBody.engineer_points,
                    reqBody.pilot_points, reqBody.curr_planet], function(err, results, fields) {
                    if (err) {
                        return reject(err);
                    }
                    res.send(results.insertId+"");
                    //Return the connection to the pool
                    connection.release();
                    
                    resolve();
		      	});
          }); 
      });  
}

