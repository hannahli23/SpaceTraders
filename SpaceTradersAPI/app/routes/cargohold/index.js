const express = require('express');
const getCargoHold = require('./getCargoHold');
const postCargoHold = require('./postCargoHold');
const putCargoHold = require('./putCargoHold');
const deleteCargoHold = require('./deleteCargoHold');
const getCargoHoldById = require('./getCargoHoldById');
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


     
    api.route('/').get(getCargoHold)
    api.route('/').post(postCargoHold)
    api.route('/').put(putCargoHold)
    api.route('/').delete(deleteCargoHold)
    api.route('/id/:user_id').get(getCargoHoldById)

    //  .get(passport.authenticate('jwt', {session: false}),getDoc)
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