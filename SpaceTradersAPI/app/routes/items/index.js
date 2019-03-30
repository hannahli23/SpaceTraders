const express = require('express');
const getItem = require('./getItem');
const postItem = require('./postItem');
const putItem = require('./putItem');
const deleteItem = require('./deleteItem');
const passport = require('passport');
const getItemsById = require('./getItemById');

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


     
    api.route('/').get(getItem)
    api.route('/').post(postItem)
    api.route('/').put(putItem)
    api.route('/').delete(deleteItem)
    api.route('/id/:user_id').get(getItemsById)

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