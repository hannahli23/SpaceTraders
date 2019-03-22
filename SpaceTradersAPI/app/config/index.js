module.exports = {
    port: process.env.port || 8000,
    
    opts: {
        timeLimit: 100
    },
    jwtSecret: process.env.JWTSECRET || 'secret',
    tokenTimeout: 1440, //in Minutes
    role: {
        licenseAdmin: "admin",
        user: "user",
        auditUser: "auditUser",
        auditAdmin: "auditAdmin"
    },
    dbconfig: {
         user: 'testSEC',
         password: 'testsec', //process.env.mspass
         server: 'vws12c10\\itinfrastructure', 
         database: 'cocdbmgmtDEV'
     },

       dbconfig2: {
            connectionLimit : 10,
            host            : 'localhost',
            user            : 'root',
            password        : 'test',
            database        : 'world'
     },
    dbconfigm: {
    connectionLimit : 10,
      host            : 'localhost',
      user            : 'root',
      password        : 'test',
      database        : 'world'
}

}