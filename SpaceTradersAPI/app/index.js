// Set UV_THREADPOOL_SIZE to match number of max connections in pool
process.env.UV_THREADPOOL_SIZE=100

// When process is terminated, close down connection pool gracefull
process.on('SIGINT', function() {
    process.exit(0);
})

const express = require('express')
      ,cors = require('cors');
const passport = require('passport');
var GoogleStrategy = require('passport-google-oauth').OAuth2Strategy;
const bodyParser = require('body-parser');
var colors = require('colors');
// const oracledb = require('oracledb');
const mssqldb = require('mssql');



//oracledb.stmtCacheSize = 0;

// logging import - setup winston server and import strategy to write logs to it
var logger = require('./Strategies/logging');
var adStrategy = require('./Strategies/ad-login');
const jwtStrategy = require('./Strategies/jwt');


//custom modules
const config = require('./config');

// initialize Express
const app = express()

app.use(bodyParser.urlencoded({limit: '1mb', extended:true}));
app.use(bodyParser.json({limit: '1mb'}));

// after the code that uses bodyParser and other cool stuff
var originsWhitelist = [
  'http://localhost:4200',      //this is my front-end url for development
  
];
var corsOptions = {
  origin: function(origin, callback){
        var isWhitelisted = originsWhitelist.indexOf(origin) !== -1;
        callback(null, isWhitelisted);
  },
  credentials:true
}
//here is the magic
app.use(cors(corsOptions));


// Init Passport
app.use(passport.initialize())

 passport.serializeUser(function(user, done){
     done(null, user);
 });

 passport.deserializeUser(function(){
    done(null, user);
});

passport.use('ad-login', new adStrategy());
passport.use('jwt', new jwtStrategy());
// passport.use('google-login', new googleStrategy());
passport.use(new GoogleStrategy({
    clientID: '722672775741-q9gjggldku9ri1533hjjb1bg2k7apoek.apps.googleusercontent.com',
    clientSecret: 'VJGtdwyl6DTVFaI1jCuJBcR1',
    callbackURL: 'http://localhost:9080/auth/google/callback',
  },
  function(accessToken, refreshToken, profile, cb) {
    User.findOrCreate({ googleId: profile.id }, function (err, user) {
      return cb(err, user);
    });
  }
));

app.use(function(req, res, next){
    
    //  res.header('Access-Control-Allow-Origin', '*');
     res.header('Access-Control-Allow-Origin', 'http://localhost:4200');
     res.header('Access-Control-Allow-Credentials', true);
    // res.header('Access-Control-Allow-Headers', 'Content-Type,X-Requested-With,X-Access-Token, Authorization');
    res.header('Access-Control-Allow-Headers', 'Content-Type, Authorization');
    res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
    res.header('Cache-Control', 'no-cache');


    next();
});



app.listen(9080, () => {
    console.log('Listening on port 9080');
    require('./routes')(app);
})