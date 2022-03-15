var express = require("express");
var app = express();
var user = {
    name: "Jose",
    surname: "Lázaro Salinas",
    dni: "77777777A"
};

app.get('/', function (req, res) {
    res.send("Iyooooooo que dise er tio");
});

app.get('/user', function (req, res) {
    res.json(user);
});

var server = app.listen(8080, function() {

    var port = server.address().port;

    console.log("Escuchando por el puerto " + port + ".");

})