var Promise = require('promise');
const express = require('express')
//var logger = require('winston');
const mysql = require('mysql');
const config = require('../../config');
let dbconfig = config.dbconfig;

var sql = "CALL GetACargoHold(?)"; // Full name of stored procedure

module.exports = function(req, res, next) {
        //logger.debug('COC_Postcocdbinfo is starting');

            var reqBody = req.body;
            var reqParams = req.params.user_id;

            var pool  = mysql.createPool({
                connectionLimit : 10,
                host            : 'localhost',
                user            : 'spacetest',
                password        : '123',
                database        : 'spacetraders'
            });

        return new Promise(function (resolve, reject){ 
             
            pool.getConnection(function(err, connection) {
                console.log('get req post body is ' + reqParams);
			    if (err) {
                    console.log(err);
                    res.status(500).send(err);
                    reject(Error(err.message));
                    connection.release();
			        return reject(err);
			    }
			    console.log('get req post body is '+ reqParams);

			    connection.query(sql,reqParams, function(err, results, fields) {
                    if (err) {
                        return reject(err);
                    }

                    res.send(results[0]);
                    console.log('break');
                    //Return the connection to the pool
                    connection.release();
                    
                    resolve();
		      	});
          }); 
      });  
}
