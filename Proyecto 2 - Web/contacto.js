function InvalidEmail(input) {    
    input.setCustomValidity(testEmail(input.value));
    return true;
}

function testEmail(valor){

    const emailRegExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (valor === '') {
        return "¡Introduce un e-mail!";
    }else if(valor.length < 3){
        return "El e-mail no puede tener menos de 3 caracteres";
    }else if(valor.length > 254){
        return "El e-mail no puede tener más de 254 caracteres";
    } else if (!emailRegExp.test(valor)) {
        return "Por favor, introduce un e-mail válido";
    } else {
        return "";
    }
}

function InvalidName(input) {    
    input.setCustomValidity(testName(input.value));
    return true;
}

function testName(valor){

    const nombreRegExp = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/;
    if (valor === '') {
        return "¡Introduce un nombre!";
    } else if (!nombreRegExp.test(valor)) {
        return "Por favor, introduce un nombre válido";
    }else if(valor.length < 3){
        return "El nombre no puede tener menos de 3 caracteres";
    }else if(valor.length > 50){
        return "El nombre no puede tener más de 50 caracteres";
    } else {
        return "";
    }
}

function InvalidNumber(input) {    
    input.setCustomValidity(testNumber(input.value));
    return true;
}

function testNumber(valor){

    const nombreRegExp = /^[0-9]*$/;
    const espacio = /\s/;
    if (valor === '') {
        return "¡Introduce un número de teléfono!";
    }else if (espacio.test(valor)){
        return "Por favor, introduce un número sin espacios";
    } else if (!nombreRegExp.test(valor)) {
        return "Por favor, introduce un número válido";
    }else if(valor.length < 3){
        return "El número no puede tener menos de 3 caracteres";
    }else if(valor.length > 15){
        return "El número no puede tener más de 15 caracteres";
    } else {
        return "";
    }
}

function InvalidMensaje(input) {    
    input.setCustomValidity(testMensaje(input.value));
    return true;
}

function testMensaje(valor){

    if (valor === '') {
        return "¡Introduce un mensaje!";
    }else if(valor.length < 3){
        return "El mensaje no puede tener menos de 3 caracteres";
    }else if(valor.length > 300){
        return "El mensaje no puede tener más de 300 caracteres";
    } else {
        return "";
    }
}

module.exports = { testEmail, testName, testNumber, testMensaje }

