function InvalidEmail(input) {    
    input.setCustomValidity(testEmail(input.value));
    return true;
}

function testEmail(valor){

    const emailRegExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (valor === '') {
        return "¡Introduce un e-mail!";
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

    const nombreRegExp = /^[a-zA-Z\s]*$/;
    if (valor === '') {
        return "¡Introduce un nombre!";
    } else if (!nombreRegExp.test(valor)) {
        return "Por favor, introduce un nombre válido";
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
    } else {
        return "";
    }
}

module.exports = { testEmail, testName, testNumber }

