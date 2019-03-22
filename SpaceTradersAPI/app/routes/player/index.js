const express = require('express');
// const getPkgQuestions = require('./getPkgQuestions');
const getPlayer = require('./getPlayer');
const postPlayer = require('./postPlayer');
const putPlayer = require('./putPlayer');
const deletePlayer = require('./deletePlayer');
//const getPkgQuestions = require('../lct/getDoc');
// const postDoc = require('./postDoc');
const passport = require('passport');

module.exports = (function(){
    console.log('got AMCDB Route');
     var api = express.Router();

//  api.use(function(req, res, next){
    
//     res.header('Access-Control-Allow-Origin', '*');
//     res.header('Access-Control-Allow-Headers', 'Content-Type, Authorization');
//     res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
//     res.header('Cache-Control', 'no-cache');


//     next();
// });


     
    api.route('/').get(getPlayer)
        //  .get(passport.authenticate('jwt', {session: false}),getDoc)

    api.route('/').post(postPlayer)
    api.route('/').put(putPlayer)
    api.route('/').delete(deletePlayer)
    //     .post(passport.authenticate('jwt', {session: false}),postDoc) 

      
    //       api.get('/auth/google',
    //           passport.authenticate('google', { scope: ['profile'] }));

        //  api.route('/auth/google')
        //       .get(passport.authenticate('google', { scope: ['profile'] })); 

        api.route('/auth/google',
              passport.authenticate('google', { scope: ['profile'] }));

       api.route('/auth/google/callback', 
              passport.authenticate('google', { failureRedirect: '/login' }),
          function(req, res) {
       // Successful authentication, redirect home.
           res.redirect('/');
            });   

      // api.route('/')
      //   .put(putUDW)     
 
      return api;  
    
})();