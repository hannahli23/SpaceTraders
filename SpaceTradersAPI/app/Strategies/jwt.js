var logger = require('winston');
var PassportJwt = require('passport-jwt').Strategy,
    ExtractJwt = require('passport-jwt').ExtractJwt

const jwtSecret = require('../config').jwtSecret
const moment = require('moment');

var jwtStrategy = function(){

    var jwtOpts = {
        secretOrKey: jwtSecret,
        jwtFromRequest: ExtractJwt.fromAuthHeader()
    }

    var returnStrategy = new PassportJwt(jwtOpts, function(jwt_payload, done){

        if (moment().isBefore(jwt_payload.exp * 1000)) {
            logger.info(`${jwt_payload.displayName} has submitted a valid token`);
            return done(null, jwt_payload);
        } 
        else if (moment().isAfter(jwt_payload.exp * 1000)) {
            logger.info(`${jwt_payload.displayName} has submitted an expired token`);
            return done(null, false, {message: 'Expired token'});
        } else {
            return done(null, false, {message: 'Invalid token string'})
            logger.info(`Invalid token string`);
        }        
    });

    return returnStrategy;

}

module.exports = jwtStrategy