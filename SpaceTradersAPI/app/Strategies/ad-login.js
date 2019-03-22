const passport = require('passport');
const LocalStrategy = require('passport-local');
const ActiveDirectory = require('activedirectory');
const async = require('async');
var logger = require('winston');

const strategyOptions = require('./strategyOptions');
const config = require('../config');



var adStrategy = function(){
    var returnStrategy = new LocalStrategy(strategyOptions, function(username, password, done){

        var sAMAccountName = username;
        var user = {
            username: username + '@' + config.ad.domain,
            password: password,
            roles: []
        }

        // logger.debug('User: ', JSON.stringify(user));


        var ad = new ActiveDirectory(config.ad);

        ad.authenticate(user.username, user.password, function(err, auth){

            if (err) {
                //Log it
                logger.error('ERROR: '+JSON.stringify(err));
                //Return to passport
                return done(null, false, {message: 'Bad username or password', loginErrorCode: 1});
            }
            
            if (auth) {
                //Log it
                //logger.info('Authenticated!');
                
                async.parallel({
                    checkUserAllow: function(callback){
                        checkMembership(user.username, 'APP_CLASS_USER_ALLOW', function(isMember){
                            if (isMember) {
                                user.roles.push('user');
                                return callback(null, true);
                            } else {
                                return callback(null, false);
                            }
                        });
                    }
                    ,
                    checkAdminAllow: function(callback){
                        checkMembership(user.username, 'APP_CLASS_ADMIN_ALLOW', function(isMember){                         
                            if (isMember) {
                                user.roles.push('admin')
                                return callback(null, true);
                            } else {
                                return callback(null, false);
                            }
                        });
                    },
                    checkAdminAuditAllow: function(callback){
                        checkMembership(user.username, 'APP_CLASS_ADMIN_AUDIT_ALLOW', function(isMember){                         
                            if (isMember) {
                                user.roles.push('auditAdmin')
                                return callback(null, true);
                            } else {
                                return callback(null, false);
                            }
                        });
                    },
                    checkUserAuditAllow: function(callback){
                        checkMembership(user.username, 'APP_CLASS_USER_AUDIT_ALLOW', function(isMember){                         
                            if (isMember) {
                                user.roles.push('auditUser')
                                return callback(null, true);
                            } else {
                                return callback(null, false);
                            }
                        });
                    },
                    getUserInfo: function(callback){
                        ad.findUser(sAMAccountName, function(err, adUser) {
                            user.adLogin = adUser.sAMAccountName;
                            user.firstName = adUser.givenName;
                            user.lastName = adUser.sn;
                            user.displayName = adUser.displayName;
                            user.email = adUser.mail;
                            logger.debug('User: ', adUser);
                            return callback(null, true);
                        });
                    }
                    
                }, function(err, results){
                    logger.info('checkUserAllow: ', results.checkUserAllow)
                    logger.info('checkAdminAllow: ', results.checkAdminAllow)
                    if (results.checkUserAllow || results.checkAdminAllow){
                        return done(null, user);
                    } else {
                        return done(null, false, { message: 'Unauthorized', loginErrorCode: 2 });
                    }
                    
                });
                
                
            }
            else {
                //Log it
                logger.info(`Authentication for ${user.username} failed!`);
                //Return to passport
                return done(null, false, {message: 'Wrong username or password'});
            }

        });

    function checkMembership(user, group, callback){
        var ad = new ActiveDirectory(config.ad);

        ad.isUserMemberOf(user, group, function(err, isMember){
            if(isMember){
                
                //logger.debug( user + ' is a member of ' + group);
                ad.getGroupMembershipForUser(user, function(err, groups){
                    if(err){
                        logger.debug('Error getting groups: ', err)
                    } else {
                        logger.debug('Groups: ', JSON.stringify(groups))
                    }
                    return callback(true);
                })
                
            } else {
                logger.debug( user + ' is not a member of ' + group);
                ad.getGroupMembershipForUser(user, function(err, groups){
                    if(err){
                        logger.debug('Error getting groups: ', err)
                    } else {
                        logger.debug('Groups: ', JSON.stringify(groups))
                    }
                    return callback(false);
                })
                
            }
        });
        

    }
        

    });

    return returnStrategy;
};

module.exports = adStrategy;