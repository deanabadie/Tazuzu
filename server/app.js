const express = require('express');
const app = express();
const PORT = 8080;

const bodyParser = require('body-parser');
const winston = require('winston');
const expressWinston = require('express-winston');
const userRouter = require('./src/users/router')();

app.use(bodyParser.json());
//Application level router
app.use(expressWinston.logger({
    transports: [
        new winston.transports.Console({
            json: true,
            colorize: true
        })
    ],
    msg: "HTTP {{req.method}} {{req.url}}",
    colorize: true
}));
app.use('/users', userRouter);

app.listen(PORT, () => {
    console.log(`Now I'm listening on port #${PORT}`);
});