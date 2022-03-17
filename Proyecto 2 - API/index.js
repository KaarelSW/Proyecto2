var express = require("express");
var app = express();

var listado = __dirname + '/db.json';
const fs = require("fs");

app.get('/get', function (req, res) {
    if (fs.existsSync(listado)) res.sendFile(listado);
    else res.status(404).send("No se encuentra el listado");
});

app.get('/empleado/:usuario', function(req, res) {
    const usuario = req.params.usuario;
    var empleados = require(listado).empleados;
    var datos = empleados.find(x => x.usuario == usuario);
    
    if (JSON.stringify(datos)) res.send(datos);
    else res.status(404).send("Usuario no encontrado");
});

var server = app.listen(8080, function() {

    var port = server.address().port;

    console.log("Escuchando por el puerto " + port + ".");

})

module.exports = server;