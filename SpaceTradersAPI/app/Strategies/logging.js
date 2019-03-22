var logger = require('winston');
logger.level = process.env.LOG_LEVEL || 'debug';

if (logger.level == 'info') {
    logger.remove(logger.transports.Console);
}

logger.add(logger.transports.File, {
    filename: __dirname + '/../logs/classLogging.log',
    maxsize: 1000000,
    timestamp: true
})

logger.info(`Logging initialized at ${logger.level} level`);
logger.info(__dirname + '/../logs');

module.exports = logger;