var express = require("express");
var app = express();


app.get('/get', function (req, res) {
    res.sendFile(__dirname + '/db.json');
});

app.get('get/{user}', function (req, res) {
    res.sendFile(__dirname + '/db.json');
});

var server = app.listen(8080, function () {

    var port = server.address().port;

    console.log("Escuchando por el puerto " + port + ".");

})

module.exports = server;
