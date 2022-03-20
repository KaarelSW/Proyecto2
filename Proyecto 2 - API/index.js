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
    else {
        let json404 = {
            status: 404,
            msg: "Lista no encontrada"
        }
        res.status(404).send(json404);
    }
});

app.get('/empleado/:usuario', function(req, res) {
    const usuario = req.params.usuario;
    var empleados = require(listado).empleados;
    var datos = empleados.find(x => x.usuario == usuario);
    
    if (JSON.stringify(datos)) res.send(datos);
    else {
        let json404 = {
            status: 404,
            msg: "Usuario no encontrado"
        }
        res.status(404).send(json404);
    }
});

var server = app.listen(port, function() {

    console.log("Escuchando por el puerto " + port + ".");

})

module.exports = server;