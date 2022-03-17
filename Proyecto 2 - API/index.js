var express = require("express");
var app = express();


app.get('/get', function (req, res) {
    res.sendFile(__dirname + '/db.json');
});

app.get('/empleado/:usuario', function(req, res) {
    const usuario = req.params.usuario;
    var empleados = require(__dirname + '/db.json').empleados;
    var datos = empleados.find(x => x.usuario == usuario);
    
    if (JSON.stringify(datos)) res.send(datos);
    else res.status(404).send("Usuario no encontrado");
});

var server = app.listen(8080, function() {

    var port = server.address().port;

    console.log("Escuchando por el puerto " + port + ".");

})

module.exports = server;