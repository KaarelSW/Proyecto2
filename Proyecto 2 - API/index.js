var express = require("express");
const res = require("express/lib/response");
var app = express();
var hbs = require('hbs');
const port = process.env.PORT || 3001;
const res1 = require('dotenv').config();

var listado = __dirname + '/db.json';

const fs = require("fs");

app.set('view engine', 'hbs');


app.get('/empleados', function (req, res) {
    if (fs.existsSync(listado)) res.sendFile(listado);

    else res.status(404).send("No se encuentra el listado");
});

/* app.get('get/{user}', function (req, res) {
    
}); */

var server = app.listen(port, function() {

    console.log("Escuchando por el puerto " + port + ".");

})

module.exports = server;

